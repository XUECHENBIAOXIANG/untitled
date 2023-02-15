import java.util.*;

public class CS203_4_3_test {
    public static void main(String[] args) {
        Random a=new Random();
        int b=20;
        int c=20;
        int d=a.nextInt(100);
        System.out.printf("%d %d %d",b,c,d);
        System.out.println();
        for (int e=0;e<b;e++){
            for (int f=0;f<c;f++){
                System.out.print(a.nextInt(100));
                System.out.print(" ");
            }
            System.out.println();
        }
        for (int pp=0;pp<d;pp++) {
            int e = a.nextInt(b-4)+3;
            int f = a.nextInt(c-4)+3;
            int g = a.nextInt(e-2)+1;
            int h = a.nextInt(f-2)+1;
            int i = Math.min(20-g,a.nextInt(e-g-1)+1);
            int j = Math.min(20-f,a.nextInt(f-h-1)+1);


            System.out.printf("%d %d %d %d %d %d\n", e, f, g, h, i, j);
        }
    }



}
