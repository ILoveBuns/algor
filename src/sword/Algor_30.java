package sword;

/**
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,
 * 问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
 * 并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},
 * 连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，
 * 你会不会被他忽悠住？(子向量的长度至少是1)
 */

public class Algor_30 {
    public static void main(String[] args) {
        int out = FindGreatestSumOfSubArray(new int[]{6,-3,-2,7,-15,1,2,2});
        System.out.println(out);
    }

    //clone一个数组，该数组从第二个位置开始存储到它那个位置为止的所有最大子序列
    //则之后每个位置，只需要比较他的当前值和前一个位置的和，取最大值即可
    //最后遍历clone数组，取的最大值即为最大连续子序列的和
    private static int FindGreatestSumOfSubArray(int[] array) {
        if(array.length == 1){
            return array[0];
        }
        int[] clone = array.clone();
        for (int i = 1; i < array.length; i++) {
            clone[i] = clone[i]>(clone[i]+clone[i-1])?clone[i]:(clone[i]+clone[i-1]);
        }

        //获取clone的最大值
        int max = Integer.MIN_VALUE;
        for (int v : clone) {
            if(max < v){
                max = v;
            }
        }
        return max;
    }
}
