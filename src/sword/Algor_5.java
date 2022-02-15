package sword;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */

//思路

//1、push,将数据直接压入stack1即可；
//2、pop,将stack1中的数据弹出压入到stack2中，则数据顺序相反，为保证最先进入的数据一直处于栈顶，
//   只有将stack2中的数据全部pop后，才能继续讲stack1中的数据压入到stack2中，继续做pop
public class Algor_5 {
    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        push(1);
        System.out.println(pop());
        push(2);
        push(3);
        System.out.println(pop());
        push(4);
        System.out.println(pop());
        System.out.println(pop());

    }

    private static void push(int node) {
        stack1.push(node);
    }

    private static int pop() {
        if (stack1.isEmpty() && stack2.isEmpty()){
            return -1;
        }
        if (!stack2.isEmpty()){
            return stack2.pop();
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
