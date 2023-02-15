import java.io.*;
import java.util.StringTokenizer;

public class CS203_4_2 {
    public static void main(String[] args) {
        QReader1 in=new QReader1();
        QWriter1 out=new QWriter1();

        int n= in.nextInt();
        long m= in.nextLong();
        long yiquan=0l;
        node1 head=new node1(in.nextInt());
        yiquan+= head.qian;
        node1 cur=head;
        for (int a=1;a<n;a++){
              node1 temp=new node1(in.nextInt());
              yiquan+= temp.qian;
              cur.next=temp;
              cur=cur.next;
        }
        cur.next=head;
        cur=cur.next;
        long quanshu=m/yiquan;
        long yushu=m%yiquan;
        long zongshu=quanshu*n;
        for(int b=0;b<1000000000;b++){
            int c=0;
        for (int a=0;a<n;a++){
            if (cur.qian<=yushu){
                yushu-= cur.qian;
                zongshu++;
                c=1;
            }
            cur=cur.next;
        }
        if (c==0){break;}
        }

        out.print(zongshu);





        out.close();
    }
}


class node1{
    int qian;
    node1 next;
    node1(int a){
        qian=a;
    }
}

class QReader1 {
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

class QWriter1 implements Closeable {
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