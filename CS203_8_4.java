import java.io.*;
import java.util.StringTokenizer;

public class CS203_8_4 {

    private static boolean bianjie;
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int C = in.nextInt();
        int N = in.nextInt();
        node[] y = new node[N];
        for (int i = 0; i < N; i++) {
            y[i]=new node();
            y[i].y = in.nextInt();
        }
        node head =new node();
        build(y,head,0,N-1);
        findsize(head);
        findhigh(head);
        int M = in.nextInt();
        for (int i = 0; i < M; i++) {
            String opreation = in.next();
            if (opreation.equals("ask")) {
                int x0 = in.nextInt();
                bianjie=false;
                ans(C,head);
                if (bianjie){
                    ans_bianjie(C,head);
                    out.println(head.dd);
                }else {
                    if (x0>= head.left&&x0<= head.right){
                        out.println(x0+ head.op);
                    }else if (x0< head.left){
                        out.println(head.left+ head.op);
                    }else {
                        out.println(head.right+ head.op);
                    }
                }
            } else if (opreation.equals("rem")) {
                int rem = in.nextInt();
                node temp=head;
                while (true){
                    if (temp.zuo!=null&&temp.you!=null){
                        if (temp.zuo.size+1==rem){
                            break;
                        }else if(temp.zuo.size>=rem) {
                            temp=temp.zuo;
                        }else {
                            temp=temp.you;
                            rem-=(temp.zuo.size+1);
                        }
                    }else if (temp.zuo!=null){
                        if (rem==temp.size){
                            break;
                        }else {
                            temp=temp.zuo;
                        }
                    }else if (temp.you!=null){
                        if (rem==1){
                            break;
                        }else {
                            rem--;
                            temp=temp.you;
                        }
                    }else {
                        if (temp.size==rem){
                            break;
                        }
                    }
                }
                int state=0;
                if (temp.zuo==null&&temp.you==null){

                    if (temp.fu.zuo==temp){
                        temp.fu.zuo=null;
                        state=1;
                        temp=temp.fu;
                    }else {
                        temp.fu.you=null;
                        state=2;
                        temp=temp.fu;
                    }
                }else if (temp.you!=null&&temp.zuo==null){
                    if (temp.fu.zuo==temp){
                        state=1;
                        temp.fu.zuo=temp.you;
                        temp.you.fu=temp.fu;
                        temp=temp.fu;
                    }else {
                        state=2;
                        temp.fu.you=temp.you;
                        temp.you.fu=temp.fu;
                        temp=temp.fu;
                    }
                }else if (temp.you==null&temp.zuo!=null){
                    if (temp.fu.zuo==temp){
                        temp.fu.zuo=temp.zuo;
                        temp.zuo.fu=temp.fu;
                        temp=temp.fu;
                        state=1;
                    }else {
                        state=2;
                        temp.fu.you=temp.zuo;
                        temp.zuo.fu=temp.fu;
                        temp=temp.fu;
                    }
                }else {
                    state=2;
                    node te=temp.zuo;
                    while (te.you!=null){
                        te=te.you;
                    }
                    temp.y= te.y;
                    te.fu.you=te.you;
                    te.you.fu=te.fu;
                    temp=temp.fu;
                }
                node dd=temp;
                if (state==1&&dd.zuo!=null){
                    dd.zuo.high--;
                }else if (dd.you!=null){
                    dd.you.high--;
                }
                boolean shi = false;
                while (dd.fu!=null){
                    if (dd.zuo!=null&&dd.you!=null){
                    if (dd.zuo.high>=dd.you.high+2){
                        shi=true;
                        break;
                    }else if (dd.you.high>=dd.zuo.high+2){
                        shi=true;
                        break;
                    }else {
                        dd.high=Math.max(dd.zuo.high,dd.you.high)+1;
                        dd=dd.fu;
                    }}else if(dd.zuo!=null){
                        if (dd.zuo.high>=2){
                            shi=true;break;
                        }else {
                            dd.high=dd.zuo.high+1;
                            dd=dd.fu;
                        }
                    }
                    else if (dd.you!=null){
                        if (dd.you.high>=2){
                            shi=true;break;
                        }else {
                            dd.high=dd.you.high+1;
                            dd=dd.fu;
                        }

                    }else  {
                        dd.high=1;
                        dd=dd.fu;
                    }
                }
                if (shi){
                    balance(dd);


                }else {
                }

            } else if (opreation.equals("ins")) {
                int rem = in.nextInt();
                int value = in.nextInt();
                node temp=head;
                while (true){
                    if (temp.zuo!=null&&temp.you!=null){
                        if (temp.zuo.size+1==rem){
                            break;
                        }else if(temp.zuo.size>=rem) {
                            temp=temp.zuo;
                        }else {
                            temp=temp.you;
                            rem-=(temp.zuo.size+1);
                        }
                    }else if (temp.zuo!=null){
                        if (rem==temp.size){
                            break;
                        }else {
                            temp=temp.zuo;
                        }
                    }else if (temp.you!=null){
                        if (rem==1){
                            break;
                        }else {
                            rem--;
                            temp=temp.you;
                        }
                    }else {
                        if (temp.size==rem){
                            break;
                        }
                    }
                }
                int x=temp.y;
                temp.y=value;
                if (temp.zuo==null&&temp.you==null){
                    temp.you=new node();
                    temp.you.y=x;
                    node cha=temp.you;
                    cha.fu=temp;
                }else if (temp.you!=null){
                    temp=temp.you;
                    while (temp.zuo!=null){
                        temp=temp.zuo;
                    }
                    temp.zuo=new node();
                    temp.zuo.y=x;
                    node cha=temp.zuo;
                    cha.fu=temp;
                }
                findhigh(head);



            }
        }


        out.close();
    }
    public static void ans(int C,node temp){
        if (temp.zuo==null&&temp.you==null){
            int move= temp.y;
            if (move>=C|move<=-C){
                bianjie=true;
            }else {
                if (move>=0){
                    temp.left=0;
                    temp.right=C-move;
                }else {
                    temp.right=C;
                    temp.left=-move;
                }
                temp.op=temp.y;
            }
        }else if (temp.you==null){
            ans(C,temp.zuo);
            if (!bianjie){
                if (temp.y>=C|temp.y<=-C){
                    bianjie=true;
                }else {
                    if (temp.y>=0){
                        if (temp.zuo.left+temp.zuo.op+ temp.y>=C){
                            bianjie=true;
                        }else {
                            if (temp.zuo.right+temp.zuo.op+temp.y>=C){
                                temp.left=temp.zuo.left;
                                temp.op=temp.zuo.op+ temp.y;
                                temp.right=C- temp.op;
                            }else {
                                temp.left=temp.zuo.left;
                                temp.right=temp.you.right;
                                temp.op=temp.zuo.op+ temp.y;
                            }
                        }
                    }else {
                        if (temp.zuo.right+ temp.zuo.op+temp.y<=0){
                            bianjie=true;
                        }else {
                            if (temp.zuo.left+temp.zuo.op+ temp.y<=0){
                                temp.right=temp.zuo.right;
                                temp.op= temp.zuo.op+ temp.y;
                                temp.left=-temp.op;
                            }else {
                                temp.left=temp.zuo.left;
                                temp.right=temp.you.right;
                                temp.op=temp.zuo.op+ temp.y;
                            }
                        }
                    }
                }
            }

            }else if (temp.zuo==null){
                ans(C,temp.you);
                if (!bianjie){
                    if (temp.y>=C||temp.y<=-C){
                        bianjie=true;
                    }else {
                        if (temp.y>=0){
                            int di=temp.you.left- temp.y;
                            int gao=temp.you.right- temp.y;
                            temp.left=Math.max(0,di);
                            temp.right=Math.min(C- temp.y,gao);
                            if (temp.left> temp.right){
                                bianjie=true;
                            }else {
                                temp.op=temp.you.op+temp.y;
                            }
                        }else {
                            int di=temp.you.left- temp.y;
                            int gao=temp.you.right- temp.y;
                            temp.right=Math.min(C,gao);
                            temp.left=Math.max(-temp.y,di);
                            if (temp.left>temp.right){
                                bianjie=true;
                            }else {
                                temp.op= temp.you.op+ temp.y;
                            }
                        }
                    }
                }
        }else {
            ans(C,temp.zuo);
            ans(C,temp.you);
            if (!bianjie){
                if (temp.y>=C|temp.y<=-C){
                    bianjie=true;
                }else {
                    if (temp.y>=0){
                        if (temp.zuo.left+temp.zuo.op+ temp.y>=C){
                            bianjie=true;
                        }else {
                            if (temp.zuo.right+temp.zuo.op+temp.y>=C){
                                temp.left=temp.zuo.left;
                                temp.op=temp.zuo.op+ temp.y;
                                temp.right=C- temp.op;
                                int di=temp.you.left- temp.op;
                                int gao=temp.you.right- temp.op;
                                temp.left=Math.max(temp.left,di);
                                temp.right=Math.min(temp.right,gao);
                                if (temp.left> temp.right){
                                    bianjie=true;
                                }else {
                                    temp.op=temp.op+ temp.you.op;
                                }
                            }else {
                                temp.left=temp.zuo.left;
                                temp.right=temp.you.right;
                                temp.op=temp.zuo.op+ temp.y;
                                int di=temp.you.left- temp.op;
                                int gao=temp.you.right- temp.op;
                                temp.left=Math.max(temp.left,di);
                                temp.right=Math.min(temp.right,gao);
                                if (temp.left> temp.right){
                                    bianjie=true;
                                }else {
                                    temp.op=temp.op+ temp.you.op;
                                }
                            }
                        }
                    }else {
                        if (temp.zuo.right+ temp.zuo.op+temp.y<=0){
                            bianjie=true;
                        }else {
                            if (temp.zuo.left+temp.zuo.op+ temp.y<=0){
                                temp.right=temp.zuo.right;
                                temp.op= temp.zuo.op+ temp.y;
                                temp.left=-temp.op;
                                int di=temp.you.left- temp.op;
                                int gao=temp.you.right- temp.op;
                                temp.left=Math.max(temp.left,di);
                                temp.right=Math.min(temp.right,gao);
                                if (temp.left> temp.right){
                                    bianjie=true;
                                }else {
                                    temp.op=temp.op+ temp.you.op;
                                }
                            }else {
                                temp.left=temp.zuo.left;
                                temp.right=temp.you.right;
                                temp.op=temp.zuo.op+ temp.y;
                                int di=temp.you.left- temp.op;
                                int gao=temp.you.right- temp.op;
                                temp.left=Math.max(temp.left,di);
                                temp.right=Math.min(temp.right,gao);
                                if (temp.left> temp.right){
                                    bianjie=true;
                                }else {
                                    temp.op=temp.op+ temp.you.op;
                                }
                            }
                        }
                    }
                }
            }
        }

    }
    public static void ans_bianjie(int C,node temp){
        if (temp.zuo==null&&temp.you==null){
            if (temp.y<=-C){
                temp.dd=0;
            }else if (temp.y>=C){
                temp.dd=C;
            }else {
                temp.dd=temp.y+ temp.dd;
                if (temp.dd>=C){
                    temp.dd=C;
                }else if (temp.dd<=0){
                    temp.dd=0;
                }else {
                }
            }
        }else if (temp.you==null){
            temp.zuo.dd=temp.dd;
            ans_bianjie(C,temp.zuo);
            if (temp.y<=-C){
                temp.dd=0;
            }else if (temp.y>=C){
                temp.dd=C;
            }else {
                int x=temp.zuo.dd+temp.y;
                if (x>=C){
                    temp.dd=C;
                }else if (x<=0){
                    temp.dd=0;
                }else {
                    temp.dd=x;
                }
            }
        }else if (temp.zuo==null){
            if (temp.y<=-C){
                temp.you.dd=0;
                ans_bianjie(C,temp.you);
                temp.dd=temp.you.dd;
            }else if (temp.y>=C){
                temp.you.dd=C;
                ans_bianjie(C,temp.you);
                temp.dd= temp.you.dd;
            }else {
                temp.you.dd=temp.dd+temp.y;
                if (temp.you.dd>=C){
                    temp.you.dd=C;
                }
                if (temp.you.dd<=0){
                    temp.you.dd=0;
                }
                ans_bianjie(C,temp.you);
                temp.dd= temp.you.dd;
            }
        }else {
            temp.zuo.dd=temp.dd;
            ans_bianjie(C,temp.zuo);
            if (temp.y<=-C){
                temp.dd=0;
            }else if (temp.y>=C){
                temp.dd=C;
            }else {
                int x=temp.zuo.dd+temp.y;
                if (x>=C){
                    temp.dd=C;
                    temp.you.dd=C;
                    ans_bianjie(C,temp.you);
                    temp.dd= temp.you.dd;
                }else if (x<=0){
                    temp.dd=0;
                    temp.you.dd=0;
                    ans_bianjie(C,temp.you);
                    temp.dd= temp.you.dd;
                }else {
                    temp.dd=x;
                    temp.you.dd=x;
                    ans_bianjie(C,temp.you);
                    temp.dd= temp.you.dd;
                }
            }
        }
    }

    public static void build(node[]y, node temp,int left, int right){
        if (left==right){
            temp.y=y[left].y;
        }else if (right-left==1){
            temp.y=y[right].y;
            temp.zuo=y[left];
            temp.zuo.fu=temp;
        }else if (right-left==2){
            temp.y=y[left+1].y;
            temp.zuo=y[left];
            temp.you=y[right];
            temp.zuo.fu=temp;
            temp.you.fu=temp;
        }else {
            int mid=left+(right-left)/2;
            temp.y=y[mid].y;
            temp.zuo=new node();
            temp.you=new node();
            temp.zuo.fu=temp;
            temp.you.fu=temp;
            build(y,temp.zuo,left,mid-1);
            build(y,temp.you,mid+1,right);
        }
    }
    public static void findsize(node temp){
        if (temp.zuo==null&&temp.you==null){
            temp.size=1;
        }else if (temp.zuo==null){
            findsize(temp.you);
            temp.size=temp.you.size+1;
        }else if (temp.you==null){
            findsize(temp.zuo);
            temp.size=temp.zuo.size+1;
        }else {
            findsize(temp.zuo);
            findsize (temp.you);
            temp.size=temp.zuo.size+temp.you.size+1;
        }
    }
    public static void findhigh(node temp){
        if (temp.zuo==null&temp.you==null){
            temp.high=1;
        }else if (temp.zuo==null&&temp.you!=null){
            findhigh(temp.you);
            temp.high= temp.you.high+1;
        }else if (temp.you==null&&temp.zuo!=null){
            findhigh(temp.zuo);

            temp.high=temp.zuo.high+1;
        }else {
            findhigh(temp.zuo);
            findhigh(temp.you);
            temp.high=Math.max(temp.you.high, temp.zuo.high)+1;
        }
    }
    public static void balance(node temp){
        if (temp.fu.zuo.high==temp.fu.you.high+2){
            if (temp.zuo.zuo.high== temp.zuo.you.high+1){
                node t3=temp.zuo.you;
                temp.zuo.you=temp;
                temp.zuo.fu=temp.fu;
                if (temp.fu.zuo==temp&&temp.fu!=null){
                    temp.fu.zuo=temp.zuo;
                }
                if (temp.fu.you==temp&&temp.fu!=null){
                    temp.fu.you=temp.zuo;
                }
                temp.fu=temp.zuo;
                temp.zuo=t3;
                if (t3!=null){
                    t3.fu=temp;
                }

            }else {
                node t2=temp.zuo.you.zuo;
                node t3=temp.zuo.you.you;
                temp.zuo.zuo.you=t2;
                if (t2!=null){
                    t2.fu=temp.zuo.you;
                }
                temp.zuo.fu=temp.zuo.you;
                temp.zuo.you.zuo=temp.zuo;
                temp.zuo=temp.zuo.you;
                temp.zuo.fu=temp;
                temp.zuo.fu=temp.fu;
                if (temp.fu!=null&&temp.fu.zuo==temp){
                    temp.fu.zuo=temp.zuo;
                }
                if (temp.fu!=null&&temp.fu.you==temp){
                    temp.fu.you=temp.zuo;
                }
                temp.zuo.you=temp;
                temp.fu=temp;
                temp.zuo=t3;
                if (t3!=null){
                    t3.fu=temp;
                }



            }
        }else {

            if (temp.you.you.high==temp.you.zuo.high+1){
                node t3=temp.you.zuo;
                temp.you.fu=temp.fu;
                if (temp.fu!=null&&temp.fu.zuo==temp){
                    temp.fu.zuo=temp.you;
                }
                if (temp.fu!=null&&temp.fu.you==temp){
                    temp.fu.you=temp.you;
                }
                temp.you.zuo=temp;
                temp.fu=temp.you;
                temp.you=t3;
                if (t3!=null){
                    t3.fu=temp;
                }

            }else {
                node t2=temp.you.zuo.zuo;
                node t3=temp.you.zuo.you;
                temp.you.fu=temp.you.zuo;
                temp.you.zuo.you=temp.you;
                temp.you.zuo.fu=temp;
                temp.you=temp.you.zuo;
                temp.you.you.zuo=t3;
                if (t3!=null){
                    t3.fu=temp.you.you;
                }
                temp.you.fu=temp.fu;
                if (temp.fu!=null&&temp.fu.zuo==temp){
                    temp.fu.zuo=temp.you;
                }
                if (temp.fu!=null&&temp.fu.you==temp){
                    temp.fu.you=temp.you;
                }
                temp.fu=temp.you;
                temp.you.zuo=temp;
                temp.you=t2;
                if (t2!=null){
                    t2.fu=temp;
                }


            }
        }

    }

    private static class node {
        int op;
        int size;
        int y;
        int dd;
        int left;
        int right;
        node zuo;
        node you;
        node fu;

        int high;

        boolean isdelect;
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
