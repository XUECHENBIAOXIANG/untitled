import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CS203_6_3 {
    public static void main(String[] args) {
        QReader63 in=new QReader63();
        String give=in.nextLine();
        QWriter63 out=new QWriter63();
        int[] gg=new int[give.length()];
        for (int a=0;a<give.length();a++){
            char b=give.charAt(a);
            int c=b-97;
            gg[a]=c;
        }//对于数组的转换结果，准备开始填补自动机
        int[][] ans=new int[give.length()][26];
        for (int a=0;a<give.length();a++){
            ans[a][gg[a]]=a+1;
        }
        int state=0;
        for (int a=1;a<give.length();a++){
            for (int b=0;b<26;b++){
                if (b!=gg[a]){
            ans[a][b]=ans[state][b];
                }
            }
            state=ans[state][gg[a]];
        }
        for (int a=0;a<give.length();a++){
            for (int b=0;b<26;b++){
                out.print(ans[a][b]+" ");
            }
            out.println("");
        }
        out.close();












    }
}
class QReader63 {
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

class QWriter63 implements Closeable {
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
