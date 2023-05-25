package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.TreeMap;


public class Parser {
    public static TreeMap<String, Object> parser(String data, String format) throws RuntimeException, IOException {
        switch (format) {
            case "json" -> {
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(data, new TypeReference<>() {
                });
            }
            case "yml" -> {
                ObjectMapper objectMapperYml = new ObjectMapper(new YAMLFactory());
                return objectMapperYml.readValue(data, new TypeReference<>() {
                });
            }
            default -> throw new RuntimeException("Unknown format " + format);
        }
    }
}
