package sword;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Algor_24 {
    public static void main(String[] args) {
        FindPath(init(),22);
    }

    private static  ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target){
        HashMap<Integer,ArrayList<Integer>> hs = new HashMap<>();
        FindPath(root,new ArrayList<>(),hs,target);

        //对hs按照key从大到小排序至list中，返回

    }
    private static void FindPath(TreeNode root, ArrayList<Integer> list,HashMap<Integer,ArrayList<Integer>> hs,int target) {
        if (root == null){
            return;
        }
        list.add(root.val);
        if(root.left == null && root.right == null){
            System.out.println(Arrays.toString(list.toArray()));
            if(equal(list,target)){
                // 如果list满足要求，将该路径放到map中
                hs.put(list.size(),(ArrayList<Integer>)list.clone());
            }
            list.remove(list.size()-1);
            return;
        }
        FindPath(root.left,list,hs,target);
        FindPath(root.right,list,hs,target);
        list.remove(list.size()-1);
    }

    private static boolean equal(ArrayList<Integer> list,int target){
        int sum = 0;
        for (int i:list) {
            sum = sum+i;
        }
        return sum == target;
    }
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static TreeNode init(){
        TreeNode Node = new TreeNode(10);
        Node.left = new TreeNode(5);
        Node.right = new TreeNode(12);
        Node.left.left = new TreeNode(4);
        Node.left.right = new TreeNode(7);
        Node.left.left.left = new TreeNode(3);
        Node.left.left.left.right = new TreeNode(18);
        Node.left.right.left = new TreeNode(15);
        Node.left.right.right = new TreeNode(30);
        Node.left.right.left.left = new TreeNode(20);
        Node.left.right.left.right = new TreeNode(21);
        Node.right.right = new TreeNode(8);
        Node.right.right.left = new TreeNode(17);
        return Node;
    }
}
