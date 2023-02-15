import java.io.*;
import java.util.StringTokenizer;

public class CS203_4_3 {
    public static void main(String[] args) {
        QReader2 in=new QReader2();
        QWriter2 out=new QWriter2();

        int row= in.nextInt();
        int column=in.nextInt();
        int time=in.nextInt();
        node2d[][]c=new node2d[row+2][column+2];
        for (int d=1;d<=row;d++){
            for (int e=1;e<=column;e++){
                c[d][e]=new node2d(d,e,in.nextInt());
            }
        }
        for (int d=0;d<row+2;d++){
            c[d][0]=new node2d(d,0,0);
            c[d][column+1]=new node2d(d,0,0);
        }
        for (int d=0;d<column+2;d++){
            c[0][d]=new node2d(0,d,0);
            c[row+1][d]=new node2d(0,d,0);
        }

        node2d zuoshang=new node2d(0,0, 0);
        node2d zhizhen=zuoshang;
        for (int d=0;d<=row;d++){
            node2d zhiyou=zhizhen;
            for (int e=0;e<=column;e++){
                zhiyou.right=c[d][e+1];
                zhiyou.down=c[d+1][e];
                zhiyou=zhiyou.right;
            }
            zhizhen=zhizhen.down;
        }




        for (int a=0;a<time;a++)
        {
            int x1=in.nextInt();
            int y1=in.nextInt();
            int x2=in.nextInt();
            int y2=in.nextInt();
            int l1=in.nextInt();
            int l2=in.nextInt();
            zhizhen=zuoshang;
            node2d zhizhen2=zuoshang;
            for (int d=1;d<x1;d++){
                zhizhen=zhizhen.down;
            }
            for (int d=1;d<y1;d++){
                zhizhen=zhizhen.right;
            }
            for (int d=1;d<x2;d++){
                zhizhen2=zhizhen2.down;
            }
            for (int d=1;d<y2;d++){
                zhizhen2=zhizhen2.right;
            }
            node2d xiangxia=zhizhen;
            node2d xiangxia2=zhizhen2;
            node2d xiangyou=zhizhen;
            node2d xiangyou2=zhizhen2;
            node2d guai=zhizhen;
            node2d guai2=zhizhen2;
            xiangxia=xiangxia.down;
            xiangxia2=xiangxia2.down;
            node2d fuzhuxia;
            for (int e=0;e<l1;e++){
                fuzhuxia=xiangxia.right;
                xiangxia.right=xiangxia2.right;
                xiangxia2.right=fuzhuxia;
                xiangxia=xiangxia.down;
                xiangxia2=xiangxia2.down;
                xiangyou=xiangyou.down;
                xiangyou2 = xiangyou2.down;
            }
            xiangyou=xiangyou.right;
            xiangyou2 = xiangyou2.right;
            zhizhen=zhizhen.right;
            zhizhen2=zhizhen2.right;node2d fuzhu;
            for (int e=0;e<l2;e++){
                fuzhu=zhizhen.down;
                zhizhen.down=zhizhen2.down;
                zhizhen2.down=fuzhu;
                zhizhen=zhizhen.right;
                zhizhen2=zhizhen2.right;
                fuzhuxia=xiangyou.down;
                xiangyou.down=xiangyou2.down;
                xiangyou2.down=fuzhuxia;
                xiangyou=xiangyou.right;
                xiangyou2=xiangyou2.right;
                guai=guai.right;
                guai2=guai2.right;
            }
            guai=guai.down;
            guai2=guai2.down;
            for (int e=0;e<l1;e++){
                fuzhu=guai.right;
                guai.right=guai2.right;
                guai2.right=fuzhu;
                guai=guai.down;
                guai2=guai2.down;
            }



        }
        zhizhen=zuoshang.right.down;
        for (int rr=1;rr<=row;rr++){
            node2d zhiyou=zhizhen;
            for (int b=1;b<=column;b++){
                out.print(zhiyou.value);
                out.print(" ");
                zhiyou=zhiyou.right;
            }
            zhizhen=zhizhen.down;
            out.println("");
        }
        out.close();
    }
}

class node2d{
    int n;
    int m;
    int value;
    node2d right;
    node2d down;
    node2d(int a,int b, int c){
        n=a;
        m=b;
        value=c;
    }
}





class QReader2 {
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

class QWriter2 implements Closeable {
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