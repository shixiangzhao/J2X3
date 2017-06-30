package shixzh.j2x3.y2017.m06.d29;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TestBeak {

    public static void main(String[] args) {
        getAllPmCountersByAttribute("pmCellDowntimeAuto");
    }
    private static Map<String, Integer> getAllPmCountersByAttribute(String pmCounterName) {
        boolean isPmCounterNormal = false;
        Map<String, Integer> counterMap = new HashMap<>();
        while (!isPmCounterNormal) {
            String result = "EUtranCellFDD=1                                         pmCellDowntimeAuto 0\nEUtranCellFDD=2                                         pmCellDowntimeAuto 0";
            counterMap.clear();
            isPmCounterNormal = true;
            String[] lines = result.split("\n");
            for (String line : lines) {
                if (!line.contains(pmCounterName)) {
                    continue;
                }
                int endIndex = line.indexOf(pmCounterName);
                String key = line.substring(0, endIndex).trim();
                int value = 0;
                if (value < 0) {
                    isPmCounterNormal = false;
                    break;
                }
                counterMap.put(key, value);
            }
        }
        return counterMap;
    }
}
