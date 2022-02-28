package graph;

import java.util.*;

/**
 * 广度优先遍历
 * 同时标记层数，即最短路径
 */
public class BFS {
    public static void main(String[] args) {
        HashMap<String,LinkedList<GraphNode>> map = GraphTools.generateGraph();
        BFS(map);
    }

    static void BFS(HashMap<String,LinkedList<GraphNode>> map){
        //去重，防止同一个节点被2各父节点都指向
        HashSet<String> hashSet = new HashSet<>(map.size());

        GraphNode begin = new GraphNode("A",0);
        Queue<GraphNode> queue = new ArrayDeque<>();
        queue.add(begin);
        hashSet.add(begin.value);

        while (!queue.isEmpty()){
            GraphNode element = queue.poll();
            System.out.println(element.value+","+element.level);

//            String[] elementArr = element.split(",");
//            int level = Integer.parseInt(elementArr[1]);
//            level++;
            List<GraphNode> list = map.get(element.value);

            for (GraphNode node:list) {
                //说明已经遍历过了
                if (hashSet.contains(node.value)){
                    continue;
                }
                hashSet.add(node.value);
                node.level = element.level+1;
                queue.add(node);
            }
        }
    }
}
