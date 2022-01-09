package sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            int value = (int)(Math.random() * 10000);
            arr[i] = value;
        }
        int[] sortArr = SelectionSort(arr);

        //check
        for (int a = 0; a < sortArr.length-1; a++) {
            if (sortArr[a] > sortArr[a+1]){
                System.out.println("sort error");
                return;
            }
        }
        System.out.println("success");

    }

    public static int[] SelectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int inx = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < min){
                    min = arr[j];
                    inx = j;
                }
            }
            int tep = arr[i];
            arr[inx] = tep;
            arr[i] = min;
        }
        return arr;
    }
}
