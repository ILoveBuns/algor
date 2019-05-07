package sword;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class Algor_21 {
    public static void main(String[] args) {

    }
    //push之前先检查，两个栈是否顶层元素相同，相同说明可弹出
    private static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> popStack = getPopStack(popA);
        Stack<Integer> pushStack = new Stack<>();
        for (int i = 0; i < pushA.length; i++) {
            pushStack.push(pushA[i]);
            while (!pushStack.empty() && !popStack.empty() && pushStack.peek() == popStack.peek()){
                pushStack.pop();
                popStack.pop();
            }
        }
        if (popStack.isEmpty()){
            return true;
        }
        return false;
    }

    private static Stack<Integer> getPopStack(int [] popA){
        Stack<Integer> stack = new Stack<>();
        for (int i = popA.length-1; i >= 0  ; i--) {
            stack.push(popA[i]);
        }
        return stack;
    }
}
