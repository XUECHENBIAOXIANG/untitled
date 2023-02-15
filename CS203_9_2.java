import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CS203_9_2 {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int n= in.nextInt();
        int m=in.nextInt();
        node[] graph =new node[n];
        for (int i=0;i<n;i++){
            graph[i]=new node();
        }
        for (int i=0;i<m;i++){
            int u= in.nextInt()-1;
            int v=in.nextInt()-1;
            graph[v].child.add(graph[u]);
        }
        for (int i=0;i<n;i++){
            dfs(graph[n-1-i],n-i);
        }
        for (int i=0;i<n;i++){
            out.print(graph[i].x);
            out.print(" ");
        }



        out.close();
    }
    public static void dfs(node temp,int x){
        if (temp.isvisit){
        }else {
            temp.x=x;
            temp.isvisit=true;
            for (int i=0;i<temp.child.size();i++){
                if (!temp.child.get(i).isvisit){
                    temp.child.get(i).x=x;
                    dfs(temp.child.get(i),x);
                }
            }
        }
    }
    private static class node{
        int x;
        boolean isvisit;
        ArrayList<node> child=new ArrayList<>();
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
