package sword;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和
 * 中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 */
public class Algor_4 {
    public static void main(String[] args) {
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};
        TreeNode node = reConstructBinaryTree(pre,in);
        System.out.println(node);
    }
    //递归思想，每次结点一定是pre的首节点
    //分为左右两个子树分别递归
    private static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if(pre.length<=0 || in.length<=0){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);

        ArrayList<Integer> newLeftIn = new ArrayList<>();
        for (int v:in) {
            if(v == root.val){
                break;
            }
            newLeftIn.add(v);
        }
        ArrayList<Integer> newLeftPre = new ArrayList<>();
        for (int inx = 0; inx < newLeftIn.size(); inx++) {
            newLeftPre.add(pre[inx+1]);
        }
        root.left = reConstructBinaryTree(listToInt(newLeftPre),listToInt(newLeftIn));

        ArrayList<Integer> newRightPre = new ArrayList<>();
        for (int inx = 1+newLeftPre.size(); inx < in.length; inx++) {
            newRightPre.add(pre[inx]);
        }
        ArrayList<Integer> newRightIn = new ArrayList<>();
        for (int inx = 1+newLeftIn.size(); inx < in.length; inx++) {
            newRightIn.add(in[inx]);
        }
        root.right = reConstructBinaryTree(listToInt(newRightPre),listToInt(newRightIn));
        return root;
    }
    private static int[] listToInt(List list){
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = (int)list.get(i);
        }
        return arr;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
