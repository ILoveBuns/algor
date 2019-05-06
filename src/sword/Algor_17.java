package sword;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Algor_17 {
    public static void main(String[] args) {

    }

    //将两个树先根遍历成字符串序列，然后判断root2序列是否在root1中
    private static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root2 == null){
            return false;
        }
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        preTra(root1,sb1);
        preTra(root2,sb2);
        return sb1.toString().contains(sb2.toString());
    }

    //先根遍历
    private static void preTra(TreeNode root,StringBuffer sb){
        if (root == null){
            return;
        }
        sb.append(root.val);
        preTra(root.left,sb);
        preTra(root.right,sb);
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
