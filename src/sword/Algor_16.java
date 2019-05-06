package sword;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Algor_16 {
    public static void main(String[] args) {

    }
    private static ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode root;//记录合并后的链表起点，不能动
        if(list1.val<list2.val){
            root = list1;
            list1 = list1.next;
        }else {
            root = list2;
            list2 = list2.next;
        }

        ListNode p = root;//从起点开始，依次向下指向较小的结点
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                p.next = list1;
                p = p.next;
                list1 = list1.next;
            }else {
                p.next = list2;
                p = p.next;
                list2 = list2.next;
            }
        }
        while (list1 != null){
            p.next = list1;
            p = p.next;
            list1 = list1.next;
        }
        while (list2 != null){
            p.next = list2;
            p = p.next;
            list2 = list2.next;
        }
        return root;
    }
    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
