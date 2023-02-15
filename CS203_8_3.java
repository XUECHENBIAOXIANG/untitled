import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CS203_8_3 {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int N = in.nextInt();
        node[] a = new node[N];
        for (int i = 0; i < N; i++) {
            a[i] = new node();
            a[i].x = in.nextInt();
            a[i].index = i;
        }
        a[0].next=a[1];
        a[N-1].pre=a[N-2];
        for (int i = 1; i < N - 1; i++) {
            a[i].pre = a[i - 1];
            a[i].next = a[i + 1];
        }
        heap heap = new heap(N);
        for (int i = 0; i < N; i++) {
            heap.insert(a[i]);
        }
        while (heap.size > 1) {
            node temp= heap.delect();
            while (temp.isdelect){
                temp= heap.delect();
            }
            if (temp.pre!=null&&temp.next!=null){
                if ((temp.next.x^ temp.x)+1> (temp.x^temp.pre.x)+1){
                    temp.next.isdelect=true;
                    temp.x=(temp.next.x^ temp.x)+1;
                    temp.next=temp.next.next;
                    if (temp.next!=null){
                    temp.next.pre=temp;}
                    heap.insert(temp);
                }
                else {
                    temp.pre.isdelect=true;
                    temp.x=(temp.x^temp.pre.x)+1;
                    temp.pre=temp.pre.pre;
                    if (temp.pre!=null){
                    temp.pre.next=temp;}
                    heap.insert(temp);
                }
            }else if (temp.pre!=null){
                temp.pre.isdelect=true;
                temp.x=(temp.x^temp.pre.x)+1;
                temp.pre=temp.pre.pre;
                if (temp.pre!=null){
                temp.pre.next=temp;}
                heap.insert(temp);

            }else if (temp.next!=null){
                temp.next.isdelect=true;
                temp.x=(temp.next.x^ temp.x)+1;
                temp.next=temp.next.next;
                if (temp.next!=null){
                temp.next.pre=temp;}
                heap.insert(temp);
            }else {
                heap.insert(temp);
                break;
            }
        }
        int ans = heap.delect().x;
        out.print(ans);
        out.close();
    }

    private static class heap {
        node[] heap;
        int size = 0;

        public heap(int n) {
            heap = new node[n + 1];
        }

        public void insert(node x) {//大
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
        int x;
        node pre;
        node next;
        int index;
        boolean isdelect;
    }

    private static class QReader {
        private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer tokenizer = new StringTokenizer("");

        private String innerNextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                return null;//duibai
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
