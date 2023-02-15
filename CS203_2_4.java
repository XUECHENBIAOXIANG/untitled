import java.util.Scanner;

public class CS203_2_4 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        long xr=in.nextLong();
        long yr=in.nextLong();
        long xc=in.nextLong();
        long yc=in.nextLong();
        int period=in.nextInt();
        int x_chang=0;
        int y_chang=0;
        String bian=in.next();
        for (int a=0;a<period;a++){
            switch (bian.charAt(a)){
                case 'U':
                       y_chang++;
                    break;
                case 'D':
                    y_chang--;
                    break;
                case 'L':
                    x_chang--;
                    break;
                case 'R':
                    x_chang++;
                    break;
            }
        }
        long max=100000000000000000l;
        long min=0l;
        int cc=0;

        while (max!=min+1) {
            long middle = (max + min) /2;
            if (check(xr,yr,xc,yc,middle,x_chang,y_chang,period,bian)){
                max=middle;
                cc=1;
            }else {
                min=middle;
            }
        }
        if (cc==0){
            System.out.println("-1");
        }else if (check(xr,yr,xc,yc,min,x_chang,y_chang,period,bian)){
            System.out.println(min);
        }else {
            System.out.println(max);
        }




    }
    public static boolean check(long xr,long yr, long xc,long yc, long maybe, int x_chang,int y_chang,int period,String bian){
        long lost= maybe%period;
        long time=maybe/period;
        xr=xr+x_chang*time;
        yr=yr+y_chang*time;
        for (int a=0;a<lost;a++){
            switch (bian.charAt(a)){
                case 'U':
                    yr++;
                    break;
                case 'D':
                    yr--;
                    break;
                case 'L':
                    xr--;
                    break;
                case 'R':
                    xr++;
                    break;
            }
        }
        long cha=Math.abs(xc-xr)+Math.abs(yc-yr);
        if (cha<=maybe){
            return true;
        }
        else {
            return false;
        }


    }

}
