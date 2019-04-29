package sword;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Algor_11 {
    public static void main(String[] args) {
        System.out.println(NumberOf1(-2147483648));
    }
    private static int NumberOf1(int n) {
        if (n==0){
            return 0;
        }
        if (n>0){
            return getNumForPosi(n);
        }
        if (n<0){
            return getNumForNega(n);
        }
        return -1;
    }

    //正数的二进制用辗转相除法
    private static int getNumForPosi(int n){
        StringBuffer sb =  getCode(n);
        return getOne(sb.reverse());
    }

    //负数的补码为原码，除了最高位外取反
    private static int getNumForNega(int n){
        StringBuffer sb =  getCode(-1*n);
        //除最高位按位取反，得反码
        sb.setCharAt(0,'1');
        for (int i = 1; i < sb.length(); i++) {
            sb.setCharAt(i,sb.charAt(i)=='1'?'0':'1');
        }
        System.out.println("反码："+sb.toString());
        //反码加1
        for (int i = sb.length()-1; i > 0 ; i--) {
            if (sb.charAt(i) == '0'){
                sb.setCharAt(i,'1');
                break;
            }
            sb.setCharAt(i,'0');
        }
        System.out.println("补码："+sb.toString());
        return getOne(sb);
    }

    //求正数的源码
    private static StringBuffer getCode(int n){
        StringBuffer sb =  new StringBuffer();
        while (sb.length()<32){
            int shang = n % 2;
            n = n/2;
            sb.append(Integer.toString(shang).charAt(0));
        }
        return sb.reverse();
    }

    //计算stringbuffer中1的个数
    private static int getOne(StringBuffer sb){
        int k = 0;
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i)=='1'){
                k++;
            }
        }
        return k;
    }
}
