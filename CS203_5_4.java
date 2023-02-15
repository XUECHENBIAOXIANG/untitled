import java.io.*;
import java.util.StringTokenizer;

public class CS203_5_4 {
    public static void main(String[] args) {
        QReader54 in=new QReader54();
        QWriter54 out=new QWriter54();
        int total=in.nextInt();
        total=total+1;
        int[]he=new int[total];
        he[0]=0;
        int he1=0;
        for (int a=1;a<total;a++){
            he1+=in.nextInt();
            he[a]=he1;
        }
        int[]a=new int[total];
        int tou=1;
        int wei=0;
        a[0]=0;
        for (int b=1;b<total;b++){
            if (he[b]<=he[a[tou-1]]){
                a[tou]=b;
                tou++;
            }else {
                while (he[b]>he[a[tou-1]]){
                    tou--;
                    if (tou==wei){
                        break;
                    }
                }
                a[tou]=b;
                tou++;
            }
        }
        int changdu=0;
        for (int b=1;b<total;b++){
            int right=tou;
            int left=wei-1;
            int you=0;
            while (left+1!=right){
                int middle=(left+right)/2;
                if (a[middle]<b){
                    left=middle;
                }else {
                    right=middle;
                }
            }

            if (right!=tou){
            int left1=right-1;
            int right1=tou;
            while (left1+1!=right1){
                int middle1=(left1+right1)/2;
                if (he[a[middle1]]>he[b-1]){
                    left1=middle1;
                }else {
                    right1=middle1;
                }
            }
            if (left1!=right-1){
                int cha=a[left1]-b+1;
                if (changdu<cha){
                    changdu=cha;
                }
            }


            }

        }
        System.out.print(changdu);
    }
}

class QReader54 {
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

class QWriter54 implements Closeable {
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
