import java.io.*;
import java.util.StringTokenizer;

public class CS203_6_4 {
    public static void main(String[] args) {
        QReader64 in=new QReader64();
        QWriter64 out=new QWriter64();
        String meiyong=in.nextLine();
        String one=in.nextLine();
        String two=in.nextLine();
        char []zonghe=new char[one.length()+two.length()];
        for (int a=0;a<one.length();a++){
            switch (one.charAt(one.length()-a-1)){
                case 'S':
                    zonghe[a]='N';
                    break;
                case'N':
                    zonghe[a]='S';
                    break;
                case 'W':
                    zonghe[a]='E';
                    break;
                case 'E':
                    zonghe[a]='W';
                    break;
            }
        }
        for (int a=0;a<two.length();a++){
            zonghe[a+one.length()]=two.charAt(a);
        }
        int []next =new int[zonghe.length+1];
        int j=-1;
        int i=0;
        next[i]=j;
        while (i<next.length-1){
            if(j==-1||zonghe[i]==zonghe[j]){
                j++;
                i++;
                next[i]=j;
            }else {
                j=next[j];
            }
        }
        for (int a=0;a<next.length;a++){
            System.out.print(next[a]);
            System.out.print(" ");
        }


        if (next[zonghe.length]==0){
            out.print("YES");
        }else {
            out.print("NO");
        }






        out.close();
    }
}
class QReader64 {
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

class QWriter64 implements Closeable {
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