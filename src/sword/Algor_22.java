package sword;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Algor_22 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        n1.left = new TreeNode(2);
        n1.right = new TreeNode(3);
        PrintFromTopToBottom(n1);
    }

    //二叉树层次遍历
    private static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(root);
        while (root != null){
            if (root.left!=null){
                queue.add(root.left);
            }
            if (root.right!=null){
                queue.add(root.right);
            }
            list.add(queue.poll().val);
            if(queue.isEmpty()){
                break;
            }
            root = queue.getFirst();
        }
        return list;
    }

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
