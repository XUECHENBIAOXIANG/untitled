import java.io.*;
import java.util.StringTokenizer;

public class CS203_11_1 {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int T= in.nextInt();
        for (int i=0;i<T;i++){
            int n= in.nextInt();
            int[] shu=new int[n];
            for (int j=0;j<n;j++){
                shu[j]=in.nextInt();
            }
            int k=shu[0];
            int cha=shu[0]-shu[1];
            for (int j=1;j<n;j++){
                 if (k-shu[j]>cha){
                     cha=k-shu[j];//更新最大差值
                 }
                 k=Math.max(k,shu[j]);//更新最大值
            }
            out.print(cha);
            out.print(" ");

        }
        out.close();

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
