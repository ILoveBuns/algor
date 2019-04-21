package sword;

import java.util.Arrays;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Algor_6 {
    public static void main(String[] args) {
        int length = 10;
        int[] tep=new int[length];
        tep[0]=(int)(Math.random()*100);
        for (int i = 1; i < length; i++) {
            tep[i]=tep[i-1]+(int)(Math.random()*100);
        }

        int[] arr = new int[length];
        int lengh_1 = 5;
        for (int i = 0; i < length; i++) {
            if(i<lengh_1){
                arr[length-lengh_1+i] = tep[i];
            }else
                arr[i-lengh_1] = tep[i];
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(minNumberInRotateArray(arr));
    }
    public static int minNumberInRotateArray(int [] array) {
        int mid = array.length/2;
        while(mid<array.length && mid>0){
            if (array[mid]<=array[mid-1]){
                return array[mid];
            }
            //说明在前一段增区间上
            if (array[mid]>array[0]){
                mid = (mid+array.length)/2;
                continue;
            }
            //说明在后一段增区间上
            if (array[mid]<array[0]){
                mid = (mid+0)/2;
                continue;
            }
        }
        return 0;
    }
}
