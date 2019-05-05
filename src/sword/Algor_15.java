package sword;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Algor_15 {
    public static void main(String[] args) {
        ReverseList(init());
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
}
