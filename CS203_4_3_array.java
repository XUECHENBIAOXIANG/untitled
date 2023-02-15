import java.io.*;
import java.util.StringTokenizer;

public class CS203_4_3_array {
    public static void main(String[] args) {
        QReader3 in=new QReader3();
        QWriter3 out=new QWriter3();
        int n=in.nextInt();
        int m= in.nextInt();
        int q=in.nextInt();
        int[][]o=new int[n+1][m+1];
        for (int a=1;a<=n;a++){
            for (int b=1;b<=m;b++){
                o[a][b]= in.nextInt();
            }
        }
        for (int a=0;a<q;a++){
            int x1=in.nextInt();
            int y1=in.nextInt();
            int x2= in.nextInt();
            int y2=in.nextInt();
            int l1=in.nextInt();
            int l2=in.nextInt();
            for (int b=0;b<l1;b++){
                for (int c=0;c<l2;c++){
                    int temp=o[x1+b][y1+c];
                    o[x1+b][y1+c]=o[x2+b][y2+c];
                    o[x2+b][y2+c]=temp;
                }
            }
        }
        for (int a=1;a<=n;a++){
            for (int b=1;b<=m;b++){
                out.print(o[a][b]);
                out.print(" ");
            }
            out.println("");
        }



        out.close();
    }
}
class QReader3 {
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

class QWriter3 implements Closeable {
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