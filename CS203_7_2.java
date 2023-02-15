import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CS203_7_2 {
    public static void main(String[] args) {
        QReader72 in=new QReader72();
        QWriter72 out=new QWriter72();
        int n =in.nextInt();
        node72[] tree=new node72[n];
        for (int a=0;a<n;a++){
            tree[a]=new node72();
        }
        for (int i=0;i<n-1;i++){
            int a= in.nextInt()-1;
            int b=in.nextInt()-1;
            tree[a].child.add(tree[b]);
            tree[b].child.add(tree[a]);
        }
        int m=in.nextInt();
        for (int i=0;i<m;i++){
            int zai=in.nextInt()-1;
            tree[zai].y=1;
        }
        int max=0;
        tree[0].isvisit=true;
        for (int d=0;d<tree[0].child.size();d++){
            node72 temp= tree[0].child.get(d);
            node72[] q =new node72[n];
            int front=0; int rear=0;
            q[rear++]=temp;
            int louceng=1;
            int key=1;
            int dong=0;
            int duoshaoge=0;
            ArrayList<Integer> shu=new ArrayList<>();
            while (rear!=front){
                node72 temp2=q[front++];
                temp2.isvisit=true;
                if (dong!=key&&rear!=1){
                    duoshaoge+=temp2.child.size()-1;
                }
                if (dong!=key&&rear==1){
                    duoshaoge+=temp2.child.size();
                }
                if (dong==key){
                    louceng++;
                    key=duoshaoge;
                    duoshaoge=temp2.child.size()-1;
                }
                if (temp2.y==1){
                    shu.add(louceng);
                }
                for (int i=0;i<temp2.child.size();i++){
                    if (!temp2.child.get(i).isvisit){
                        q[rear++]=temp2.child.get(i);
                    }
                }
                dong++;
            }
            int max1=0;
            for (int i=0;i<shu.size();i++){
                if (shu.get(i)<=max1){
                    max1++;
                }else {
                    max1=shu.get(i);
                }
            }
            if (max1>max){
                max=max1;
            }

        }
        out.print(max);


        out.close();
    }
}
class QReader72 {
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

class QWriter72 implements Closeable {
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

class node72{
    int y;
    int x;//楼层
    boolean isvisit;
    ArrayList<node72> child= new ArrayList<>();
}