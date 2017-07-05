package shixzh.j2x3.y2017.m07.d03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapListTest {

    public static void main(String[] args){
        Map<String, List<String>> map = new HashMap<String, List<String>>(); 
        List<String> list = new ArrayList<String>();
        list.add("cell1");
        list.add("cell2");
        map.put("rbs1", list);
        for(String cell : map.get("rbs1")) {
            System.out.println(cell);
        }
    }
}
