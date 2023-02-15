package CS203_7;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CS203_7_4_right {

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
        node head = new node();
        for (int i = 0; i < n; i++) {
            tree[i].p = in.nextInt();
            if (head.p < tree[i].p) {
                head = tree[i];
            }
        }
        findson(head);
        head.dfs();
        if (head.child.size() == 1) {
            node.sum += head.p;
            head.dfs_plus();
        }else {
            node max1=head.child.get(0);
            node max2=head.child.get(1);
            if (max1.p>max2.p){
                node temp=max2;
                max2=max1;
                max1=temp;
            }
            for (int i=2;i< head.child.size();i++){
                if (head.child.get(i).p>max2.p){
                    max1=max2;
                    max2=head.child.get(i);
                }else {
                    if (head.child.get(i).p> max1.p){
                        max1=head.child.get(i);
                    }
                }
            }
            max1.p= head.p;
            max2.p= head.p;
            for (int i=0;i<head.child.size();i++){
                head.child.get(i).dfs_plus();
            }
        }
        out.print(node.sum);
        out.close();
    }

    private static void findson(node temp) {
        temp.isvisit = true;
        for (int i = 0; i < temp.false_child.size(); i++) {
            if (!temp.false_child.get(i).isvisit) {
                temp.child.add(temp.false_child.get(i));
                findson(temp.false_child.get(i));
            }
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
        static long sum;
        boolean isvisit;
        ArrayList<node> false_child = new ArrayList<>();
        ArrayList<node> child = new ArrayList<>();


        private void dfs() {
            int max = 0;
            for (node n : this.child) {
                n.dfs();
                if (n.p > max) {
                    max = n.p;
                }
            }
            this.p = Math.max(this.p, max);
        }

        private void dfs_plus() {
            if (this.child.size() == 0) {
                sum += this.p;
            } else if (this.child.size() == 1) {
                this.child.get(0).p = this.p;
                this.child.get(0).dfs_plus();
            } else {
                node max = this.child.get(0);
                for (node value : this.child) {
                    if (max.p < value.p) {
                        max = value;
                    }
                }
                max.p = this.p;
                for (node node : this.child) {
                    node.dfs_plus();
                }
            }
        }
    }
}
