import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CS203_10_3 {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int n=in.nextInt();
        int m=in.nextInt();
        node1[] graph=new node1[n];
        for (int i=0;i<n;i++){
            graph[i]=new node1();
        }
        node1 temp=null;
        node1 temp2=null;
        int x=1000000000;
        long total=0;
        long cost=0;
        for (int i=0;i<m;i++){
            int u= in.nextInt()-1;
            int v=in.nextInt()-1;
            int w= in.nextInt();
            total+=w;
            graph[u].child.add(graph[v]);
            graph[v].child.add(graph[u]);
            graph[u].weight.add(w);
            graph[v].weight.add(w);
            if (w<0){
                cost+=w;
            }
            if (w<x){
                temp=graph[u];
                temp2=graph[v];
                x=w;
            }
        }
        if (x>0){
        cost+=x;}
        temp.isvisit=true;
        temp2.isvisit=true;
        heap a=new heap(m+1);
        for (int i=0;i< temp.child.size();i++){
            if (!temp.child.get(i).isvisit){
                node t=new node();
                t.gen=temp.child.get(i);
                t.x=temp.weight.get(i);
                a.insert(t);
            }
        }
        for (int i=0;i< temp2.child.size();i++){
            if (!temp2.child.get(i).isvisit){
                node t=new node();
                t.gen=temp2.child.get(i);
                t.x=temp2.weight.get(i);
                a.insert(t);
            }
        }
        while (a.size>0){
            node use=a.delect();
            if (!use.gen.isvisit){
                if(use.x>0){
                cost+=use.x;}
                use.gen.isvisit=true;
                for (int i=0;i<use.gen.child.size();i++){
                    if (!use.gen.child.get(i).isvisit){
                        node t=new node();
                        t.gen=use.gen.child.get(i);
                        t.x=use.gen.weight.get(i);
                        a.insert(t);
                    }
                }
            }
        }

        out.print(total-cost);
        out.close();

    }



    private static class node1{
        boolean isvisit;
        ArrayList<node1> child =new ArrayList<>();
        ArrayList<Integer> weight=new ArrayList<>();
    }

    private static class heap {
        node[] heap;
        int size = 0;

        public heap(int n) {
            heap = new node[n + 1];
        }

        public void insert(node x) {
            size++;
            heap[size] = x;
            int index = size;
            while (index > 1) {
                if (heap[index].x < heap[index / 2].x) {
                    node temp = heap[index];
                    heap[index] = heap[index / 2];
                    heap[index / 2] = temp;
                    index = index / 2;
                } else break;
            }
        }

        public node delect() {
            node temp = heap[size];
            heap[size] = heap[1];
            node num = heap[1];
            heap[1] = temp;
            size--;
            int index = 1;
            while (index * 2 <= size) {
                if (index * 2 + 1 <= size) {
                    if (heap[index * 2].x > heap[index * 2 + 1].x) {
                        if (heap[index].x >= heap[index * 2 + 1].x) {
                            node temp1 = heap[index];
                            heap[index] = heap[index * 2 + 1];
                            heap[index * 2 + 1] = temp1;
                            index = 2 * index + 1;
                        } else {
                            break;
                        }
                    } else {
                        if (heap[index].x >= heap[index * 2].x) {
                            node temp1 = heap[index];
                            heap[index] = heap[index * 2];
                            heap[index * 2] = temp1;
                            index = 2 * index;
                        } else {
                            break;
                        }
                    }
                } else {
                    if (heap[index].x >= heap[index * 2].x) {
                        node temp1 = heap[index];
                        heap[index] = heap[index * 2];
                        heap[index * 2] = temp1;
                        index = 2 * index;
                    } else {
                        break;
                    }
                }

            }
            return num;

        }


    }

    private static class node {
        long x;
        node1 gen;
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
