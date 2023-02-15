import java.io.*;
import java.util.StringTokenizer;

public class CS203_8_2 {
    public static void main(String[] args) {
        QReader82 in=new QReader82();
        QWriter82 out=new QWriter82();
        int n=in.nextInt();
        for (int i=0;i<n;i++){
            int m=in.nextInt();
            heap1 shu=new heap1(m);
            int sum=0;
            for (int a=0;a<m;a++){
                shu.insert(in.nextInt());
            }

            while (shu.size!=1){
                int cha=shu.delect()+shu.delect();
                sum+=cha;
                shu.insert(cha);
            }
            out.println(sum);
        }
        out.close();
    }

}
class heap1{
    int[]heap1;
    int size=0;
    public  heap1(int n){
        heap1=new int[n+1];
    }
    public void insert(int x){//大
        size++;
        heap1[size]=x;
        int index=size;
        while (index>1){
            if (heap1[index]<heap1[index/2]){
                int temp= heap1[index];
                heap1[index]=heap1[index/2];
                heap1[index/2]=temp;
                index=index/2;
            }else break;
        }
    }
    public int delect(){
        int temp=heap1[size];
        heap1[size]=heap1[1];
        int num=heap1[1];
        heap1[1]=temp;
        size--;
        int index=1;
        while (index*2<=size){
            if (index*2+1<=size){
                if (heap1[index*2]>heap1[index*2+1]){
                    if (heap1[index]>heap1[index*2+1]){
                        int temp1=heap1[index];
                        heap1[index]=heap1[index*2+1];
                        heap1[index*2+1]=temp1;
                        index=2*index+1;
                    }else {break;}
                }
                else {
                    if (heap1[index]>heap1[index*2]){
                        int temp1=heap1[index];
                        heap1[index]=heap1[index*2];
                        heap1[index*2]=temp1;
                        index=2*index;
                    }else {break;}
                }
            }else {
                if (heap1[index]>heap1[index*2]){
                    int temp1=heap1[index];
                    heap1[index]=heap1[index*2];
                    heap1[index*2]=temp1;
                    index=2*index;
                }else {break;}
            }

        }
        return num;

    }


}
class QReader82 {
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
class QWriter82 implements Closeable {
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