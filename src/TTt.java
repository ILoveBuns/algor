import java.util.ArrayList;
import java.util.Arrays;

public class TTt {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (int i = 0; i < 4; i++) {
            System.out.println(list.remove(0));
        }


//        String s1 = "ab";
//        String s2 = "eidbaooo";
//        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        s1 = sort(s1);
        int gap = s2.length() - s1.length();
        for (int i = 0; i <= gap; i++) {
            String tep = s2.substring(i, i + s1.length());
            String debug = sort(tep);
            if (s1.equals(debug)) {
                return true;
            }
        }
        return false;
    }

    public static String sort(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
