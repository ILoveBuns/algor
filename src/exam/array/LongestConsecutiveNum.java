package exam.array;

import java.util.HashSet;
// 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。

//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
//
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9

public class LongestConsecutiveNum {

    public static void main(String[] args) {
        //连续最长子序列
        longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1});
    }

    static void longestConsecutive(int[] num){

        HashSet<Integer> hashSet = new HashSet<>();
        for (Integer value:num) {
            hashSet.add(value);
        }

        int max = -1;
        int curLength = 1;
        int end = -Integer.MAX_VALUE;
        for (Integer value:num) {
            if (!hashSet.contains(value-1)){
                continue;
            }
            while (hashSet.contains(value-1)){
                value++;
                curLength++;
                if (curLength > max){
                    max = curLength;
                    end = value-1-1;
                }
            }
            curLength=0;
        }
        System.out.println("最长子序列长度："+max);

        for (int i = max; i > 0 ; i--) {
            System.out.print((end-i+1)+",");
        }
    }
}
