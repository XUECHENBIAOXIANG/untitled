import java.io.*;
import java.util.Arrays;

import java.util.StringTokenizer;

public class CS203_9_4 {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int N= in.nextInt();
        int[]a=new int[N+1];
        Long sum=0L;
        for (int i=1;i<N+1;i++){
            a[i]= in.nextInt();
            sum+=a[i];
        }
        Arrays.sort(a);
        Reverse(a);
        boolean graph=false;
        if (sum%2==0){
            graph=true;
        }
        boolean simple=true;
        if (graph){
            long[]he=new long[N+1];
            he[N]=a[N];
            for (int i=N-1;i>0;i--){
                he[i]=he[i+1]+a[i];
            }
            int k=N;
            long xvqiu=0;
            for (int i=1;i<N+1;i++){
                xvqiu+=a[i];
                long zuobian=((long)i)*(i-1);
                while (a[k]<i&&k>=i+1){
                    k--;
                }
                long zhongjian=0;
                long youbian=0;
                if (k<=i){
                    if (i+1<=N){
                    youbian=he[i+1];}
                }else {
                    zhongjian=(k-i)*(long)i;
                    if (k+1<=N){
                        youbian=he[k+1];
                    }
                }
                if (xvqiu>zuobian+youbian+zhongjian){
                    simple=false;
                    break;
                }
            }

        }else {
            simple=false;
        }
        boolean tree=false;
        if (simple){
            if (sum==2*N-2){
                if (N==1){
                    if (a[1]==0){
                        tree=true;
                    }
                }else {
                    boolean lin=false;
                    for (int i=1;i<N+1;i++){
                        if (a[i]==0){
                            lin=true;
                        }
                    }
                    if (!lin){
                        tree=true;
                    }
                }
            }
        }
        if (graph){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
        if (simple){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
        if (tree){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }







        out.close();
    }
    public  static void   Reverse(int array[]){
                for(int i=1,k=array.length-1;i<k;i++,k--){
                     int temp = array[i];
                    array[i] = array[k];
                      array[k] = temp;
                }

          }
    private static class QReader {
        private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer tokenizer = new StringTokenizer("");

        private String innerNextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        public boolean hasNext() {
            while (!tokenizer.hasMoreTokens()) {
                String nextLine = innerNextLine();
                if (nextLine == null) {
                    return false;
                }
                tokenizer = new StringTokenizer(nextLine);
            }
            return true;
        }

        public String nextLine() {
            tokenizer = new StringTokenizer("");
            return innerNextLine();
        }

        public String next() {
            hasNext();
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
    private static class QWriter implements Closeable {
        private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        public void print(Object object) {
            try {
                writer.write(object.toString());
            } catch (IOException e) {
                return;
            }
        }

        public void println(Object object) {
            try {
                writer.write(object.toString());
                writer.write("\n");
            } catch (IOException e) {
                return;
            }
        }

        @Override
        public void close() {
            try {
                writer.close();
            } catch (IOException e) {
                return;
            }
        }
    }
}
