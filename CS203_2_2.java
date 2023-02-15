import java.util.Scanner;

public class CS203_2_2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int total=in.nextInt();
        long sum= in.nextInt();
        long[] shu=new long[total];
        long ji=0L;
        for (int a=0;a<total;a++){
            shu[a]=in.nextLong();
        }
        for (int a=0;a<total;a++){
            if (shu[a]<sum){
                for (int b=a+1;b<total-1;b++){
                    int left=b;
                    int right=total;
                    int left1=b;
                    int right1=total;
                    while (left+1!=right){
                        int middle=(left+right)/2;
                        if (shu[a]+shu[b]+shu[middle]<sum){
                            left=middle;
                        }else {
                            right=middle;
                        }
                    }
                    while (left1+1!=right1){
                        int middle1=(left1+right1)/2;
                        if (shu[a]+shu[b]+shu[middle1]<=sum){
                            left1=middle1;
                        }else {
                            right1=middle1;
                        }

                    }
                    ji=ji+left1-right+1;
                }

            }



        }
        System.out.println(ji);
    }
}
