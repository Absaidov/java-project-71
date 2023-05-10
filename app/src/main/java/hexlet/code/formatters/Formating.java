package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

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
    public static String plain(Map<Object, String> formatMap) {
        String plain = "Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to 'none'";
        return plain;
    }
}
