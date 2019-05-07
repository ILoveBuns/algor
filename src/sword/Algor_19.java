package sword;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 例如，如果输入如下4 X 4矩阵：
 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 则依次打印出数字
 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Algor_19 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> list = printMatrix(arr);
        System.out.println(Arrays.toString(list.toArray()));
    }

    private static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int pr = 0;
        int pc = 0;
        rotate(matrix,list,pr,pc);
        return list;
    }

    private static void rotate(int [][] matrix,ArrayList<Integer> list,int pr,int pc){
        if (pr == matrix.length-1-pr){
                list.add(matrix[pr][pc]);
                return;
            }
            ArrayList<Integer> l1 = new ArrayList<>();
            ArrayList<Integer> l2 = new ArrayList<>();
            for (int col = pc; col < matrix.length-pc; col++) {
                l1.add(matrix[pr][col]);
                l2.add(matrix[matrix.length-1-pr][matrix.length-1-col]);
            }
            if (pr == matrix.length-1-pr-1){
                list.addAll(l1);
                list.addAll(l2);
                return;
        }
        for (int row = pr+1; row < matrix.length-pr-1; row++) {
            l1.add(matrix[row][matrix.length-1-pc]);
            l2.add(matrix[matrix.length-1-row][pc]);
        }
        list.addAll(l1);
        list.addAll(l2);
        rotate(matrix,list,pr+1,pc+1);
    }
}
