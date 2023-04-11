package hexlet.code;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Differ {
    public static Map<String, Object> generate(File file1, File file2) throws Exception {
        Path path = Paths.get(file1.toURI()).toAbsolutePath().normalize();
        Path path2 = Paths.get(file2.toURI()).toAbsolutePath().normalize();

        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }

        String content = Files.readString(path);
        String content2 = Files.readString(path2);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> mapFile3 = new LinkedHashMap<>();

        Map<String, Object> mapFile1 = objectMapper.readValue(content,
                new TypeReference<TreeMap<String, Object>>() {
                });

        Map<String, Object> mapFile2 = objectMapper.readValue(content2,
                new TypeReference<TreeMap<String, Object>>() {
                });

        for (Map.Entry<String, Object> mapFile1s : mapFile1.entrySet()) {
            for (Map.Entry<String, Object> mapFile2s : mapFile2.entrySet()) {
                if (!mapFile1s.getKey().equals(mapFile2s.getKey()) && !mapFile1s.getValue().equals(mapFile2s.getValue())) {
                    mapFile3.put("- " + mapFile1s.getKey(), mapFile1s.getValue());
                    break;
                }
                if (mapFile1s.getKey().contains(mapFile2s.getKey()) && mapFile1s.getValue().equals(mapFile2s.getValue())) {
                    mapFile3.put(mapFile1s.getKey(), mapFile1s.getValue());
                    break;
                }

            }
        }
        for (Map.Entry<String, Object> mapFile2s : mapFile2.entrySet()) {
            for (Map.Entry<String, Object> mapFile1s : mapFile1.entrySet()) {
//                var name1 =
                var mapFiles2Key = mapFile2s.getKey();
                var mapFiles2Value = mapFile2s.getValue();
                var mapFiles1Key = mapFile1s.getKey();
                var mapFiles1Value = mapFile1s.getValue();
                System.out.println(mapFiles2Key + " 2");
                System.out.println(mapFiles1Key + " 1");
                if (mapFiles2Key.equals(mapFiles1Key) && !mapFiles2Value.equals(mapFiles1Value)) {
                    mapFile3.put("+ " + mapFile2s.getKey(), mapFile2s.getValue());
//                    System.out.println(mapFiles1Key);
                    break;
                }
                if (mapFile2s.getKey().equals(mapFile1s.getKey()) && mapFile2s.getValue().equals(mapFile1s.getValue())) {
                    mapFile3.put(mapFile2s.getKey(), mapFile2s.getValue());
                    break;
                }
//                if (!mapFiles2Key.equals(mapFiles1Key) && !mapFiles2Value.equals(mapFiles1Value)){
//                    mapFile3.put("+ " + mapFile2s.getKey(), mapFile2s.getValue());
////                    System.out.println(mapFiles2Key);
////                    System.out.println(mapFiles2Value);
////                    System.out.println(mapFiles2Key);
//                    System.out.println(mapFiles1Key);
//                    break;
//                }


//                if (mapFiles2Key.equals(mapFiles1Key) && mapFiles2Value.equals(mapFiles1Value)){
////                    System.out.println(mapFiles1Key);
////                    System.out.println(mapFiles1Value);
//                    break;
//                }
//                if (!mapFiles2Key.equals(mapFiles1Key) && !mapFiles2Value.equals(mapFiles1Value)){
//                    mapFile3.put("+ " + mapFile2s.getKey(), mapFile2s.getValue());
////                    System.out.println(mapFiles2Key);
////                    System.out.println(mapFiles2Value);
////                    System.out.println(mapFiles2Key);
//                    System.out.println(mapFiles1Key);
//                    break;
//                }
            }
        }
        return mapFile3;
    }
}
