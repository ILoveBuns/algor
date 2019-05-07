package sword;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Algor_18 {
    public static void main(String[] args) {

    }

    // 递归，互换每个结点的左右子结点
    private static void Mirror(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode tep = root.right;
        root.right = root.left;
        root.left = tep;
        Mirror(root.left);
        Mirror(root.right);
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
