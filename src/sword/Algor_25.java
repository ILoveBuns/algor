package sword;

import java.util.HashMap;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */


public class Algor_25 {
    // 为了避免循环指向，hs中的key存储的是原node，v为clone后的node
    // 在递归调用时，首先检查当前结点是否已在hs中，若已在，说明指向过了，返回已clone的对象
    private static HashMap<RandomListNode,RandomListNode> hs = new HashMap<>();

    public static void main(String[] args) {
        RandomListNode head = init();
        RandomListNode clone = Clone(head);
        System.out.println(head);
        System.out.println(clone);
    }

    //递归，首先clone当前结点，再依次克隆当前结点的next和random结点，注意循环指向
    private static RandomListNode Clone(RandomListNode pHead){
        if (pHead == null ){
            return null;
        }
        if(hs.get(pHead) != null){
            return hs.get(pHead);
        }
        RandomListNode clone = new RandomListNode(pHead.label);
        hs.put(pHead,clone);
        clone.next = Clone(pHead.next);
        clone.random = Clone(pHead.random);
        return clone;
    }
    private static class RandomListNode {
        int label;

        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    private static RandomListNode init(){
        RandomListNode a = new RandomListNode(1);
        a.next = new RandomListNode(2);
        RandomListNode b= a.next;

        b.random = new RandomListNode(3);
        b.next = new RandomListNode(4);
        RandomListNode d = b.next;

        d.random = b;
        d.next = new RandomListNode(5);
        RandomListNode e = d.next;

        return a;
    }
}
