package graph;

import java.util.*;

/**
 * 广度优先遍历
 */
public class BFS {
    public static void main(String[] args) {
        HashMap<String,LinkedList<String>> map = GraphTools.generateGraph();
        BFS(map);
    }

    static void BFS(HashMap<String,LinkedList<String>> map){
        //去重，防止同一个节点被2各父节点都指向
        HashSet<String> hashSet = new HashSet<>(map.size());

        String begin = "A";
        Queue<String> queue = new ArrayDeque<>();
        queue.add(begin);
        while (!queue.isEmpty()){
            String element = queue.poll();
            System.out.println(element);
            List<String> list = map.get(element);

            for (String node:list) {
                //说明已经遍历过了
                if (hashSet.contains(node)){
                    continue;
                }
                hashSet.add(node);
                queue.add(node);
            }

        }
    }
}
