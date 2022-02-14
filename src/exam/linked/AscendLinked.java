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
        LinkedList<Integer> list = merge2LinkedList(arr);
        System.out.println(Arrays.toString(list.toArray()));
    }

    //合并K个有序数组
    static LinkedList<Integer> mergeLinkedList(LinkedList<Integer>[] arr){
        return null;
    }


    //合并2个有序数组
    static LinkedList<Integer> merge2LinkedList(LinkedList<Integer>[] arr){
        LinkedList<Integer> out = new LinkedList<>();
        int firstP = 0;
        int secondP = 0;
        while (true){
            if (firstP >= arr[0].size()){
                while (secondP<arr[1].size()){
                    out.add(arr[1].get(secondP));
                    secondP++;
                }
            }
            if (secondP >= arr[1].size()){
                while (firstP<arr[0].size()){
                    out.add(arr[0].get(firstP));
                    firstP++;
                }
            }
            if (firstP >= arr[0].size() && secondP >= arr[1].size()){
                return out;
            }

            int firstValue = arr[0].get(firstP);
            int secondValue = arr[1].get(secondP);
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