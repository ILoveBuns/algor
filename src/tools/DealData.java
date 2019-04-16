package tools;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 处理获取库表
 */
public class DealData {
    static Map<String, Set<String>> map = new HashMap();

    public static void main(String[] args) throws Exception {
        File file =new File("/Users/mac/Desktop/data.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine())!=null){
            line=line.replace("[","");
            line=line.replace("]","");
            line=line.replace("\"","");
            line=line.replace(" ","");

            addMap(toArrs(line));

        }
//        printMap();
        toTxt();

    }

    //获取数组
    private static String[] toArrs(String str){
        return str.split(",");
    }

    //数组转map
    private static void addMap(String[] strs){
        for (int i = 0; i < strs.length; i++) {
            String[] dbAndTab = strs[i].split(":");
            for (int j = 1; j < dbAndTab.length; j++) {
                if(map.containsKey(dbAndTab[0])){
                    map.get(dbAndTab[0]).add(dbAndTab[j]);
                }else {
                    map.put(dbAndTab[0],new HashSet<>());
                    map.get(dbAndTab[0]).add(dbAndTab[j]);
                }

            }

        }
    }

//    //打印map
//    private static void printMap(){
//        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
//            System.out.println("库:"+entry.getKey());
//            System.out.println("表:"+entry.getValue());
//            System.out.println();
//        }
//    }

    //数组输出到txt
    private static void toTxt() throws Exception{
        File file =new File("/Users/mac/Desktop/out.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            String k=entry.getKey();
            for (String str:entry.getValue()){
                String line = str+"\n\r";
                writer.write(line);
            }
        }
        writer.flush();

    }

}
