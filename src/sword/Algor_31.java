package sword;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */

//递归解法，首先将一个整数分成两部分，整数位置和较小的一部分
//分别针对两种情况进行递归
public class Algor_31 {
    public static void main(String[] args) {
        int n = 19;
        int sum = NumberOf1Between1AndN_Solution(n);
        System.out.println(sum);
    }

    private static int NumberOf1Between1AndN_Solution(int n) {
        int sum = 0;
        sum = tra(n);
        return sum;
    }

    private static int tra(int n){
        if(n/10 == 0){
            if(n==0){
                return 0;
            }
            return 1;
        }
        //分解，比如把791分解成700+91
        int weishu = dig(n);  //位数，791为3位
        int yibai = nPower(dig(n));//最高是多少，791最高为是100
        int zhengshu = n/yibai*yibai;//去除较小部分的整数是多少，791是700
        int shouwei = n/yibai; //较多部分的最高项，791是7
        int a = zhengshu;//较多的部分，781是700
        int b = n - zhengshu;//较小的部分，791是91

        //a=10,100,1000,...
        if (shouwei == 1){
            int t1= tra(zhengshu-1);
            int t2 = tra(b);
            return t1+b+1+t2;
        // a是200,300,400,...
        }else {
            int t1 = tra(yibai-1);
            int t2 = tra(b);
            return shouwei * t1+yibai+t2;
        }
    }

    //返回整数的位数
    private static int dig(int n){
        return Integer.toString(n).length();
    }
    //获取10的n次方
    private static int nPower(int num){
        return (int)(Math.pow(10,num-1));
    }
    //获取一个整数的最高位
    private static int getMaxDig(int n){
        return Integer.toString(n).charAt(0);
    }
}
