import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CS203_9_3 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int m = in.nextInt();
        node[] graph = new node[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new node();
        }
        for (int i=0;i<m;i++){
            int x=in.nextInt()-1;
            int y= in.nextInt()-1;
            graph[x].child.add(graph[y]);
            graph[y].child.add(graph[x]);
        }
        boolean huan = false;
        for (int i=0;i<n;i++){
            if (!graph[i].isvisit){
                node[] dui=new node[n];
                int front=0;
                int rear=0;
                int jiedian=0;
                int lu=0;
                dui[rear++]=graph[i];
                jiedian++;
                while (rear!=front){
                    node temp=dui[front++];
                    temp.isvisit=true;
                    lu+=temp.child.size();
                    for (int j=0;j<temp.child.size();j++){
                        if (!temp.child.get(j).isvisit){
                            dui[rear++]=temp.child.get(j);
                            temp.child.get(j).isvisit=true;
                            jiedian++;
                        }
                    }
                }
                lu/=2;
                if (jiedian<=lu){
                    huan=true;
                }
            }
        }
        if (huan){
            out.print("Bad");
        }else {
            out.print("Good");
        }



        out.close();
    }

    private static class node {
        int x;
        boolean isvisit;
        ArrayList<node> child = new ArrayList<>();
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
