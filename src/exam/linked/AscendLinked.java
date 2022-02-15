package exam.linked;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 合并N个升序链表
 */
public class AscendLinked {
    public static void main(String[] args) {
        int k = (int)(Math.random()*10);
        LinkedList<Integer>[] arr = LinkedTool.generateLinkNodeArr(k);

        System.out.println(Arrays.toString(arr[0].toArray()));
        System.out.println(Arrays.toString(arr[1].toArray()));
        LinkedList<Integer> list = merge2LinkedList(arr[0],arr[1]);
        System.out.println(Arrays.toString(list.toArray()));
    }

    //合并K个有序数组
    static LinkedList<Integer> divide(LinkedList<Integer>[] arr,int left,int right){
        if (left == right){
            return arr[left];
        }
        int mid = (left + right) / 2;
        divide(arr,left,mid);
        divide(arr,mid+1,right);

        return null;
    }


    //合并2个有序数组
    static LinkedList<Integer> merge2LinkedList(LinkedList<Integer> list1,LinkedList<Integer> list2){
        LinkedList<Integer> out = new LinkedList<>();
        int firstP = 0;
        int secondP = 0;
        while (true){
            if (firstP >= list1.size()){
                while (secondP<list2.size()){
                    out.add(list2.get(secondP));
                    secondP++;
                }
            }
            if (secondP >= list2.size()){
                while (firstP<list1.size()){
                    out.add(list1.get(firstP));
                    firstP++;
                }
            }
            if (firstP >= list1.size() && secondP >= list2.size()){
                return out;
            }

            int firstValue = list1.get(firstP);
            int secondValue = list2.get(secondP);
            if (firstValue <= secondValue){
                out.add(firstValue);
                firstP++;
            }else {
                out.add(secondValue);
                secondP++;
            }
        }
    }
}