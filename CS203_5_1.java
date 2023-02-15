import java.util.Scanner;

public class CS203_5_1 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int time =in.nextInt();
        int[] t=new int[100000];
        int rear=0;
        int front=0;
        for (int a=0;a<time;a++){
            String S=in.next();
            if (S.equals("E")){
                t[rear++]=in.nextInt();
            }else {
                front+=in.nextInt();
                System.out.println(t[front]);
            }
        }
    }
}
