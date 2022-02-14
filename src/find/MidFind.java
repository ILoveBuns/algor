package find;

import sort.ArrTools;

import java.util.Arrays;

/**
 * 二分查找
 */
public class MidFind {
    public static void main(String[] args) {
        int[] arr = ArrTools.generateArrN((int)(Math.random() * 10000));
//        int[] arr = new int[]{35, 134, 169, 281, 404, 633, 691, 736, 759, 913};

        Arrays.sort(arr);
        System.out.println("源数组："+Arrays.toString(arr));
        int num = arr[(int) (Math.random() * arr.length)];
//        int num = 736;
        System.out.println("目标值："+num);
        int inx = midFind(arr,0,arr.length,num);
        System.out.println("查询的索引："+inx);
        System.out.println("索引位置的值："+arr[inx]);
    }
    static int midFind(int[] arr,int left,int right,int num){
        int mid = (left + right) / 2;
        if (left > right){
            return -1;
        }

        if (arr[mid] == num){
            return mid;
        }
        if (arr[mid] > num){
            return midFind(arr,left,mid-1,num);
        }else {
            return midFind(arr,mid+1,right,num);
        }
    }
}
