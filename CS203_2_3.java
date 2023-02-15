import java.util.Scanner;

public class CS203_2_3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int student =in.nextInt();
        int bing=in.nextInt();
        double []fen=new double[bing];
        for (int a=0;a<bing;a++){
           double b=in.nextDouble();
           fen[a]=b*b*Math.PI;
        }
       double max=fen[0];
        for (int a=0;a<bing;a++){
            if (fen[a]>max){
                max=fen[a];
            }
        }
       double zuo=0;
        while (max-zuo>0.00000001){
            double middle=(zuo+max)/2;
            if (check(student,fen,middle)){
                zuo=middle;

            }else{
                max=middle;

            }
        }
        System.out.printf("%.7f",max);



    }
    public static boolean check(int student,double[]fen,double middle){
        int b=0;
        for (int a=0;a< fen.length;a++){
            b+=Math.floor(fen[a]/middle);
        }
        if (b>=student){
            return true;
        }else {
            return false;
        }

    }

}
