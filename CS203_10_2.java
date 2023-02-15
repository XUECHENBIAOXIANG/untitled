import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class CS203_10_2 {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int n=in.nextInt();
        int m=in.nextInt();
        int k=in.nextInt();
        int c=in.nextInt();
        node[] graph=new node[n];
        for (int i=0;i<n;i++){
            graph[i]=new node();
            graph[i].se=in.nextInt();
            graph[i].shu=new int[k];
        }
        for (int i=0;i<m;i++){
            int u= in.nextInt()-1;
            int v=in.nextInt()-1;
            graph[u].child.add(graph[v]);
            graph[v].child.add(graph[u]);
        }
        for (int i=0;i<k;i++){//对于每种颜色
            node[] q=new node[n];
            int front=0;
            int rear=0;
            for (int j=0;j<n;j++){//初始化栈
                graph[j].isvisit=false;
                if (graph[j].se==i+1){
                    q[rear++]=graph[j];
                    graph[j].isvisit=true;
                }
            }

            while (rear!=front){
                node temp=q[front++];
                for (int l=0;l<temp.child.size();l++){
                    if (!temp.child.get(l).isvisit){
                        temp.child.get(l).isvisit=true;
                        q[rear++]=temp.child.get(l);
                        temp.child.get(l).shu[i]=temp.shu[i]+1;
                    }
                }
            }

        }
        for (int i=0;i<n;i++){
            Arrays.sort(graph[i].shu);
            int total=0;
            for (int j=0;j<c;j++){//计算结果
                total+=graph[i].shu[j];
            }
            out.print(total);
            out.print(" ");
        }
        out.close();






    }
    private static class node{
        int se;
        boolean isvisit;
        ArrayList<node> child =new ArrayList<>();
        int[] shu;
    }
    private static class QReader {
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
    private static class QWriter implements Closeable {
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
}
