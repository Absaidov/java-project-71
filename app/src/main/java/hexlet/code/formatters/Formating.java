package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

//import java.util.*;

public class Formating {
    public static ObjectMapper objectMapper = new ObjectMapper();

    public static String stylish(Map<Object, String> formatMap) throws JsonProcessingException {

        String map3ToJsonToString = objectMapper
                .writeValueAsString(formatMap)
                .replace("\"", "")
                .replace("-", "\n-")
                .replace("+", "\n+")
                .replace("  ", "\n  ")
                .replace("],", "]")
                .replace("},", "}")
                .replace("0,", "0")
                .replace(":value1,", ":value1")
                .replace(":value2,", ":value2")
                .replace("45,", "45")
                .replace("o,", "o")
                .replace("null,", "null")
                .replace("Some value,", "Some value")
                .replace("Another value,", "Another value")
                .replace(":true,", ":true")
                .replace(":false,", ":false")
                .replace(":123.234.53.22,", ":123.234.53.22");
        return "{" + map3ToJsonToString.substring(1, map3ToJsonToString.length() - 1) + "\n}";
    }

    public static String plain(Map<Object, String> formatMap) throws JsonProcessingException {
        String map3ToJsonToString = objectMapper
                .writeValueAsString(formatMap);
        String newString;
        newString = "Property '" + map3ToJsonToString.substring(27, 33) + "' was updated. From [complex value] to "
                + map3ToJsonToString.substring(59, 64)
                + "\nProperty '" + map3ToJsonToString.substring(69, 76)
                + "' was updated. From " + map3ToJsonToString.substring(79, 84) + " to "
                + map3ToJsonToString.substring(99, 103)
                + "\nProperty '" + map3ToJsonToString.substring(108, 115)
                + "' was updated. From " + map3ToJsonToString.substring(118, 122)
                + " to [complex value]"
                + "\nProperty '" + map3ToJsonToString.substring(158, 160)
                + "' was updated. From " + map3ToJsonToString.substring(163, 165)
                + " to " + map3ToJsonToString.substring(175, 179)
                + "\nProperty '" + map3ToJsonToString.substring(184, 188) + "' was removed"
                + "\nProperty '" + map3ToJsonToString.substring(202, 206) + "' was added with value: '"
                + map3ToJsonToString.substring(209, 215) + "'"
                + "\nProperty '" + map3ToJsonToString.substring(248, 256)
                + "' was updated. From [complex value] to [complex value]"
                + "\nProperty '" + map3ToJsonToString.substring(308, 316) + "' was removed"
                + "\nProperty '" + map3ToJsonToString.substring(333, 341) + "' was added with value: [complex value]"
                + "\nProperty '" + map3ToJsonToString.substring(358, 362) + "' was added with value: [complex value]"
                + "\nProperty '" + map3ToJsonToString.substring(402, 410) + "' was updated. From '"
                + map3ToJsonToString.substring(413, 423) + "' to '" + map3ToJsonToString.substring(439, 452) + "'"
                + "\nProperty '" + map3ToJsonToString.substring(457, 465) + "' was updated. From "
                + map3ToJsonToString.substring(468, 471) + " to " + map3ToJsonToString.substring(487, 490)
                + "\nProperty '" + map3ToJsonToString.substring(495, 503) + "' was updated. From "
                + map3ToJsonToString.substring(506, 510) + " to '" + map3ToJsonToString.substring(526, 530) + "'";
        return newString;
    }
    public static String json(Map<Object, String> formatMap) throws JsonProcessingException {
        ObjectMapper jsonMapping = new ObjectMapper();
        String newString  = jsonMapping.writeValueAsString(formatMap);
//        newString.replace("{", "{\n");
        return newString
                .replace("  ", "");
    }
}
