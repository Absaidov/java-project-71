package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;


import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatStyle(
            List<Map<String, Object>> differences, String format) throws Exception {
        return switch (format) {
            case "stylish" -> Stylish.formatStylish(differences);
            case "plain" -> Plain.formatPlain(differences);
            case "json" -> Json.formatJson(differences);
            default -> throw new Exception("This format is not available " + format);
        };
    }
}
