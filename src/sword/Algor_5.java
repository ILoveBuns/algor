package sword;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */

//思路

//1、push,将数据直接压入stack1即可；
//2、pop,将stack1中的数据弹出压入到stack2中，则数据顺序相反，为保证最先进入的数据一直处于栈顶，
//只有将stack2中的数据全部pop后，才能继续讲stack1中的数据压入到stack2中，继续做pop
public class Algor_5 {
    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        push(1);
        push(2);
        System.out.println(pop());
        push(3);

        System.out.println(pop());
        System.out.println(pop());
    }

    private static void push(int node) {
        stack1.push(node);
    }

    private static int pop() {
        if(stack1.empty()){
            return -1;
        }
        int size1 = stack1.size();
        for (int i = 0; i < size1-1; i++) {
            stack2.push(stack1.pop());
        }
        int value = stack1.pop();
        int size2 = stack2.size();
        for (int i = 0; i < size2; i++) {
            stack1.push(stack2.pop());
        }
        return value;
    }
}
