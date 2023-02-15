import java.io.*;
import java.util.StringTokenizer;

public class CS203_5_3 {
    public static void main(String[] args) {
        int x=1000;
        QReader53 in=new QReader53();
        QWriter53 out=new QWriter53();

        int n= in.nextInt();
        int[] chun=new int[n];
        int length=in.nextInt();
        int q=in.nextInt();
        int [] c=new int[100000];
        int [] zuida=new int[100000];
        int wei=0;
        int tou=0;

        for (int d=0;d<n;d++){
            chun[d]=in.nextInt();
        }
        for (int d=0;d<length;d++){
            if (d==0){
                c[d]=0;tou++;
            }else {
                if (chun[c[tou - 1]] >= chun[d]) {
                    c[tou] = d;
                    tou++;
                } else{
                    while (chun[d]>chun[c[tou-1]]){
                        tou--;
                        if (tou==wei){
                            break;
                        }
                    }
                    c[tou] = d;
                    tou++;
                }
            }
        }
        for (int d=0;d<n-length;d++){
            zuida[d]=chun[c[wei]];
            if (c[wei]==d){
                wei++;
            }
                if (chun[c[tou-1]]>=chun[d+length]){
                    c[tou]=d+length;
                    tou++;
                }else {
                    while (chun[d+length]>chun[c[tou-1]]){
                        tou--;
                        if (tou==wei){
                            break;
                        }
                    }
                    c[tou]=d+length;
                    tou++;
                }
            }
        zuida[n-length]=chun[c[wei]];

        for (int d=0;d<q;d++){
            int e=in.nextInt();
            out.print(zuida[e-1]+" ");
        }

out.close();
    }
}


class QReader53 {
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

class QWriter53 implements Closeable {
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