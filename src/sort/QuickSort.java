package sort;

import javax.swing.text.AsyncBoxView;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = ArrTools.generateArrN(10000);
        System.out.println("排序前：");
        ArrTools.printArr(arr);
        System.out.println("排序后：");
        quickSort(arr,0,arr.length-1);
        ArrTools.printArr(arr);

        System.out.printf("是否是递增：%s",ArrTools.isIncrement(arr));

    }

    public static void quickSort(int[] arr,int low,int high){
        int oldLow = low;
        int oldHigh = high;
        if (low>=high){
            return;
        }

        int basic = arr[low];
        while (low < high){
            for (int i = high; i > low ; i--) {
                if (arr[i] < basic){
                    arr[low] = arr[i];
                    break;
                }
                high--;
            }
            for (int i = low; i < high; i++) {
                if (arr[i] > basic){
                    arr[high] = arr[i];
                    break;
                }
                low++;
            }
        }
        arr[low] = basic;
        quickSort(arr,oldLow,low-1);
        quickSort(arr,low+1,oldHigh);
    }




}
