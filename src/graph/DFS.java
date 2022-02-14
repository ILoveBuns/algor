package graph;

import java.util.*;

/**
 * 深度优先遍历
 */
public class DFS {
    static HashSet<String> hashSet = new HashSet<>();

    public static void main(String[] args) {
        HashMap<String, LinkedList<String>> map = GraphTools.generateGraph();
        String begin = "A";
//        DFS(map,begin);
        DFSWithStack(map,begin);
    }

    //递归实现
    static void DFS(HashMap<String, LinkedList<String>> map,String node){

        //避免重复遍历
        if (hashSet.contains(node)){
            return;
        }
        hashSet.add(node);
        System.out.println(node);
        List<String> list = map.get(node);
        if (list == null || list.isEmpty()){
            return;
        }
        for (String str:list) {
            DFS(map,str);
        }
    }

    //非递归栈实现
    static void DFSWithStack(HashMap<String, LinkedList<String>> map,String node){
        Stack<String> stack = new Stack<>();
        stack.add(node);

        while (!stack.isEmpty()){
            String element = stack.pop();
            if (hashSet.contains(element)){
                continue;
            }
            hashSet.add(element);

            System.out.println(element);
            List<String> list = map.get(element);
            if (list == null || list.isEmpty()){
                continue;
            }
            for (int i = list.size()-1; i >= 0 ; i--) {
                stack.add(list.get(i));
            }
        }
    }

}
