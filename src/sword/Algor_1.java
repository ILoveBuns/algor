package sword;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一
 * 个整数，判断数组中是否含有该整数
 */
public class Algor_1 {
    public static void main(String[] args) {

        int rows = 1000;
        int cols = 1000;
        int target = (int)(Math.random()*100);
        int[][] array = new int[rows][cols];
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                if(row == 0 && col == 0){
                    array[row][col] = (int)(Math.random()*10);
                    continue;
                }
                if(row == 0){
                    array[row][col] = array[row][col-1]+(int)((Math.random()+0.1)*10);
                    continue;
                }
                if(col == 0){
                    array[row][col] = array[row-1][col]+(int)((Math.random()+0.1)*10);
                    continue;
                }
                int moreThanrow = array[row-1][col]+(int)((Math.random()+0.1)*10);
                int moreThancol = array[row][col-1]+(int)((Math.random()+0.1)*10);
                array[row][col] = Max(moreThanrow,moreThancol);
            }
        }
        System.out.println(Find(target,array));
    }

    private static boolean Find(int target, int [][] array) {
        for (int[] arrRow:array) {
            for (int v:arrRow  ) {
                if (v == target){
                    return true;
                }
            }
        }
        return false;
    }
    private static int Max(int a,int b){
        return a>b ? a:b;
    }
}
