package sword;

import java.util.*;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Algor_29 {
    public static void main(String[] args) {
        ArrayList<Integer> list = GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8},4);
        System.out.println(list);
    }
    private static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        TreeSet<MyInteger> set = new TreeSet<>();
        for (int i = 0; i < input.length; i++) {
            set.add(new MyInteger(input[i]));
        }
        Iterator it = set.iterator();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if(it.hasNext()){
                list.add(((MyInteger) it.next()).value);
            }else {
                return new ArrayList<>();
            }
        }
        return list;
    }

    private static class MyInteger implements Comparable {
        @Override
        public int compareTo(Object o){
            if(o instanceof MyInteger){
                return this.value - ((MyInteger) o).value;
            }
            return 0;
        }
        @Override
        public int hashCode(){
            return this.value;
        }
        @Override
        public boolean equals(Object o){
            if(o instanceof MyInteger){
                return this.value == ((MyInteger) o).value;
            }
            return false;
        }
        int value;
        MyInteger(int value){
            this.value = value;
        }
    }
}
