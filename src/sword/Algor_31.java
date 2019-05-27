package sword;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class Algor_31 {
    public static void main(String[] args) {
        int sum = NumberOf1Between1AndN_Solution(999999999);
        System.out.println(sum);
    }
    private static int NumberOf1Between1AndN_Solution(int n) {
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
