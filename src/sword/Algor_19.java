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
//        int[][] arr = new int[][]{{1,2,3,4,17,21},{5,6,7,8,18,22},{9,10,11,12,19,23},{13,14,15,16,20,24}};
        int[][] arr = new int[][]{{1,2},{3,4},{5,6},{7,8},{9,10}};

        ArrayList<Integer> list = printMatrix(arr);
        System.out.println(Arrays.toString(list.toArray()));
    }

    //顺时针打印，即一圈一圈遍历，当里面只有一行，一列，两行，两列时需要特殊考虑
    private static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int pr = 0;
        int pc = 0;
        //最后遍历的值依次放在list中
        rotate(matrix,list,pr,pc);
        return list;
    }

    private static void rotate(int[][] matrix, ArrayList<Integer> list, int pr, int pc) {
        //只有一行
        if (pr == matrix.length - 1 - pr) {
            for (int col = pc; col < matrix[pr].length - pc; col++) {
                list.add(matrix[pr][col]);
            }
            return;
        }
        //只有一列
        if (pc == matrix[pr].length - 1 - pc){
            for (int row = pr; row < matrix.length - pr; row++) {
                list.add(matrix[row][pc]);
            }
            return;
        }

        //先横向遍历，
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        for (int col = pc; col < matrix[pr].length - pc; col++) {
            l1.add(matrix[pr][col]);
            l2.add(matrix[matrix.length - 1 - pr][matrix[pr].length - 1 - col]);
        }
        //再纵向遍历
        for (int row = pr + 1; row < matrix.length - 1 - pr; row++) {
            l1.add(matrix[row][matrix[row].length - 1 - pc]);
            l2.add(matrix[matrix.length - 1 - row][pc]);
        }
        //只有两行
        if (pr == matrix.length - 1 - pr - 1) {
            list.addAll(l1);
            list.addAll(l2);
            return;
        }
        //只有两列
        if (pc == matrix[pr].length - 1 - pc - 1) {
            list.addAll(l1);
            list.addAll(l2);
            return;
        }

        //遍历完外圈后，递归遍历内圈
        list.addAll(l1);
        list.addAll(l2);
        rotate(matrix, list, pr+1, pc+1);
    }
}
