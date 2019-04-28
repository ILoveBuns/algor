package sword;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */

//本方法，是设x位竖着放的个数，y为横着放的个数。则x+2y=n，n从0开始递增，保证x和y为整数
//每获得一次（x，y），x和y进行组合，公用C（x+y，x）中可能，累加即得答案。

//本题还有一种更方便的方法，斐波那契数列
//应为可以横着放或竖着放，多以f(n)可以是2*(n-1)的矩形加一个竖着放的2*1的矩形或2*(n-2)的矩形加2横着放的，即f(n)=f(n-1)+f(n-2)
//当到了最后，f(1)=1,f(2)=2
public class Algor_10 {
    public static void main(String[] args) {
        System.out.println(RectCover(0));
        System.out.println(RectCover(29));
    }
    private static long RectCover(int target) {
        if (target==0){
            return 0;
        }
        int sum = 0;
        int y = 0;//其中2*y表示横着放的矩形快的个数
        while(2*y<=target){
            int x = target - 2*y;
            sum = sum+cal(x,y).intValue();
            y++;
        }
        return sum;
    }

    //计算x个竖着放的矩形和2y个横着放的矩形的可能性
    private static BigDecimal cal(int x,int y){
        return  factorial(x+y).divide(factorial(x).multiply(factorial(y)));
    }

    //计算阶乘
    private static BigDecimal factorial(int n){
        BigDecimal sum = new BigDecimal(1);
        for (long i = n; i > 0 ; i--) {
            sum = sum.multiply(new BigDecimal(i));
        }
        return sum;
    }
}
