package sword;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Algor_14 {
    public static void main(String[] args) {;
        ListNode node = FindKthToTail(init(),0);
        System.out.println(node.val);
    }
    public static ListNode FindKthToTail(ListNode head,int k) {
        int size = 0;
        ListNode tep = head;
        while (tep != null){
            tep = tep.next;
            size++;
        }

        if (k<=0 || k>size){
            return null;
        }
        ListNode node = null;
        for (int i = 0; i <= size-k; i++) {
            node = head;
            if(head.next == null){
                break;
            }
            head = head.next;
        }
        return node;
    }
    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    private static ListNode init(){
        ListNode node = new ListNode(1);
         node.next = new ListNode(2);
         node.next.next = new ListNode(3);
         node.next.next.next = new ListNode(4);
         node.next.next.next.next = new ListNode(5);
         return node;
    }
}
