package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class FindDrop {
    private static String pattern = ".*(?i)drop\\s+(?i)table\\s+decocase.*";

    public static void main(String[] args) throws Exception{
        String path = "/Users/mac/Downloads/2";
        File file = new File(path);
        File[] fs = file.listFiles();
        for(File f:fs){
            if(!f.isDirectory()){
                fun(f);
            }
        }
//        System.out.println(containsDrop("ascasc Drop  Table decocase asdfadscfvcc"));
        System.out.println("ok");
    }

    private static boolean fun(File file) throws Exception{
        FileInputStream inputStream = new FileInputStream(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String str = null;
        while((str = bufferedReader.readLine()) != null)
        {
            if(containsDrop(str)){
                System.out.println(str);
                System.out.println(file.getAbsoluteFile());
                return true;
            }
        }

        inputStream.close();
        bufferedReader.close();
        return false;
    }

    private static boolean containsDrop(String string){
        return Pattern.matches(pattern, string);
    }
}

