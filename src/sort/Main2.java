package sort;

import java.util.Arrays;

public class Main2 {

    public static void main(String[] args) {
        int [] arr = ArrTools.generateArrN((int)(Math.random() * 50));
        System.out.println("排序前：" + Arrays.toString(arr));

        heapSort(arr);

        System.out.println("排序后：" + Arrays.toString(arr));
        System.out.println("是否递增：" + ArrTools.isIncrement(arr));
    }


    //交换排序
    //1.简单选择
    static void selectSort(int arr[]){
        //每次选择最小的值和当前交换
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minInx = i;

            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < min){
                    min = arr[j];
                    minInx = j;
                }
            }
            //交换
            if (min < arr[i]){
                arr[minInx] = arr[i];
                arr[i] = min;
            }
        }

    }
    //2.冒泡排序
    static void pubSort(int arr[]){
        for (int time = 0; time < arr.length-1; time++) {
            for (int j = 0; j < arr.length-time-1; j++) {
                if (arr[j]>arr[j+1]){
                    int tep = arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=tep;
                }
            }
        }
    }


    //插入排序
    //3.直接插入排序
    static void insertSort(int arr[]){
        for (int i = 1; i < arr.length; i++) {
            //找出第i个位置应该处于的位置，即刚好大于前一个
            int j;
            for (j = i-1; j >= 0; j--) {
                if (arr[i]>arr[j]){
                    break;
                }
            }
            //从j+1开始到i-1往后挪一个位置
            for (int k = j+1; k < i; k++) {
                arr[k+1]=arr[k];
            }
            arr[j+1]=arr[i];
        }
    }
    //4.希尔排序
    static void shellSort(int arr[]){
        for (int dk = arr.length/2; dk > 0 ; dk=dk/2) {
            //这里的i表明当前待排序列第二个值
            for (int i = dk; i < arr.length; i = i +dk) {
                //这里需要找到0-i之前最后一个位置，给i挪进来
                int j;
                for (j = i-dk; j >= 0 ; j=j-dk) {
                    if (arr[i]>arr[j]){
                        break;
                    }
                }
                //从j+dk开始到i-dk开始往后挪一个位置
                for (int k = j+dk; k < i; k = k+dk) {
                    arr[k+dk]=arr[k];
                }
                arr[j+dk]=arr[i];
            }

        }
    }


    //比较排序
    //5.快排
    static void quickSort(int arr[],int left,int right){
        if (left > right){
            return;
        }

        int basic = arr[left];
        int low = left;
        int high = right;
        while(left < right){
            while (left<right){
                if (arr[right]<basic){
                    arr[left] = arr[right];
                    break;
                }
                right--;
            }
            while (left<right){
                if (arr[left]>basic){
                    arr[right]=arr[left];
                    break;
                }
                left++;
            }
            if (left == right){
                arr[left] = basic;
                break;
            }
        }
        quickSort(arr,low,left-1);
        quickSort(arr,left+1,high);

    }
    //6.堆排序
    static void heapSort(int arr[]){
        for (int i = arr.length/2-1; i >= 0; i--) {
            adjustToHeap(arr,i,arr.length-1);
        }

        for (int time = 0; time < arr.length-1; time++) {
            swap(arr,0,arr.length-1-time);
            adjustToHeap(arr,0,arr.length-2-time);
        }
    }

    static void adjustToHeap(int[] arr,int root,int maxInx){
        for (int i = 2*root + 1; i <= maxInx ; i = 2*root+1) {
            if (i+1<=maxInx && arr[i+1]>arr[i]){
                i++;
            }
            if (arr[root]<arr[i]){
                swap(arr,root,i);
                root=i;
            }else {
                break;
            }
        }
    }

    static void swap(int arr[],int a,int b){
        int tep = arr[a];
        arr[a]=arr[b];
        arr[b] = tep;
    }

    //7.归并排序
    static void mergeSort(int arr[],int left,int right,int arrTep[]){
        if (left<right){
            int mid = (left+right)/2;
            mergeSort(arr,left,mid,arrTep);
            mergeSort(arr,mid+1,right,arrTep);
            mergeTwo(arr,left,mid,right,arrTep);
        }
    }

    static void mergeTwo(int arr[],int left,int mid,int right,int[] arrTep){
        int low = left;
        int frist = left;
        int second = mid+1;
        while (frist <= mid && second <= right){
            if (arr[frist]<arr[second]){
                arrTep[low] = arr[frist];
                low++;
                frist++;
            }else {
                arrTep[low]=arr[second];
                low++;
                second++;
            }
        }

        if (frist>mid){
            while (second<=right){
                arrTep[low]=arr[second];
                low++;
                second++;
            }
        }
        if (second>right){
            while (frist<=mid){
                arrTep[low]=arr[frist];
                low++;
                frist++;
            }
        }

        for (int i = left; i <= right ; i++) {
            arr[i]=arrTep[i];
        }
    }


    //8.基数排序
}
