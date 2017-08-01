package shixzh.j2x3.y2017.m07.d21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestForEachObject {

    public static void main(String[] args) {
        Map<String, List<String>> cellStateMapBefore = getCellStateMapBefore();
        Map<EnodeB, List<String>> cellStateMapBeforeByEnodeB = getCellStateMapBeforeByEnodeB();
        waitCellState(cellStateMapBefore);
        waitCellStateForEnb(cellStateMapBeforeByEnodeB);
    }

    private static void waitCellState(Map<String, List<String>> cellstatesBeforeMap) {
        for (EnodeB enb : getEnodeBList()) {
            if (enb != null) {
                System.out.println(cellstatesBeforeMap.get(enb.getName()));
            }
        }
    }

    private static void waitCellStateForEnb(Map<EnodeB, List<String>> cellStateMapBeforeByEnodeB) {
        for (EnodeB enb : getEnodeBList()) {
            if (enb != null) {
                System.out.println(cellStateMapBeforeByEnodeB.get(enb));
            }
        }
    }

    private static List<EnodeB> getEnodeBList() {
        List<EnodeB> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            EnodeB enb = new EnodeB("enodeb" + i);
            list.add(enb);
        }
        return list;
    }

    private static Map<String, List<String>> getCellStateMapBefore() {
        Map<String, List<String>> cellStateMapBefore = new HashMap<>();
        for (EnodeB enb : getEnodeBList()) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                list.add("enable");
            }
            cellStateMapBefore.put(enb.getName(), list);
        }
        return cellStateMapBefore;
    }

    private static Map<EnodeB, List<String>> getCellStateMapBeforeByEnodeB() {
        Map<EnodeB, List<String>> cellStateMapBeforeByEnodeB = new HashMap<>();
        for (EnodeB enb : getEnodeBList()) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                list.add("enable");
            }
            cellStateMapBeforeByEnodeB.put(enb, list);
        }
        return cellStateMapBeforeByEnodeB;
    }
}

class EnodeB {

    private String name;

    public EnodeB(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
