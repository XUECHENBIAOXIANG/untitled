import java.io.*;
import java.util.StringTokenizer;

public class CS203_11_2 {
    private static class QReader {
        public static void main(String[] args) {
            QReader in=new QReader();
            QWriter out=new QWriter();
            int T= in.nextInt();
            for (int i=0;i<T;i++){
                int x=in.nextInt();
                String SS=in.next();
                char[] y=new char[x];
                int z=0;
                boolean flag=true;
                for (int j=0;j<x;j++){
                    if (SS.charAt(j)=='{'){
                        y[z++]='}';
                    }else if (SS.charAt(j)=='('){
                        y[z++]=')';
                    }else if (SS.charAt(j)=='['){
                        y[z++]=']';
                    }else {
                        if (z==0||y[--z]!=SS.charAt(j)){
                            flag=false;
                        }
                    }
                }
                if (z!=0){
                    flag=false;
                }
                if (flag){
                    out.println("YES");
                }else {
                    out.println("NO");
                }
            }
            out.close();
        }
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
