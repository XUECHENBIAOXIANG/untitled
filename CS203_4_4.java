import java.io.*;
import java.util.StringTokenizer;

public class CS203_4_4 {
    public static void main(String[] args) {
        QReader4 in=new QReader4();
        QWriter4 out=new QWriter4();
        int time=in.nextInt();
        nodeee[] a=new nodeee[time];
        nodeee[] b= new  nodeee[time];
        nodeee[] d= new  nodeee[time];
        for (int c=0;c<time;c++){
            a[c]=new nodeee(in.nextInt());
            b[c]=a[c];
        }
        fen(b,0,time-1,d);
        for (int c=0;c<time-1;c++){
            b[c].next=b[c+1];
            b[c+1].pre=b[c];
        }
        for(int c=0;c<time-1;c++){
            if (a[c].next!=null&&a[c].pre!=null){
                out.print(Math.min(Math.abs(a[c].next.a-a[c].a),Math.abs(a[c].pre.a-a[c].a)));
                out.print(" ");
                a[c].pre.next=a[c].next;
                a[c].next.pre=a[c].pre;
            }else if (a[c].next!=null){
                out.print(Math.abs(a[c].next.a-a[c].a));
                out.print(" ");
                a[c].next.pre=null;
            }else {
                out.print(Math.abs(a[c].pre.a-a[c].a));
                out.print(" ");
                a[c].pre.next=null;
            }
        }





        out.close();

            }









    public static void fen(nodeee[]a,int low,int high,nodeee[]guo){
        if (low<high){
            int middle=low+(high-low)/2;
            fen(a,low,middle,guo);
            fen(a,middle+1,high,guo);
            he(a,low,middle,high,guo);
        }

    }
    public static void he(nodeee[]a,int low, int middle ,int high,nodeee[]guo){
        int mu=low;
        int hua1=low;
        int hua2=middle+1;
        while (hua1<=middle&&hua2<=high){
            if (a[hua1].a<=a[hua2].a){
                guo[mu]=a[hua1];
                mu++;
                hua1++;
            }else {
                guo[mu]=a[hua2];
                mu++;
                hua2++;
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

class nodeee{
    int a;
    nodeee pre;
    nodeee next;
    nodeee(int b){
        a=b;
    }
}




class QReader4 {
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

class QWriter4 implements Closeable {
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