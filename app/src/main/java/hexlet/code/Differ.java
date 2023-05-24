package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String pathfile1, String pathfile2, String format) throws Exception {
        Map<String, Object> map1 = getData(pathfile1);
        Map<String, Object> map2 = getData(pathfile2);


        List<Map<String, Object>> result = GenDifference.differ(map1, map2);

        return Formatter.formatStyle(result, format);
    }
    public static String generate(String pathfile1, String pathfile2) throws Exception {
        return generate(pathfile1, pathfile2, "stylish");
    }

    private static Map<String, Object> getData(String filePath) throws Exception {
        Path fullPath = getFullPath(filePath);

        if (!Files.exists(fullPath)) {
            throw new Exception("File '" + fullPath + "' does not exist");
        }

        String content = Files.readString(fullPath);
        String dataFormat = getDataFormat(filePath);
        return Parser.parser(content, dataFormat);
    }

    private static String getDataFormat(String format) {
        return format;
    }
    private static Path getFullPath(String fileName) {
        return Paths.get(fileName)
                .toAbsolutePath().normalize();
    }
}
