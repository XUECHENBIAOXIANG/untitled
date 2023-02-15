import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CS203_10_4 {
    static int[] xv;
    static int shu=0;
    static int s=0;
    static boolean [] ru;
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int n=in.nextInt();
        int m=in.nextInt();
        int ss=in.nextInt()-1;
        node[] graph=new node[n];
        node[] res=new node[n];
        xv=new int[n];//出栈序列
        for (int i=0;i<n;i++){
            graph[i]=new node();//正序
            res[i]=new node();//图逆序
            res[i].x=i;
        }

        for (int i=0;i<m;i++){
            int u=in.nextInt()-1;
            int v=in.nextInt()-1;
            graph[u].child.add(graph[v]);
            res[v].child.add(res[u]);
        }
        for (int i=0;i<n;i++){//保证每个都出栈
            if (!res[i].isvisit){
            dfs(res[i]);}//获得出栈
        }

        for (int i=n-1;i>=0;i--){//对于每个强连通分量标记
            if (!graph[xv[i]].isvisit){
                dfs_t(graph[xv[i]]);
                s++;
            }
        }
        ru=new boolean[s];//记录入度是否为零
        for (int i=0;i<n;i++){
            for (int j=0;j<graph[i].child.size();j++){
                if (graph[i].x==graph[i].child.get(j).x){

                }else {
                    ru[graph[i].child.get(j).x]=true;//入度更新
                }
            }

        }
        int total=0;
        for (int i=0;i<ru.length;i++){
            if (!ru[i]){
                total++;//算入度为零数量
            }
        }
        if (ru[graph[ss].x]){
            out.print(total);
        }else {
            out.print(total-1);
        }
        out.close();

    }

    public static void dfs_t(node node){
        node.isvisit=true;
        node.x=s;
        for (int i=0;i<node.child.size();i++){
            if (!node.child.get(i).isvisit){
                dfs_t(node.child.get(i));
            }
        }
    }
    public static void dfs(node temp){
        temp.isvisit=true;
        for (int i=0;i<temp.child.size();i++){
            if (!temp.child.get(i).isvisit){
                dfs(temp.child.get(i));
            }
        }
        xv[shu]=temp.x;
        shu++;
    }
    private static class node{
        boolean isvisit;
        int x;
        ArrayList<node> child =new ArrayList<>();
        ArrayList<Integer> weight=new ArrayList<>();
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
