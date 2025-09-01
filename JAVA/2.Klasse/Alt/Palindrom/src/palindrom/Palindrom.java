
package palindrom;
import java.util.Scanner;
//220227
public class Palindrom {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       String wort;
       String wd;
        System.out.println("Bitte geben sie ihr Palindrom ein");
        wort=sc.next();
        String wr = umdreher(wort,sc);
        System.out.println(wr);
        System.out.println("Wollen sie das Programm Wiederholen?");
        wd=sc.next();
        if(wd.equals("ja")){
            main(args);
        }
    }
    public static String umdreher(String wort, Scanner sc){
        String rückwärts="";
        for (int i = 0; i < wort.length(); i++) {
            char c = wort.charAt (wort.length() -1 -i);
            rückwärts=rückwärts+c;
        }
        return rückwärts;
    }
}
 