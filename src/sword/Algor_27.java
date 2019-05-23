package sword;

import java.util.*;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */

// 将str放入队列中，遍历时，每次将字符串的首位和后面的每位交换，交换后的字符串若没出现过，则放入队列中，若已出现过，则跳过
// 每次从队头拿字符串，重复上述操作，直至队列为空
// 按照字典序遍历，只需重写ArrayList的sort方法即可
public class Algor_27 {
    private static LinkedList<String> queque = new LinkedList<>();
    private static HashSet<String> hashSet = new HashSet<>();
    public static void main(String[] args) {
        Permutation("abc");
    }
    private static ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();

        if ("".equals(str)){
            return list;
        }
        queque.add(str);
        hashSet.add(str);

        str = queque.pop();
        while (str != null){
            list.add(str);
//            System.out.println(str);
            //j表示字符串char的索引
            for (int j = 0; j < str.length(); j++) {
                String tep = swap(str,0,j);
                add(tep);
            }
            if (queque.isEmpty()){
                sort(list);
                System.out.println(list);
                return list;
            }
            str = queque.pop();
        }
       sort(list);
        return list;
    }
    private static void add(String str){
        if (hashSet.add(str)){
            queque.add(str);
        }
    }

    private static String swap(String str,int i,int j){
        StringBuffer sb = new StringBuffer(str);
        char tep = sb.charAt(j);
        sb.setCharAt(j,sb.charAt(i));
        sb.setCharAt(i,tep);
        return sb.toString();
    }

    private static void sort(ArrayList<String> list){
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                for (int i = 0; i < o1.length(); i++) {
                    if(o1.charAt(i) == o2.charAt(i)){
                        continue;
                    }
                    return o1.charAt(i)-o2.charAt(i);
                }
                return 0;
            }
        });
    }
}
