import java.io.*;
import java.util.StringTokenizer;

public class CS203_6_1 {
    public static void main(String[] args) {
        QWriter61 out=new QWriter61();
        QReader61 in=new QReader61();
        int time=in.nextInt();
        for (int a=0;a<time;a++){
            String mu=in.nextLine();
            int ci=in.nextInt();
            String[] zi=new String[ci];
            for (int b=0;b<ci;b++){
                zi[b]= in.nextLine();
            }
            int[] zuiyuan=new int[mu.length()];
            int[] xuanyong=new int[mu.length()];
            for (int b=0;b<mu.length();b++){
                int i=-1;
                int yuandu=0;
                for (int c=0;c<ci;c++){
                    int count= zi[c].length();
                    int pidu=0;
                    if (count+b>mu.length()){
                        continue;
                    }
                    for (int e=0;e<zi[c].length();e++){
                        if (zi[c].charAt(e)==mu.charAt(b+e)){
                            pidu++;
                        }else {
                            break;
                        }
                    }
                    if (pidu==count){
                        if (pidu>yuandu){
                            yuandu=pidu;
                            i=c;
                        }
                    }
                }
                if (i==-1){zuiyuan[b]=i
                ;xuanyong[b]=i;}
                else{
                zuiyuan[b]=b+yuandu;
                xuanyong[b]=i+1;}
            }

            int[] ans=new int[100];
            ans[0]=0;
            int qujian=zuiyuan[0];
            int left=0;
            int t=1;
            if (qujian!=mu.length()){
                int ttt=1;
            while (qujian<mu.length()){
                int x=-1;
                int xuan=-1;
                int max=qujian;
               for (int bianli=left;bianli<=qujian;bianli++){
                   if (zuiyuan[bianli]>qujian&&zuiyuan[bianli]>max){
                       max=zuiyuan[bianli];
                       x=1;
                       xuan=bianli;
                   }
               }
               if (x==-1){
                   ttt=-1;
                   break;

               }else {
                qujian=max;
                ans[t]=xuan;
                left=xuan;
                t++;
               }
            }
            if (ttt==-1){
                out.println(ttt);
            }else {
                out.println(t);
                for (int cc = 0; cc < t; cc++) {
                    out.print(xuanyong[ans
                            [cc]] + " ");
                    out.print(ans[cc]+1);
                    out.println("");
                }
            }
            }else {
                out.println("1");
                out.print(xuanyong[0]);
                out.print(" 1");
                out.println("");
            }





        }




        out.close();
    }
}
class QReader61 {
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

class QWriter61 implements Closeable {
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