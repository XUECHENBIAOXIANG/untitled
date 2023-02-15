import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CS203_8_1 {

    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int N = in.nextInt();
        int M = in.nextInt();
        int K = in.nextInt();
        int[] A = new int[N];
        int[] B = new int[M];
        for (int i = 0; i < N; i++) {
            A[i] = in.nextInt();
        }
        for (int i = 0; i < M; i++) {
            B[i] = in.nextInt();
        }
        Arrays.sort(A);
        heap heap =new heap(2*M);
        for (int i=0;i<M;i++){
            heap.insert(((long) A[0])*B[i],0,i);
        }
        for (int i=0;i<K;i++){
            int ai=heap.A[1];
            int bi=heap.B[1];
            long min=heap.delect();

            out.print(min);
            out.print(" ");
            if (ai+1<N){
            heap.insert(((long)A[ai+1])*B[bi],ai+1,bi);}
        }
        out.close();
    }

    private static class heap {
        long[] heap;
        int size = 0;
        int[]A ;
        int[]B ;

        public heap(int n) {
            heap = new long[n + 1];
            A=new int[n];
            B=new int[n];
        }

        public void insert(long x,int ai ,int bi) {//大
            size++;
            heap[size] = x;
            A[size]=ai;
            B[size]=bi;
            int index = size;
            while (index > 1) {
                if (heap[index] < heap[index / 2]) {
                    long temp = heap[index];
                    heap[index] = heap[index / 2];
                    heap[index / 2] = temp;
                    int tt=A[index];
                    A[index]=A[index/2];
                    A[index/2]=tt;
                    int bb=B[index];
                    B[index]= B[index/2];
                    B[index/2]=bb;
                    index = index / 2;
                } else break;
            }
        }

        public long delect() {
            long temp = heap[size];
            heap[size] = heap[1];
            long num = heap[1];
            heap[1] = temp;
            int t=A[size];
            A[size]=A[1];
            A[1]=t;
            int b=B[size];
            B[size]=B[1];
            B[1]=b;
            size--;
            int index = 1;
            while (index * 2 <= size) {
                if (index * 2 + 1 <= size) {
                    if (heap[index * 2] > heap[index * 2 + 1]) {
                        if (heap[index] > heap[index * 2 + 1]) {
                            long temp1 = heap[index];
                            heap[index] = heap[index * 2 + 1];
                            heap[index * 2 + 1] = temp1;
                            int tt=A[index];
                            A[index]=A[index*2+1];
                            A[index*2+1]=tt;
                            int bb= B[index];
                            B[index]=B[index*2+1];
                            B[index*2+1]=bb;
                            index = 2 * index + 1;
                        } else {
                            break;
                        }
                    } else {
                        if (heap[index] > heap[index * 2]) {
                            long temp1 = heap[index];
                            heap[index] = heap[index * 2];
                            heap[index * 2] = temp1;
                            int tt=A[index];
                            A[index]=A[index*2];
                            A[index*2]=tt;
                            int bb=B[index];
                            B[index]=B[index*2];
                            B[index*2]=bb;
                            index = 2 * index;
                        } else {
                            break;
                        }
                    }
                } else {
                    if (heap[index] > heap[index * 2]) {
                        long temp1 = heap[index];
                        heap[index] = heap[index * 2];
                        heap[index * 2] = temp1;
                        int tt=A[index];
                        A[index]=A[index*2];
                        A[index*2]=tt;
                        int bb=B[index];
                        B[index]=B[index*2];
                        B[index*2]=bb;
                        index = 2 * index;
                    } else {
                        break;
                    }
                }

            }
            return num;

        }


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

