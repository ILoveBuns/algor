package sword;

/*把只包含质因子2、3和5的数称作丑数（Ugly Number）。
例如6、8都是丑数，但14不是，因为它包含质因子7。
习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
*/
public class Algor_33 {
    public static void main(String[] args) {
        int index = 42;
        System.out.println(GetUglyNumber_Solution(index));
    }

    private static int GetUglyNumber_Solution(int num) {
       int index = 0;
       int cur = 1;
       while (true){
           if(isUgly(cur)){
               index++;
               if(index == num){
                   return cur;
               }
           }
           cur++;
       }
    }
    private static boolean isUgly(int n){
        while (true){
            int tep = n%2;
            if(tep == 0){
                n = n/2;
            }else {
                break;
            }
        }

        while (true){
            int tep = n%3;
            if(tep == 0){
                n = n/3;
            }else {
                break;
            }
        }

        while (true){
            int tep = n%5;
            if(tep == 0){
                n = n/5;
            }else {
                break;
            }
        }
        return n==1;
    }
}
