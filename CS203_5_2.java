import java.util.Scanner;

public class CS203_5_2 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int[] a=new int[100000];
        String S=in.next();
        int top=0;
        for (int b=0;b<S.length();b++){
            char d=S.charAt(b);
            if (d=='('){
                top++;
                a[top]=0;
            }else {
                if (a[top]==0){
                    top--;
                    a[top]++;

                }else {
                    top--;
                    a[top]=(a[top+1]*2+a[top])%514329;
                }
            }

            }
        System.out.print(a[0]%514329);
        }
    }

