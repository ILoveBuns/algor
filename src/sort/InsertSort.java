package sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = ArrTools.generateArrN((int)(Math.random() * 100));
        System.out.println("排序前："+ Arrays.toString(arr));

        insertSort(arr);
        System.out.println("排序后："+ Arrays.toString(arr));
        System.out.println("是否递增:"+ ArrTools.isIncrement(arr));
    }

    static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int tep = arr[i];
            int j;
            for (j = i-1; j >= 0;j--){
                if (tep > arr[j]){
                    //此时j+1就是tep应该插入的位置
                    break;
                }
            }
            //从j+2到i开始往后挪一个位置
            for (int k = i; k > j+1 ; k--) {
                arr[k]=arr[k-1];
            }
            arr[j+1] = tep;
        }
    }
}
