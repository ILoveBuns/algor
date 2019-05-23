package sword;

import java.util.ArrayList;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Algor_26 {
    private static ArrayList<TreeNode> queue = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode fir = Convert(init());
        System.out.println(fir);
    }

    private static TreeNode Convert(TreeNode pRootOfTree) {
        midTra(pRootOfTree);
        setP();
        if (queue.size() == 0){
            return null;
        }
        return queue.get(0);
    }

    // 递归中序遍历
    private static void midTra(TreeNode pRootOfTree) {
        if (pRootOfTree == null){
            return;
        }
        midTra(pRootOfTree.left);
        queue.add(pRootOfTree);
        midTra(pRootOfTree.right);
    }

    // 对queue中的结点，重新梳理指针
    private static void setP(){
        if (queue.size() == 1 || queue.size() == 0){
            return;
        }
        for (int i = 0; i < queue.size(); i++) {
            if (i==0){
                queue.get(i).left = null;
                queue.get(i).right = queue.get(i+1);
            }else if(i==queue.size()-1){
                queue.get(i).left = queue.get(i-1);
                queue.get(i).right = null;
            }else {
                queue.get(i).left = queue.get(i-1);
                queue.get(i).right = queue.get(i+1);
            }
        }
    }

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        private TreeNode(int val) {
            this.val = val;
        }
    }

    private static TreeNode init(){
        TreeNode Node = new TreeNode(1);
        Node.left = new TreeNode(2);
        Node.right = new TreeNode(3);
        Node.left.left = new TreeNode(5);
        Node.left.right = new TreeNode(6);

        return Node;
    }
}
