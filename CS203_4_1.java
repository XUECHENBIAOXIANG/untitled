
import java.io.*;
import java.util.StringTokenizer;

public class CS203_4_1 {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int n=in.nextInt();
        int m=in.nextInt();
        node head=new node(-1000000001,-1000000001);
        node cur=head;
        node tail=new node(1000000001,1000000001);
        for (int a=0;a<n;a++){
            node temp=new node(in.nextInt(),in.nextInt());
            cur.next=temp;
            cur=cur.next;
        }
        cur.next=tail;
        node cur2=head;
        for (int a=0;a<m;a++){
            int b=in.nextInt();
            int c= in.nextInt();
            while (cur2!=tail){
                if (c<=cur2.next.exp) break;
                cur2=cur2.next;
        }
            if (c==cur2.next.exp){
                cur2.next.coe+=b;
            }else {
                node bu=new node(b,c);
                bu.next=cur2.next;
                cur2.next=bu;
            }
        }
        node cur3=head.next;
        int count=0;
        while (cur3!=tail){
            if (cur3.coe!=0){
                count++;
            }
            cur3=cur3.next;
        }

        out.println(count);
        node cur4=head.next;
        while (cur4!=tail){
            if (cur4.coe!=0){
                out.print(cur4.coe);
                out.print(" ");
                out.println(cur4.exp);
            }
            cur4=cur4.next;
        }





        out.close();
    }
}
class node {
    int coe;
    int exp;
    node next;

    node(int a, int b) {
        coe = a;
        exp = b;
    }
}
    class QReader {
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

    class QWriter implements Closeable {
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

