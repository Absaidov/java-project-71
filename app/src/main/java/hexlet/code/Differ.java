package hexlet.code;

import java.io.File;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import static hexlet.code.Parser.mapFileParse1;
import static hexlet.code.Parser.mapFileParse2;


public class Differ {
    public static ObjectMapper objectMapper = new ObjectMapper();
//    public static ObjectMapper YAMLmapper = new YAMLMapper();
    public static String generate(File file1, File file2) throws Exception {
        Map<String, Object> parsinFile1 = mapFileParse1(file1);
        Map<String, Object> parsinFile2 = mapFileParse2(file2);
        Map<String, Object> mapFile3 = new LinkedHashMap<>();

        for (Map.Entry<String, Object> mapFile1s : parsinFile1.entrySet()) {
            for (Map.Entry<String, Object> mapFile2s : parsinFile2.entrySet()) {

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

        for (Map.Entry<String, Object> mapFile2s : parsinFile2.entrySet()) {
            for (Map.Entry<String, Object> mapFile1s : parsinFile1.entrySet()) {

                var mapFiles2Key = mapFile2s.getKey();
                var mapFiles2Value = mapFile2s.getValue();
                var mapFiles1Key = mapFile1s.getKey();
                var mapFiles1Value = mapFile1s.getValue();

                if (!mapFiles2Key.equals(mapFiles1Key) && !mapFiles2Value.equals(mapFiles1Value)) {
                    if (mapFiles2Key.equals("host")) {
                        continue;
                    }
                    mapFile3.put("+ " + mapFile2s.getKey(), mapFile2s.getValue());
                    break;
                }
            }
        }
        String map3ToJsonToString = objectMapper
                .writeValueAsString(mapFile3)
                .replaceAll("\"", "")
                .replaceAll(",", ",\n")
                .replaceAll("ho", "  ho");
        String result = "{\n" + map3ToJsonToString.substring(1);
        return result.replace("}", "\n}");
    }
}

