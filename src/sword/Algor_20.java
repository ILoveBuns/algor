package sword;

import java.util.Stack;

/**
 *
 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class Algor_20 {
    public static void main(String[] args) {
        push(3);
        System.out.println(min());
        push(4);
        System.out.println();
        push(2);
        System.out.println(min());
        push(3);
        System.out.println(min());
        pop();
        System.out.println(min());
    }
    private static Stack<Integer> stack=new Stack<>();
    private static Stack<Integer> minStack=new Stack<>();

    private static int min = Integer.MAX_VALUE;

    //每次push进去的时候，辅助栈push一下当前的最小值
    private static void push(int node) {
        if(node < min){
            min = node;
        }
        minStack.push(min);
        stack.push(node);
    }

    //pop的时候，辅助栈随着一起pop
    private static void pop() {
        minStack.pop();
        stack.pop();
    }

    private static int top() {
        return stack.peek();
    }

    private static int min() {
        return minStack.peek();
    }
}


