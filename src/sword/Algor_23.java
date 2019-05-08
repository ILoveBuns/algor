package sword;

/**
 *
 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Algor_23 {
    public static void main(String[] args) {
        System.out.println(VerifySquenceOfBST(new int[]{7,4,6,5}));
    }

    //二叉搜索树，左子树所有结点永远小于根结点，右子树所有结点大于根结点
    private static boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0){
            return true;
        }
        //类似二分法，将整数序列拆分成多个子序列，判断每个子序列是否是，若不是，在sb中加入一个标记量
        //最后判断标记量的个数是不是等于0
        StringBuffer sb = new StringBuffer();
        adjust(sequence,0,sequence.length-1,sb);
        return sb.length()==0;
    }

    //sequence[end]就是root
    private static void adjust(int [] sequence,int start,int end,StringBuffer sb){
        if(end - start == 0){
            return;
        }
        for (int i = start; i < end; i++) {
            if(sequence[i]>sequence[end]){
                if(i>start){
                    adjust(sequence,start,i-1,sb);
                }
                for (int j = i; j < end; j++) {
                    if(sequence[j]<sequence[end]){
                        //表示该子树不是后序遍历的子树
                        sb.append(1);
                    }
                }
                adjust(sequence,i,end-1,sb);
            }
        }
    }
}
