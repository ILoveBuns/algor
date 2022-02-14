package exam.linked;

import java.util.LinkedList;

public class LinkedTool {
    public static LinkedList<Integer>[]  generateLinkNodeArr(int k){
//        int k = (int)(Math.random()*10);
//        int k = 2;
        LinkedList<Integer>[] arr = new LinkedList[k];

        for (int i = 0; i < arr.length; i++) {
            LinkedList<Integer> linkedList = generateAscLinkNode();
            arr[i]=linkedList;
        }
        return arr;
    }

    //生成一个升序的链表
    public static LinkedList<Integer> generateAscLinkNode(){

        int firstNum = (int)(Math.random()*10);
        int length = (int)(Math.random()*10)+1;

        LinkedList<Integer> list = new LinkedList<>();
        list.add(firstNum);

        for (int i = 0; i < length-1; i++) {
            list.add(list.get(i) + (int)(Math.random()*50));
        }
        return list;
    }
}
