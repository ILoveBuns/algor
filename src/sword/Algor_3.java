package sword;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class Algor_3 {
    public static void main(String[] args) {
        ListNode listNode =new ListNode(10);
        ListNode tep = listNode;
        for (int i = 0; i < 0; i++) {
            tep.next = new ListNode((int)(Math.random()*100));
            tep = tep.next;
        }
        printListFromTailToHead(listNode);
    }

    public static  ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> out = new ArrayList<>();
        while(listNode != null){
            list.add(listNode.val);
            listNode = listNode.next;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(list.size()-1-i));
            out.add(list.get(list.size()-1-i));
        }
        return out;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}