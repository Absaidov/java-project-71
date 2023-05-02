package hexlet.code;

import java.io.File;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

//import static com.fasterxml.jackson.core.io.doubleparser.AbstractNumberParser.charAt;
import static hexlet.code.Parser.mapFileParse1;
import static hexlet.code.Parser.mapFileParse2;


public class Differ {
    public static ObjectMapper objectMapper = new ObjectMapper();
//    public static ObjectMapper YAMLmapper = new YAMLMapper();
    public static String generate(File file1, File file2) throws Exception {

        Map<String, Object> parsinFile1 = mapFileParse1(file1);
        Map<String, Object> parsinFile2 = mapFileParse2(file2);
        Map<String, Object> mapFile3 = new LinkedHashMap<>();
//        System.out.println(parsinFile1);

        for (Map.Entry<String, Object> mapFile1s : parsinFile1.entrySet()) {
//            System.out.println(mapFiles1Value);
            for (Map.Entry<String, Object> mapFile2s : parsinFile2.entrySet()) {

                var mapFiles1Key = mapFile1s.getKey();
                var mapFiles2Key = mapFile2s.getKey();

                var mapFiles1Value = mapFile1s.getValue().toString();
                var mapFiles2Value = mapFile2s.getValue().toString();

                if (!mapFiles1Key.equals(mapFiles2Key) && !mapFiles1Value.equals(mapFiles2Value)) {
                    mapFile3.put("- " + mapFiles1Key, mapFiles1Value);
                    break;
                }
                if (mapFiles1Key.contains(mapFiles2Key) && mapFiles1Value.equals(mapFiles2Value)) {
                    mapFile3.put("  " + mapFiles1Key, mapFiles1Value);
                    break;
                }
            }
        }

        for (Map.Entry<String, Object> mapFile2s : parsinFile2.entrySet()) {
            for (Map.Entry<String, Object> mapFile1s : parsinFile1.entrySet()) {
                var mapFiles1Key = mapFile1s.getKey();
                var mapFiles2Key = mapFile2s.getKey();

                var mapFiles1Value = mapFile1s.getValue().toString();
                var mapFiles2Value = mapFile2s.getValue().toString();
                if (!mapFiles2Key.equals(mapFiles1Key) && !mapFiles2Value.equals(mapFiles1Value)) {
                    if (mapFiles2Key.equals("host")) {
                        continue;
                    }
//                    System.out.println(mapFiles2Value);
                    mapFile3.put("+ " + mapFiles2Key, mapFiles2Value);
                    break;
                }
            }
        }
//        for (Map.Entry<String, Object> mapFile3s : mapFile3.entrySet()) {
//            System.out.println("{" +
//                    mapFile3s.getKey() + ":" + mapFile3s.getValue() +
//                    "}");
//        }

        String map3ToJsonToString = objectMapper
                .writeValueAsString(mapFile3)
                .replace("\"", "")
                .replace("-", "\n-")
                .replace("+","\n+")
                .replace("host","\n  host");
        String result = "{\n" + map3ToJsonToString.substring(1);
        System.out.println(result.length() - 1);
//        String replace = result.replace(result.charAt(55), "\n}");

//        return result.replace("}", "\n}");
//        System.out.println(replace);
        return result;

//        return null;
    }
}

