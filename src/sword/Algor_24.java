package sword;

import java.util.*;

/**
 *
 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 (注意: 在返回值的list中，数组长度大的数组靠前)
 */

//通过递归获取所有路径，对符合要求的路径clone后
public class Algor_24 {

    private static ArrayList<ArrayList<Integer>> allPath = new ArrayList<>();
    private static  ArrayList<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> out = FindPath(init(),8);

        Collections.sort(out, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o2.size() - o1.size();
            }
        });
        System.out.println(out);
    }

    private static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) return allPath;
        path.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            allPath.add(new ArrayList<>(path));
        FindPath(root.left, target);
        FindPath(root.right, target);
        path.remove(path.size()-1);
        return allPath;
    }

    private static class TreeNode {
        int val ;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static TreeNode init(){
        TreeNode Node = new TreeNode(1);
        Node.left = new TreeNode(2);
        Node.right = new TreeNode(3);
        Node.left.left = new TreeNode(4);
        Node.left.left.left = new TreeNode(1);
        Node.left.right = new TreeNode(5);
        Node.right.right = new TreeNode(3);
        Node.right.right.left = new TreeNode(1);

        return Node;
    }
}
