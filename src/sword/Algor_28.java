package sword;

import java.util.Arrays;

/**
 *数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 *超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Algor_28 {
    public static void main(String[] args) {
        int tep = MoreThanHalfNum_Solution(new int[]{1});
        System.out.println(tep);
    }

    private static int MoreThanHalfNum_Solution(int [] array) {
        int more = 0;
        if(array.length<=0){
            return more;
        }

        Arrays.sort(array);
        int cur=array[0];
        more = 1;
        if(more>(array.length/2)){
            return cur;
        }

        for (int i = 1; i < array.length; i++) {
            if(array[i]!=cur){
                if(more>(array.length/2)){
                    return cur;
                }
                more = 1;
                cur = array[i];
            }else {
                more++;
            }
        }
        return 0;
    }
}
