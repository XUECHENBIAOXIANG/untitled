import java.util.Scanner;

public class CS203_1_3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int x1=in.nextInt();
        int y1=in.nextInt();
        int x2=in.nextInt();
        int y2=in.nextInt();
        int a=in.nextInt();
        int b=suanshu(x1,x2,y1,y2,a);
        System.out.println(b);

    }

    public static int suanshu(int x1, int x2, int y1, int y2, int e){
        int[][] guo=new int[x2-x1+1][y2-y1+1];
        for (int c=0;c<x2-x1+1;c++){
            for (int d=0;d<y2-y1+1;d++){
                if (c==0|d==0){
                    guo[c][d]=1;
                }else {
                    guo[c][d]=(guo[c-1][d]+guo[c][d-1])%e;
            }
            }

        }
        return guo[x2-x1][y2-y1];

    }
}
