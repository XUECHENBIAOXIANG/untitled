import java.util.ArrayList;
import java.util.Collections;

public class CS203_3_4_test {
    public static void main(String[] args) {
        int a= (int) (Math.random()*3000);
        int gg=(int) (Math.random()*10)*10*100;
        int b= (int) (Math.random()*50)*10;

        System.out.println(a+" "+gg+" "+b);
        ArrayList<Integer> gei= new ArrayList<>();
        for (int c = 0; c < 10; c++) {
            gei.add(c);
        }
        int tt=0;
        for (int g=0;g<a;g++) {
            Collections.shuffle(gei);
            if (tt==0){
                System.out.print("-");
                tt=1;
            }else {
                tt=0;
            }
            for (int c = 0; c < 9; c++) {
                System.out.print(gei.get(c));
            }
            System.out.print(" ");
        }
    }
}
