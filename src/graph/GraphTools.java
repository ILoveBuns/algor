package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GraphTools {

    public static HashMap<String, LinkedList<String>> generateGraph(){
        HashMap<String, LinkedList<String>> map = new HashMap<>(8);

        map.put("A",new LinkedList<String>(){{add("D");add("B");add("C");}});
        map.put("B",new LinkedList<String>(){{add("E");add("F");}});
        map.put("C",new LinkedList<String>(){{add("F");}});
        map.put("D",new LinkedList<String>(){{add("G");add("H");}});
        map.put("E",new LinkedList<String>(){});
        map.put("F",new LinkedList<String>(){});
        map.put("G",new LinkedList<String>(){});
        map.put("H",new LinkedList<String>(){});

        return map;
    }
}
