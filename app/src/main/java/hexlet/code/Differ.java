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
    public static String generate(File file1, File file2) throws Exception {
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
                var mapFiles2Key = mapFile2s.getKey();
                var mapFiles2Value = mapFile2s.getValue();
                var mapFiles1Key = mapFile1s.getKey();
                var mapFiles1Value = mapFile1s.getValue();

                if (!mapFiles1Key.equals(mapFiles2Key) && !mapFiles1Value.equals(mapFiles2Value)) {
                    mapFile3.put("- " + mapFile1s.getKey(), mapFile1s.getValue());
                    break;
                }
                if (mapFiles1Key.contains(mapFiles2Key) && mapFiles1Value.equals(mapFiles2Value)) {
                    mapFile3.put(mapFile1s.getKey(), mapFile1s.getValue());
                    break;
                }
            }
        }

        for (Map.Entry<String, Object> mapFile2s : mapFile2.entrySet()) {
            for (Map.Entry<String, Object> mapFile1s : mapFile1.entrySet()) {

                var mapFiles2Key = mapFile2s.getKey();
                var mapFiles2Value = mapFile2s.getValue();
                var mapFiles1Key = mapFile1s.getKey();
                var mapFiles1Value = mapFile1s.getValue();

                if (!mapFiles2Key.equals(mapFiles1Key) && !mapFiles2Value.equals(mapFiles1Value)) {
                    if (mapFiles2Key.equals("host")){
                        continue;
                    }
                    mapFile3.put("+ " + mapFile2s.getKey(), mapFile2s.getValue());
                    break;
                }
                }
            }
        String map3ToJsonToString = objectMapper.writeValueAsString(mapFile3).replaceAll("\"", "");
        map3ToJsonToString.replaceAll(",",",\n");
//                System.out.println(jsonString);
        return map3ToJsonToString;
        }
    }

