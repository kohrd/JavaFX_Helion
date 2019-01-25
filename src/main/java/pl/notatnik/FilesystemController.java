package pl.notatnik;

import com.sun.org.apache.regexp.internal.RE;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Properties;
import java.util.stream.Stream;

import static java.nio.file.Files.readAllLines;


public class FilesystemController {

    private static final ObservableList<Path> RECENTS = FXCollections.observableArrayList();
    private static final String RECENTS_FILE = "recent.xml";
    private static File f;
    private static Properties p = new Properties();


    static Stream<String> openFile(File file) throws IOException {
        // ok
        f = file;
        return Files.readAllLines(f.toPath()).stream();
    }

    static void closeFile() {
        boolean isThere = false;
        for (Path p : RECENTS) {
            if (p.toFile().getAbsolutePath().equals(f.getAbsolutePath())) {
                isThere = true;
                break;
            }
        }
        if (!isThere) {
            RECENTS.add(f.toPath());
        }
        saveRecentsToFile();
    }

    static void saveFile(Iterable<CharSequence> i, String charset) throws IOException {
        if (f != null) {
            Charset c = getCharset(charset != null ? charset : "UTF-8");
            Files.write(f.toPath(), i, c, StandardOpenOption.TRUNCATE_EXISTING);
        }
    }


    static ObservableList<Path> loadRecents() throws IOException {
        if (new File(RECENTS_FILE).exists()) {
            InputStream in = new FileInputStream(RECENTS_FILE);

            p.loadFromXML(in);
            p.forEach((x, y) -> {
                RECENTS.add(Paths.get(y.toString()));
            });
        }
        return RECENTS;


    }

    private static void saveRecentsToFile() {
        RECENTS.forEach(recentPath -> {
            p.setProperty(recentPath.getFileName().toString(), recentPath.toFile().getAbsolutePath());

        });
    }

    static ObservableList getRecents() {
        return RECENTS;
    }

    private static Charset getCharset(String s) {
        return Charset.forName(s);
    }
}
