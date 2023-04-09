package hexlet.code;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.util.HashMap;
import java.util.HashMap;
import java.util.Map;

//import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.*;

public class Differ {
    public static String generate(File file1, File file2) throws Exception {
        Path path = Paths.get(file1.toURI()).toAbsolutePath().normalize();
        Path path2 = Paths.get(file2.toURI()).toAbsolutePath().normalize();

        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }
        String content = Files.readString(path);
        String content2 = Files.readString(path2);
        Map<String, Object> mapFile3 = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> mapFile1 = new HashMap<>();
        mapFile1
                = objectMapper.readValue(content, new TypeReference<Map<String, Object>>() {
        });

        Map<String, Object> mapFile2
                = objectMapper.readValue(content2, new TypeReference<Map<String, Object>>() {
        });
//        System.out.println(content);
//        System.out.println(content2);
//        System.out.println();
//        System.out.println(mapFile1);
//        System.out.println(mapFile2);
//        System.out.println(mapFile1.entrySet());
        for (Map.Entry<String, Object> mapFile1s : mapFile1.entrySet()) {
            for (Map.Entry<String, Object> mapFile2s : mapFile2.entrySet()){
                if (mapFile1s.getKey().equals(mapFile2s.getKey()) && mapFile1s.getValue().equals(mapFile2s.getValue())){
                    mapFile3.put(mapFile1s.getKey(), mapFile1s.getValue());
                }

                if(mapFile1s.getKey().equals(mapFile2s.getKey()) && !(mapFile1s.getValue().equals(mapFile2s.getValue()))){
                    System.out.println("- " + mapFile1s.getKey() + ":" + " " +  mapFile1s.getValue());
                }

//                if(mapFile1s.getKey().equals(mapFile2s.getKey()) && !(mapFile1s.getValue().equals(mapFile2s.getValue()))){
//                    mapFile3.put(mapFile1s.getKey(), mapFile1s.getValue());
////                    mapFile3.put(mapFile2s.getKey(), mapFile2s.getValue());
////                    System.out.println(mapFile2s.getKey());
////                    System.out.println(mapFile2s.getValue());
////                    System.out.println(mapFile1s.getKey());
////                    System.out.println(mapFile1s.getKey());
////                    System.out.println(mapFile1s.getValue());
//                }
//                if(mapFile1s.getKey().equals(mapFile2s.getKey()) && !(mapFile1s.getValue().equals(mapFile2s.getValue()))){
////                    mapFile3.put(mapFile1s.getKey(), mapFile1s.getValue());
//                    mapFile3.put(mapFile2s.getKey(), mapFile2s.getValue());
////                    System.out.println(mapFile2s.getKey());
////                    System.out.println(mapFile2s.getValue());
////                    System.out.println(mapFile1s.getKey());
////                    System.out.println(mapFile1s.getKey());
////                    System.out.println(mapFile1s.getValue());
//                }
            }

//            System.out.println(
//                    "My key is = " + mapFile1s.getKey() + " my value is = " + mapFile1s.getValue()


        }
        System.out.println(mapFile3);

//    public static Map getData(String content) throws Exception {
//        return parse(content);
//    }

        return content;
    }
}
