package sort;

public class ArrTools {
    //生生一个长度为n的随机数组
    public static int[] generateArrN(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int)(Math.random()*1000000000);
        }
        return arr;
    }

    //打印一个数组
    public static void printArr(int[] arr){
        for (int num : arr) {
            System.out.print(num+",");
        }
        System.out.println();
    }

    //判断一个数组是否是递增
    public static boolean isIncrement(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }

}
