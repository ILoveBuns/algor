package sort;

import java.util.Arrays;

public class SwitchSort {
    public static void main(String[] args) {
        int[] arr = ArrTools.generateArrN(100);
        System.out.println("原数组排序前：");
        ArrTools.printArr(arr);

        int[] arrClone = Arrays.copyOf(arr,arr.length);
        Arrays.sort(arrClone);
        System.out.println("clone排序后：");
        ArrTools.printArr(arrClone);

        switchSort(arr);
        System.out.println("原数组排序后：");
        ArrTools.printArr(arr);

        System.out.printf("是否是递增：%s",ArrTools.isIncrement(arr));
    }

    static void switchSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int inx = i;
            int min = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j]<min){
                    min = arr[j];
                    inx = j;
                }
            }
            arr[inx] = arr[i];
            arr[i] = min;
        }
    }
}
