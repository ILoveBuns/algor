package graph;

import java.util.HashMap;
import java.util.LinkedList;

public class GraphTools {

    public static HashMap<String, LinkedList<GraphNode>> generateGraph(){
        HashMap<String, LinkedList<GraphNode>> map = new HashMap<>(8);

        map.put("A",new LinkedList<GraphNode>(){{add(new GraphNode("D"));add(new GraphNode("B"));add(new GraphNode("C"));}});
        map.put("B",new LinkedList<GraphNode>(){{add(new GraphNode("E"));add(new GraphNode("F"));}});
        map.put("C",new LinkedList<GraphNode>(){{add(new GraphNode("F"));}});
        map.put("D",new LinkedList<GraphNode>(){{add(new GraphNode("G"));add(new GraphNode("I"));add(new GraphNode("H"));}});
        map.put("E",new LinkedList<GraphNode>(){{add(new GraphNode("K"));}});
        map.put("F",new LinkedList<GraphNode>(){{add(new GraphNode("K"));}});
        map.put("K",new LinkedList<GraphNode>(){});
        map.put("G",new LinkedList<GraphNode>(){});
        map.put("H",new LinkedList<GraphNode>(){{add(new GraphNode("I"));}});
        map.put("I",new LinkedList<GraphNode>(){{add(new GraphNode("J"));}});
        map.put("J",new LinkedList<GraphNode>(){{add(new GraphNode("A"));}});

        return map;
    }

}
