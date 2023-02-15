import java.io.*;
import java.util.StringTokenizer;

public class CS203_11_H {
    static int[][]se;
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out =new QWriter();
        int T= in.nextInt();
        for (int i=0;i<T;i++){
            int group=0;
            int n=in.nextInt();
            int m=in.nextInt();
            se=new int[n][m];
            int[][] yongguo=new int[n][m];
            for (int j=0;j<n;j++){
                for (int k=0;k<m;k++){
                    se[j][k]=in.nextInt();
                }
            }
            for (int j=0;j<n;j++){
                for (int k=0;k<m;k++){
                    if (yongguo[j][k]==0){
                        dfs(se[j][k],j,k,yongguo,n,m);
                        group++;
                    }
                }
            }
            out.println(group);



        }
        out.close();
    }
    public static void dfs(int dd,int j,int k,int[][]yongguo,int  n, int m){
        yongguo[j][k]=1;
        if (k==0&&yongguo[j][m-1]==0&&se[j][m-1]==dd){
            dfs(dd, j, m-1, yongguo, n, m);
        }//最左往左
        if (k==m-1&&yongguo[j][0]==0&&se[j][0]==dd){
            dfs(dd, j, 0, yongguo, n, m);
        }//最右往右
        if (k>0&&yongguo[j][k-1]==0&&se[j][k-1]==dd){
            dfs(dd, j, k-1, yongguo, n, m);
        }//正常往左
        if (k<m-1&&yongguo[j][k+1]==0&&se[j][k+1]==dd){
            dfs(dd, j, k+1, yongguo, n, m);
        }//正常往右
        if (j>0&&yongguo[j-1][k]==0&&se[j-1][k]==dd){
            dfs(dd, j-1, k, yongguo, n, m);
        }//正常往上
        if (j<n-1&&yongguo[j+1][k]==0&&se[j+1][k]==dd){
            dfs(dd, j+1, k, yongguo, n, m);
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
