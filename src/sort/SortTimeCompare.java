package sort;

import java.util.Arrays;

public class SortTimeCompare {

    public static void main(String[] args) {
        int[] arr = ArrTools.generateArrN(10000000);
//        int[] arrClone = Arrays.copyOf(arr,arr.length);

        long begQuick = System.currentTimeMillis();
        QuickSort.quickSort(arr,0,arr.length-1);
        long timeQuick = System.currentTimeMillis()-begQuick;
        System.out.println("快排耗时："+timeQuick);

//        long begSwitch = System.currentTimeMillis();
//        SwitchSort.switchSort(arrClone);
//        long timeSwitch = System.currentTimeMillis()-begSwitch;
//        System.out.println("交换排序耗时："+timeSwitch);

    }
}
