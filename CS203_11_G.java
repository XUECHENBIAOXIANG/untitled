import java.io.*;
import java.util.StringTokenizer;

public class CS203_11_G {
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int T= in.nextInt();
        for (int k=0;k<T;k++){
            int n= in.nextInt();
            node[] s=new node[n];
            for (int i=0;i<n;i++){
                s[i]=new node();
            }
            for (int i=0;i<n;i++){
                int z= in.nextInt()-1;
                int y= in.nextInt()-1;
                if (z==-1){
                    s[i].left=null;
                }else {
                    s[i].left=s[z];
                    s[z].father=s[i];

                }
                if (y==-1){
                    s[i].right=null;
                }else {
                    s[i].right=s[y];
                    s[y].father=s[i];
                }
            }
            node temp=null;
            for (int i=0;i<n;i++){
                if (s[i].father==null){
                    temp=s[i];
                }
            }
            node[] d=new node[n];
            int rear=0;
            int tou=0;
            boolean ye=false;
            boolean feiwan=false;
            d[tou++]=temp;
            while (rear!=tou){
                node tt=d[rear++];
                if (tt.left!=null&tt.right!=null){
                    d[tou++]=tt.left;
                    d[tou++]=tt.right;
                    if (ye){
                        feiwan=true;
                    }else {

                    }
                }else if (tt.left!=null&tt.right==null){
                    d[tou++]=tt.left;
                    if (ye){
                        feiwan=true;
                    }else {
                        ye=true;
                    }
                }else if (tt.left==null&tt.right!=null){
                    d[tou++]=tt.right;
                    feiwan=true;
                }else {
                    ye=true;

                }
            }
            if (feiwan){
                out.println("No ");
            }else {
                out.println("Yes ");
            }




        }
        out.close();
    }
    public static class node{
        node father;
        node left;
        node right;
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
