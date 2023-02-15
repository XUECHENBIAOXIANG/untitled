import java.util.Scanner;

public class CS203_1_2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String zhuang=in.next();
        String pai1=in.next();
        String pai2=in.next();
        String pai3=in.next();
        String pai4=in.next();
        String pai5=in.next();
        int duan=0;
        char j1=zhuang.charAt(0);
        char j2=pai1.charAt(0);
        char j3=pai2.charAt(0);
        char j4=pai3.charAt(0);
        char j5=pai4.charAt(0);
        char j6=pai5.charAt(0);
        char h1=zhuang.charAt(1);
        char h2=pai1.charAt(1);
        char h3=pai2.charAt(1);
        char h4=pai3.charAt(1);
        char h5=pai4.charAt(1);
        char h6=pai5.charAt(1);
        if (j1==j2|j1==j3|j1==j4|j1==j5|j1==j6|h1==h2|h1==h3|h1==h4|h1==h5|h1==h6){
            duan=1;
        }
        if (duan==1){
            System.out.println("All in");
        }else {
            System.out.println("Fold");
        }
    }
}
