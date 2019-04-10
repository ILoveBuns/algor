package sword;

/**
 *请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 *例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Algor_2 {
    static String ori ="";

    public static void main(String[] args) {
        ori = "we Are Happy";

        String s = replaceSpace(new StringBuffer(ori));
        System.out.println(s);
    }

    public static String replaceSpace(StringBuffer str) {
        String s = str.toString();
        String out = s.replace(" ","%20");
        return  out;
    }
}
