package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Map;

import static hexlet.code.formatters.Formating.plain;
import static hexlet.code.formatters.Formating.stylish;

public class Formatter {
    public static String choiceFormat(Map<Object, String> formatMap, String format) throws JsonProcessingException {
        if (format.equals("stylish")) {
            return stylish(formatMap);
        } else if (format.equals("plain")) {
            return plain(formatMap);
        }
        return "SOMETHING GOES WRONG";
    }
}
