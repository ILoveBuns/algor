package tree;

public class TreeNode {
    int data;
    TreeNode lChild;
    TreeNode rChild;
    int level;
    boolean isVisit;

    TreeNode(int data){
        this.data = data;
        this.isVisit = false;
    }
}
