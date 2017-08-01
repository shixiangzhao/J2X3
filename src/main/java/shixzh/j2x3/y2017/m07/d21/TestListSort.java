package shixzh.j2x3.y2017.m07.d21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestListSort {

    public static void main(String[] args) {
        List<String> rbsList = new ArrayList<>();
        String rbs1 = null;
        String rbs2 = "";
        String rbs3 = "rbs3";
        rbsList.add(rbs1);
        rbsList.add(rbs2);
        rbsList.add(rbs3);

        Map<String, List<String>> cellstatesBeforeMap = new HashMap<>();
        List<String> mapList = new ArrayList<>();
        mapList.add("cell1");
        mapList.add("cell2");
        cellstatesBeforeMap.put("rbs3", mapList);

        testForEach(rbsList, cellstatesBeforeMap);
        testIterator(rbsList, cellstatesBeforeMap);
    }

    private static void testForEach(List<String> rbsList, Map<String, List<String>> cellstatesBeforeMap) {
        for (String rbs : rbsList) {
            System.out.println("rbs: " + rbs);
            System.out.println("cell: " + cellstatesBeforeMap.get(rbs));
        }
    }

    private static void testIterator(List<String> rbsList, Map<String, List<String>> cellstatesBeforeMap) {
        Iterator<String> it = rbsList.iterator();
        while (it.hasNext()) {
            String rbs = it.next();
            System.out.println("rbs: " + rbs);
            if(rbs != null && !rbs.isEmpty()) {
                System.out.println("cell: " + cellstatesBeforeMap.get(rbs));
            }
        }
    }

}
