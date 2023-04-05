package hexlet.code;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    public static Map<String, String> generate(File file1, File file2) throws Exception {

            Path path = Paths.get(file1.toURI()).toAbsolutePath().normalize();
            Path path2 = Paths.get(file2.toURI()).toAbsolutePath().normalize();
            if (!Files.exists(path)) {
                throw new Exception("File '" + path + "' does not exist");
            }
            String content = Files.readString(path);
            String content2 = Files.readString(path2);
            
            System.out.println(content);
            System.out.println(content2);
            return null;
    }

}
