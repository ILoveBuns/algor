package sword;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 */

// 以此交换数组，所有能够组成不同数的数组都保存下来，最后遍历set找出最小的数
public class Algor_32 {
    private static HashSet<MyArr> hashSet = new HashSet();
    private static ArrayList<MyArr> queue = new ArrayList<>();

    public static void main(String[] args) {
        String str = PrintMinNumber(new int[]{3334,3,3333332});
        System.out.println(str);
    }

    public static String PrintMinNumber(int[] numbers) {
        if (numbers.length == 0){
            return "";
        }
        if (numbers.length == 1){
            return String.valueOf(numbers[0]);
        }
        queue.add(new MyArr(numbers));
        for (int i = 0; i < queue.size(); i++) {
            hashSet.add(queue.get(i));

            int[] arr = queue.get(i).arr;
            for (int j = 0; j < arr.length; j++) {
                MyArr tep = new MyArr(swap(arr,0,j));
                //说明变换后的数组之前没出现过。放进队列进行交换
                if( hashSet.add(tep) ){
                    queue.add(tep);
                }
            }
        }

        Long min = Long.MAX_VALUE;
        for (MyArr myArr: hashSet) {
            if (min > getInt(myArr.arr)){
                min = getInt(myArr.arr);
            }
        }
        return Long.toString(min);
    }

    private static int[] swap(int[] arr,int i,int j){
        int[] clone = arr.clone();
        int tep = clone[j];
        clone[j] = clone[i];
        clone[i] = tep;
        return clone;
    }
    private static Long getInt(int[] strs){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        return Long.valueOf(sb.toString());
    }

    private static class MyArr{
        private int[] arr;
        MyArr(int[] arr){
            this.arr = arr;
        }
        @Override
        public int hashCode(){
            return 1;
        }
        @Override
        public boolean equals(Object o){
            if(o instanceof MyArr){
                int[] objectArr = ((MyArr) o).arr;
                if (arr.length == objectArr.length){
                    for (int i = 0; i < arr.length; i++) {
                        if(arr[i] != objectArr[i]){
                           return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }
    }
}