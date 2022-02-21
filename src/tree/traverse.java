package tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class traverse {
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);
        node1.lChild = node2;
        node1.rChild = node3;
        node2.lChild = node4;
        node3.lChild = node5;
        node3.rChild = node6;
        node5.rChild = node7;


        lastTraverseNotDiGui(node1);
    }

    //先序遍历，根左右
    static void preTraverse(TreeNode root){
        if (root == null){
            return;
        }
        System.out.println(root.data);
        preTraverse(root.lChild);
        preTraverse(root.rChild);
    }

    //中序遍历，左根右
    static void midTraverse(TreeNode node){
        if (node == null){
            return;
        }
        midTraverse(node.lChild);
        System.out.println(node.data);
        midTraverse(node.rChild);
    }

    //后序遍历，左右根
    static void lastTraverse(TreeNode node){
        if (node == null){
            return;
        }
        lastTraverse(node.lChild);
        lastTraverse(node.rChild);
        System.out.println(node.data);
    }

    //层次遍历
    static void levelTraverse(TreeNode root){
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null){
            return;
        }
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node.data);
            if (node.lChild != null){
                queue.add(node.lChild);
            }
            if (node.rChild != null){
                queue.add(node.rChild);
            }

        }
    }

    //层次遍历每次输出每层的最后一个
    static void levelTraverseLastOne(TreeNode root){
        if (root == null){
            return;
        }
        root.level = 1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.lChild != null){
                node.lChild.level = node.level +1;
                queue.add(node.lChild);
            }
            if (node.rChild != null){
                node.rChild.level = node.level+1;
                queue.add(node.rChild);
            }
            TreeNode next = queue.peek();
            if (next == null){
                System.out.println(node.data);
                break;
            }
            if (next.level == node.level +1){
                System.out.println(node.data);
            }
        }
    }


    //先序遍历，非递归
    static void preTraverseNotDigui(TreeNode root){
        if (root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            root = stack.pop();
            System.out.println(root.data);

            if (root.rChild != null){
                stack.push(root.rChild);
            }
            if (root.lChild != null){
                stack.push(root.lChild);
            }
        }
    }

    //中序遍历，非递归
    static void midTraverseNotDiGui(TreeNode node){
        if (node == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || node != null){
            while (node != null){
                stack.push(node);
                node = node.lChild;
            }
            //此时的node一定是不存在左孩子
            node = stack.pop();
            System.out.println(node.data);
            node = node.rChild;

        }
    }

    //后序遍历，非递归
    static void lastTraverseNotDiGui(TreeNode node){
        if (node == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode stackTop = stack.peek();
            if (stackTop.lChild == null && stackTop.rChild == null){
                System.out.println(stackTop.data);
                stackTop.isVisit = true;
                stack.pop();
            }else if (((stackTop.lChild != null && (stackTop.lChild.isVisit)) && (stackTop.rChild == null)) ||
                    ((stackTop.rChild != null && (stackTop.rChild.isVisit)) && (stackTop.lChild == null)) ||
                    (stackTop.lChild != null && stackTop.rChild != null && stackTop.lChild.isVisit && stackTop.rChild.isVisit)
            ){
                //左右孩子至少存在一个且都访问过了，即（左孩子存在+已被访问+右孩子不存在） or （右孩子存在+已被访问+左孩子不存在） or （左右孩子都存在+都已经被访问）
                System.out.println(stackTop.data);
                stackTop.isVisit = true;
                stack.pop();
            }else {
                if (stackTop.rChild != null){
                    stack.push(stackTop.rChild);
                }
                if (stackTop.lChild != null){
                    stack.push(stackTop.lChild);
                }
            }

        }
    }

}
