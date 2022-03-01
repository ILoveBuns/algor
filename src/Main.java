import find.MidFind;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
    //(1)创建ThreadLocal变量
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        //在main线程中添加main线程的本地变量
        threadLocal.set("mainVal");
        //新创建一个子线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程中的本地变量值:"+threadLocal.get());
            }
        });
        thread.start();
        //输出main线程中的本地变量值
        System.out.println("mainx线程中的本地变量值:"+threadLocal.get());

//        int[][] arr = {{1,2,3},{15,5,7},{6,3,12}};
//        Main m = new Main();
//        int dis = m.findLongestDis(arr,0,2);
//        System.out.println(dis);
    }

    int findLongestDis(int[] arr[], int x, int y){
        Queue<pos> queue = new ArrayDeque<>();
        queue.add(new pos(x,y,0));
        int maxDis=0;
        while (!queue.isEmpty()){
            pos cur = queue.poll();

            ArrayList<pos> list = new ArrayList<>();
            if (cur.x - 1 >= 0){
                list.add(new pos(cur.x-1,y,cur.level+1));
            }
            if (cur.x+1<arr.length){
                list.add(new pos(cur.x+1,y,cur.level+1 ));
            }
            if (cur.y -1 <= 0){
                list.add(new pos(cur.x, cur.y-1,cur.level+1));
            }
            if (cur.y+1<arr[0].length){
                list.add(new pos(cur.x,cur.y+1,cur.level+1));
            }
            for (pos p:list) {
                if (arr[p.x][p.y] > arr[cur.x][cur.y]){
                    queue.add(p);
                    if (maxDis<p.level){
                        maxDis = p.level;
                    }
                }
            }
        }
        return maxDis;
    }

    class pos{
        int x;
        int y;
        int level;
        pos(int x,int y,int level){
            this.x =x;
            this.y =y;
            this.level = level;
        }
    }


}
