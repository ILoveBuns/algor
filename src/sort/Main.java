package sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = ArrTools.generateArrN((int) (Math.random() * 100));
        System.out.println("排序前：" + Arrays.toString(arr));

        insertSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
        System.out.println("是否递增：" + ArrTools.isIncrement(arr));
    }

    static void quickSort(int[] arr,int left, int right){
        if (left >= right){
            return;
        }

        int low = left;
        int high = right;
        int basic = arr[left];
        while (left<right){
            while (right>left){
                if (arr[right] < basic){
                    arr[left]=arr[right];
                    break;
                }
                right--;
            }
            while (left<right){
                if (arr[left] > basic){
                    arr[right] = arr[left];
                    break;
                }
                left++;
            }
            if (left == right){
                arr[left]=basic;
                break;
            }
        }
        quickSort(arr,low,left-1);
        quickSort(arr,left+1,high);
    }

    static void selectSort(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minInx = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min){
                    min = arr[j];
                    minInx = j;
                }
            }
            //交换
            int tep = arr[i];
            arr[i] = min;
            arr[minInx] = tep;
        }
    }

    static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int tep = arr[i];
            int j;
            for (j = i-1; j >= 0; j--) {
                if (tep > arr[j]){
                    break;
                }
            }
            //此时从j+1到i开始整体往后挪一位，并把j+1位置放置tep
            for (int k = i; k > j+1; k--) {
                arr[k] = arr[k-1];
            }
            arr[j+1] = tep;
        }
    }

    static void shellSort(int arr){


    }
}
