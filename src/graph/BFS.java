package graph;

import java.util.*;

/**
 * 广度优先遍历
 * 同时标记层数，即最短路径
 */
public class BFS {
    public static void main(String[] args) {
        HashMap<String,LinkedList<String>> map = GraphTools.generateGraph();
        BFS(map);
    }

    static void BFS(HashMap<String,LinkedList<String>> map){
        //去重，防止同一个节点被2各父节点都指向
        HashSet<String> hashSet = new HashSet<>(map.size());

        String begin = "A,0";
        Queue<String> queue = new ArrayDeque<>();
        queue.add(begin);
        hashSet.add("A");

        while (!queue.isEmpty()){
            String element = queue.poll();
            System.out.println(element);

            String[] elementArr = element.split(",");
            int level = Integer.parseInt(elementArr[1]);
            level++;
            List<String> list = map.get(elementArr[0]);

            for (String node:list) {
                //说明已经遍历过了
                if (hashSet.contains(node)){
                    continue;
                }
                hashSet.add(node);
                queue.add(node+","+level);
            }
        }
    }
}
