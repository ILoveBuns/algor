package sword;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Algor_15 {
    public static void main(String[] args) {
        ListNode node = init();
        System.out.println(ReverseList(node));
    }
    private static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        while (head.next != null){
            ListNode tep = head.next;
            head.next = pre;
            pre = head;
            head = tep;
        }
        head.next = pre;
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static ListNode init(){
        ListNode node = new ListNode(2);
        node.next = new ListNode(4);
        node.next.next = new ListNode(6);
        return node;
    }
}
