import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CS203_7_3 {
    private static boolean keyi=true;
    public static void main(String[] args) {
        QReader73 in=new QReader73();
        QWriter73 out =new QWriter73();
        int n=in.nextInt();
        node73[] tree=new node73[n];
        for (int i=0;i<n;i++){
            tree[i]=new node73();
        }
        for (int i=0;i<n-1;i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            tree[a].false_child.add(tree[b]);
            tree[b].false_child.add(tree[a]);
        }

        int m=in.nextInt();
        int[] dd=new int[3*m];
        for (int i=0;i<dd.length;i++){
            dd[i]=in.nextInt();
        }
        findson(tree[0]);
        int left=0;
        int right=n+1;
        while (left+1!=right){
            int middle=(left+right)/2;
            if(check(middle,dd,tree)){
                right=middle;}
            else {
                left=middle;
            }
        }
        if (right==n+1){
            out.print("-1");
        }else {
        out.print(right);}
        out.close();
    }
    public static boolean check(int k, int[]dd,node73[] tree){
        fuyuan(tree[0]);
        for (int i=0;i<dd.length;i++){
            int a=dd[i++]-1;
            int b=dd[i++]-1;
            int t=dd[i];
            if (tree[a].fu==tree[b]){
             if (tree[a].zuo<t){
                 tree[a].zuo=t;
             }
            }else {
                int m=k-t;
                if (tree[b].you>m){
                    tree[b].you=m;
                }
            }
        }
         keyi=true;
        guibing(tree[0]);
        if (!(tree[0].zuo<=k&&tree[0].you>=k)){
            keyi=false;
        }

        return keyi;
    }
    static void  guibing(node73 temp){

        for (int i=0;i<temp.child.size();i++){
            guibing(temp.child.get(i));
        }

        if (temp.guizuo> temp.zuo){
            temp.zuo=temp.guizuo;
        }
        if (temp.guiyou+1< temp.you){
            temp.you= temp.guiyou+1;
        }
        if (temp.you< temp.zuo){
            keyi=false;
        }
        if (temp.fu!=null){
            temp.fu.guizuo+= temp.zuo;
            temp.fu.guiyou+=temp.you;
        }
    }
    static void fuyuan(node73 temp){
        temp.zuo=0;
        temp.you=1;
        temp.guizuo=0;
        temp.guiyou=0;
        for (int i=0;i<temp.child.size();i++){
            fuyuan(temp.child.get(i));
            temp.you+=temp.child.get(i).you;
        }


    }


    static void findson(node73 temp){
        temp.isvisit=true;

        for (int i=0;i<temp.false_child.size();i++){
            if (!temp.false_child.get(i).isvisit){
                temp.child.add(temp.false_child.get(i));
                temp.false_child.get(i).fu=temp;
                findson(temp.false_child.get(i));
                temp.you+=temp.false_child.get(i).you;
            }
        }
      temp.you++;
    }
}
class node73{
    int zuo;
    int you;
    int guizuo;
    int guiyou;
    node73 fu;
    boolean isvisit;
    ArrayList<node73> child= new ArrayList<>();
    ArrayList<node73> false_child=new ArrayList<>();
}
class QReader73 {
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

class QWriter73 implements Closeable {
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