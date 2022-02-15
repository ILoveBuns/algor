package exam.array;


import java.util.Arrays;
import java.util.HashMap;

/**
 * 给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
 * 你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
 * 假设给出的数组中只存在唯一解
 */
public class ArrFindTwoInxAddEqualKey {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        int[] out = twoArrEqualKey(arr,8);
        System.out.println(Arrays.toString(out));
    }

    static int[] twoArrEqualKey(int[] arr, int key){
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!hashMap.containsKey(key - arr[i])){
                hashMap.put(arr[i],i);
            }else {
                return new int[]{hashMap.get(key - arr[i])+1,i+1};
            }
        }
        return new int[]{-1,-1};
    }
}
