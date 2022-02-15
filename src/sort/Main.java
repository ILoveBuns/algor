package sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = ArrTools.generateArrN((int) (Math.random() * 5));
        System.out.println("排序前：" + Arrays.toString(arr));

        pubSort(arr);
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

    static void shellSort(int arr[]){
        //dk为分组
        for (int dk = arr.length/2; dk > 0 ; dk = dk/2) {
            //firstArrInx代表每个分组的第一个位置
            for (int firstArrInx = 0; firstArrInx < dk; firstArrInx++) {
                //在每组内进行简单插入排序
                for (int j = firstArrInx+dk; j < arr.length ; j = j + dk) {
                    int tep = arr[j];
                    //找出每组内第j个位置应当属于的位置
                    int k;
                    for (k = j-dk; k >= firstArrInx ; k=k-dk) {
                        if (tep>arr[k]){
                            break;
                        }
                    }
                    //从j-dk往前到k+dk开始往后挪一个位置
                    for (int i = j; i > k+dk ; i=i-dk) {
                        arr[i] = arr[i-dk];
                    }
                    arr[k+dk] = tep;
                }
            }
        }
    }

    static void pubSort(int arr[]){
        //共需要遍历N-1次
        for (int time = 0; time < arr.length-1; time++) {
            for (int i = 0; i < arr.length-time-1; i++) {
                if (arr[i]>arr[i+1]){
                    //交换
                    int tep = arr[i+1];
                    arr[i+1]=arr[i];
                    arr[i]=tep;
                }
                System.out.println(Arrays.toString(arr));
            }
        }
    }
}
