package sword;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Algor_12 {
    public static void main(String[] args) {
        System.out.println(Power(2.3,8));
    }
    private static double Power(double base, int exponent) {
        return Math.pow(base,exponent);
    }
}
