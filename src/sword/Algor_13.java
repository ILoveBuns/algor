package sword;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Algor_13 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,3,9,7,8};
        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    //从后向前遍历，偶数往下沉，一直沉直到遇到另一个偶数或者沉到底为止
    private static void reOrderArray(int[] array) {
        for (int i = array.length-1; i >-1 ; i--) {
            if (isEven(array[i])){
                for (int j = i; j < array.length; j++) {
                    if(j == array.length-1 || isEven(array[j+1])){
                        break;
                    }
                    swap(array,j);
                }
            }
        }
    }

    //交换数组的index和index+1
    private static void swap(int[] arr,int index ){
        int tep = arr[index+1];
        arr[index+1] = arr[index];
        arr[index] = tep;
    }

    //判断是否为偶数
    private static Boolean isEven(int num){
        return num%2==0;
    }
}
