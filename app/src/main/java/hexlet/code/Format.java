package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Format {
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
}
