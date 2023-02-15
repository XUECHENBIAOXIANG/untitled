import java.util.Scanner;

public class CS203_2_1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int total=in.nextInt();
        int time=in.nextInt();
        int[]shou=new int[total];
        for (int a=0;a<total;a++){
            shou[a]=in.nextInt();
        }
        for (int a=0;a<time;a++){
            int left=-1;
            int right=total;
            int left1=-1;
            int right1=total;
            int chu=in.nextInt();
            int wei=in.nextInt();
            while (left+1!=right){
                int middle=(left+right)/2;
                if (shou[middle]<=chu){
                    left=middle;
                }else {
                    right=middle;
                }
            }
            while (left1+1!=right1){
                int middle1=(left1+right1)/2;
                if (shou[middle1]<wei){
                    left1=middle1;
                }else {
                    right1=middle1;
                }
            }
            if(right<=left1){
                System.out.print("YES ");System.out.println(left1-right+1);
            }else {
                System.out.println("NO ");
            }


        }
    }
}
