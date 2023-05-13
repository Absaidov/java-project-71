package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Map;

import static hexlet.code.formatters.Formating.plain;
import static hexlet.code.formatters.Formating.stylish;
import static hexlet.code.formatters.Formating.json;


public class Formatter {
    public static String choiceFormat(Map<Object, String> formatMap, String format) throws JsonProcessingException {
        if (format.equals("stylish")) {
            return stylish(formatMap);
        } else if (format.equals("plain")) {
            return plain(formatMap);
        } else if (format.equals("json")) {
            return json(formatMap);
        }
        return "SOMETHING GOES WRONG";
    }
}
