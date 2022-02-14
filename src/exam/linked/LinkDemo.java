package exam.linked;

import java.util.LinkedList;
import java.util.List;

public class LinkDemo {
    public static void main(String[] args) {
        LinkedList<Integer> arr = new LinkedList<Integer>();
        arr.add(5);
        arr.add(4);
        arr.add(3);
        arr.add(2);
        arr.add(1);
        LinkNode head = arr2Link(arr);
        System.out.println(head);
        String str = linked2String(head);
        System.out.println(str);
    }

    //数组转链表
    static LinkNode arr2Link(List<Integer> list){
        if (list.size() == 0){
            return null;
        }
        LinkNode head = new LinkNode(list.get(0),null);
        LinkNode out = head;
        for (int i = 1; i < list.size(); i++) {
            head.next = new LinkNode(list.get(i),null);
            head = head.next;
        }
        return out;
    }

    //输入链表，输出value
    static String linked2String(LinkNode head){
        StringBuilder sb = new StringBuilder(2);
        while (head != null){
            sb.append(head.value);
            head = head.next;
        }
        return sb.toString();
    }

//
//    import java.util.*;
//
//    class LinkNode{
//        int value;
//        LinkNode next;
//    }
//
//    write a function
//    input: List<Integer> or int[]{-1, 0, 4, 5}
//    output: LinkNode head
//    return head -> -1 -> 0 -> 4 -> 5
//
//    write a function
//    input: LinkNode head
//    output: String value
//    return a String value like "-1,0,4,5"
//
//    // 必须定义 `ShowMeBug` 入口类和 `public static void main(String[] args)` 入口方法
//    public class ShowMeBug {
//        public static void main(String[] args) {
//            System.out.println("Hello World!");
//        }
//    }

}
