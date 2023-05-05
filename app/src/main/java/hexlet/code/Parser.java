package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Map;
//import java.util.Objects;
import java.util.TreeMap;




public class Parser {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final ObjectMapper YAML_MAPPER = new YAMLMapper();
    public static Map<String, Object> mapFile1;
    public static Map<String, Object> mapFile2;


    public static Map<String, Object> mapFileParse1(File file1) throws IOException {

        Path path = Paths.get(file1.toURI()).toAbsolutePath().normalize();

        String content = Files.readString(path);
//        if (path.endsWith("filepath1.json")) {
        mapFile1 = OBJECT_MAPPER.readValue(content,
                    new TypeReference<TreeMap<String, Object>>() {

            });
//        }

//        if (path.endsWith("filepath1.yml")) {
//            mapFile1 = YAML_MAPPER.readValue(content,
//                    new TypeReference<TreeMap<String, Object>>() {
//                    });
//        }

        return mapFile1;
    }
    public static Map<String, Object> mapFileParse2(File file2) throws IOException {

        Path path2 = Paths.get(file2.toURI()).toAbsolutePath().normalize();
        String content2 = Files.readString(path2);
//        if (path2.endsWith("filepath2.json")) {
        mapFile2 = OBJECT_MAPPER.readValue(content2,
                    new TypeReference<TreeMap<String, Object>>() {
            });
//        }
//        if (path2.endsWith("filepath2.yml")) {
//            mapFile2 = YAML_MAPPER.readValue(content2,
//                    new TypeReference<TreeMap<String, Object>>() {
//                    });
//        }
        return mapFile2;
    }
}
