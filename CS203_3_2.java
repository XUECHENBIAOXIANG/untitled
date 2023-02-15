//快读模板2：较慢，但有next()

import java.io.*;
import java.math.*;
import java.util.*;

public class CS203_3_2 {

    public static void main(String[] args) {
        InputStream inputStream = System.in;// new FileInputStream("C:\\Users\\wavator\\Downloads\\test.in");
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    static class Task {
        static long cishu=0;
        public void solve(InputReader in, PrintWriter out) {
            int ci=in.nextInt();
            for (int tt=0;tt<ci;tt++) {
                cishu=0;
                int sum = in.nextInt();
                long[] yao = new long[sum];
                for (int a = 0; a < sum; a++) {
                    yao[a] = in.nextLong();
                }
                long[] guo = new long[sum];
                fen(yao, 0, yao.length - 1, guo);
                System.out.println(cishu);
            }
        }

        public void fen(long[]a,int low,int high,long[]guo){
            if (low<high){
                int middle=low+(high-low)/2;
                fen(a,low,middle,guo);
                fen(a,middle+1,high,guo);
                he(a,low,middle,high,guo);
            }

        }
        public void he(long[]a,int low, int middle ,int high,long[]guo){
            int mu=low;
            int hua1=low;
            int hua2=middle+1;
            while (hua1<=middle&&hua2<=high){
                if (a[hua1]<=a[hua2]){
                    guo[mu]=a[hua1];
                    mu++;
                    hua1++;
                }else {
                    guo[mu]=a[hua2];
                    mu++;
                    hua2++;
                    cishu+=middle-hua1+1;
                }
            }
            while (hua1<=middle){
                guo[mu]=a[hua1];
                mu++;
                hua1++;
            }
            while (hua2<=high){
                guo[mu]=a[hua2];
                mu++;
                hua2++;
            }
            for (int b=low;b<=high;b++){
                a[b]=guo[b];
            }

        }





    }






    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public char[] nextCharArray() {
            return next().toCharArray();
        }

        //         public boolean hasNext() {
//             try {
//                 return reader.ready();
//             } catch(IOException e) {
//                 throw new RuntimeException(e);
//             }
//         }
        public boolean hasNext() {
            try {
                String string = reader.readLine();
                if (string == null) {
                    return false;
                }
                tokenizer = new StringTokenizer(string);
                return tokenizer.hasMoreTokens();
            } catch (IOException e) {
                return false;
            }
        }

        public BigInteger nextBigInteger() {
            return new BigInteger(next());
        }

        public BigDecimal nextBigDecinal() {
            return new BigDecimal(next());
        }
    }
}