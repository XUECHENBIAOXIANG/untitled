import java.util.Scanner;
public class CS203_1_1 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int total=in.nextInt();
        for (int running=1;running<=total;running++){
            int length =in.nextInt();
            int width =in.nextInt();
            int height =in.nextInt();
            int b =2*height+2*width+1;
            int c =2*length+2*width+1;
            char[][] a=new char[b][c];
            for (int w=0;w<b;w++){
                for (int x=0;x<c;x++){
                    a[w][x]='.';//画出点
                }
            }
            for (int d=2*width;d<b;d++){
                for (int e=0;e<2*length+1;e++){
                    if (d%2==0&e%2==0){
                        a[d][e]='+';
                    }
                    if (d%2==0&e%2==1){
                        a[d][e]='-';
                    }
                    if (d%2==1&e%2==0){
                        a[d][e]='|';
                    }
                    if (d%2==1&e%2==1){
                        a[d][e]='.';
                    }
                }
            }
            for (int d=0;d<2*width;d++){
                for (int e=2*width-d;e<c-d;e++){
                    if (d%2==0&e%2==0){
                        a[d][e]='+';
                    }
                    if (d%2==0&e%2==1){
                        a[d][e]='-';
                    }
                    if (d%2==1&e%2==0){
                        a[d][e]='.';
                    }
                    if (d%2==1&e%2==1){
                        a[d][e]='/';
                    }
                }
            }

            for (int d=c-1;d>c-2*width-1;d--){
                for (int e=1+c-1-d;e<c-d+2*height;e++){
                    if (d%2==0&e%2==0){
                        a[e][d]='+';
                    }
                    if (d%2==0&e%2==1){
                        a[e][d]='|';
                    }
                    if (d%2==1&e%2==0){
                        a[e][d]='.';
                    }
                    if (d%2==1&e%2==1){
                        a[e][d]='/';
                    }
                }
            }






            for (int y=0;y<b;y++){
                for (int z=0;z<c;z++){
                    System.out.print(a[y][z]);
                }
                System.out.println();
            }
        }

    }
}
