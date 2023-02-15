import java.util.Random;

public class CS203_4_4_test {
    public static void main(String[] args) {
        Random a=new Random();
        int b=a.nextInt(100);
        System.out.println(b);
        for (int c=0;c<b;c++){
            System.out.print(a.nextInt(100));
            System.out.print(" ");
        }
    }
}
