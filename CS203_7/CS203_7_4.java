package CS203_7;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CS203_7_4 {
    private static long sum = 0L;
    private static int sheqida = 0;

    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        node[] tree = new node[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new node();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            tree[a].false_child.add(tree[b]);
            tree[b].false_child.add(tree[a]);
        }
        node maxx = tree[0];
        for (int i = 0; i < n; i++) {
            tree[i].p = in.nextInt();
            if (tree[i].p > maxx.p) {
                maxx = tree[i];
            }
        }
        findson(maxx);
        if (maxx.child.size() == 1) {
            int x = dfs(maxx);
            sum += 2L * x;
        } else {
            int x = dfs(maxx);
            sum += 2L * x;
            sum -= sheqida;
        }
        out.print(sum);
        out.close();
    }

    static void findson(node temp) {
        temp.isvisit = true;
        for (int i = 0; i < temp.false_child.size(); i++) {
            if (!temp.false_child.get(i).isvisit) {
                temp.child.add(temp.false_child.get(i));
                findson(temp.false_child.get(i));
            }
        }
    }

    static int dfs(node temp) {
        if (temp.child.size() == 0) {
            return temp.p;
        } else if (temp.child.size() == 1) {
            int x = dfs(temp.child.get(0));
            return Math.max(x, temp.p);
        } else {
            int da = dfs(temp.child.get(0));

            sum += da;
            for (int i = 1; i < temp.child.size(); i++) {
                int x = dfs(temp.child.get(i));
                sum += x;
                if (x > da) {
                    da = x;
                    if (da > sheqida) {
                        sheqida = da;
                    }
                } else {
                    if (x > sheqida) {
                        sheqida = x;
                    }
                }

            }
            sum -= da;
            return Math.max(da, temp.p);
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

    private static class node {
        int p;
        boolean isvisit;
        ArrayList<node> child = new ArrayList<>();
        ArrayList<node> false_child = new ArrayList<>();
    }
}
