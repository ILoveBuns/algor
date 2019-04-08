package offor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        while (sc.hasNextLine()) {
            str = sc.nextLine();
            if(str.equals("exit")){
                break;
            }
            System.out.println("test:"+str);
        }
    }

}
