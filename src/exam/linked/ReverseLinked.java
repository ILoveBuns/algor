package exam.linked;

public class ReverseLinked {

    public static void main(String[] args) {
        LinkNode node1 = new LinkNode(1);
        LinkNode node2 = new LinkNode(2);
        LinkNode node3 = new LinkNode(3);
        LinkNode node4 = new LinkNode(4);
        LinkNode node5 = new LinkNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println("反转前：");
        printNode(node1);

        LinkNode newHead = recursion(node1);
        System.out.println("反转后");
        printNode(newHead);
    }

    //方法1-迭代
    static LinkNode reverseNode(LinkNode head){
        LinkNode pre=null;
        LinkNode cur=null;
        LinkNode next ;

        while (head != null){
            next = head.next;
            cur = head;

            head.next = pre;
            head = next;
            pre = cur;
        }
        //最后一次返回是，next是空
        return pre;
    }


    //方法2-递归
    static LinkNode recursion(LinkNode node){
        if (node == null || node.next == null){
            return node;
        }
        LinkNode newHead = recursion(node.next);
        node.next.next = node;
        node.next = null;

        return newHead;
    }

    static void printNode(LinkNode head){
        while (head != null){
            System.out.println(head.value);
            head = head.next;
        }
    }
}
