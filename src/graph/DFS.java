package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class DFS {

    static HashSet<String> hashSet = new HashSet<>();
    public static void main(String[] args) {
        HashMap<String, LinkedList<GraphNode>> map = GraphTools.generateGraph();
        DFS(map);
    }

    //使用递归
    static void DFS(HashMap<String, LinkedList<GraphNode>> map){
        GraphNode begin = new GraphNode("A",0);
        diGuiDFS(map,begin);
    }

    static void diGuiDFS(HashMap<String, LinkedList<GraphNode>> map,GraphNode node){
        if (hashSet.contains(node.value)){
            //说明已经遍历到了
            return;
        }
        if (map.containsKey(node.value)){
            hashSet.add(node.value);
            System.out.println(node.value+","+node.level);
            for (GraphNode element:map.get(node.value)) {
                element.level = node.level+1;
                diGuiDFS(map,element);
            }
        }
    }

    //不使用递归
}
