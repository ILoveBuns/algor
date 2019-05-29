package sword;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class Algor_31 {
//    private static int sum = 0;
    public static void main(String[] args) {
        int sum = NumberOf1Between1AndN_Solution1(791);
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
        int a = nPower(dig(n))*;

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



    private static int NumberOf1Between1AndN_Solution1(int n) {
        int sum = 0;
        for (int i = 0; i < n+1; i++) {
            sum = sum + cal(Integer.toString(i));
        }
        return sum;
    }

    private static int cal(String str){
        char[] chars = str.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (c == '1'){
                count++;
            }
        }
        return count;
    }
}
