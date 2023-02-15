

    import java.io.*;
    import java.util.Arrays;
    import java.util.StringTokenizer;

    public class CS203_6_2 {
        public static void main(String[] args) {
            QReader62 in=new QReader62();
            QWriter62 out=new QWriter62();
            String A=in.nextLine();
            String B=in.nextLine();

            int right=Math.min(A.length(),B.length());
            int left=0;
            if (check(1,A,B)){
               if (right%2==0){
                   int right1=right/2+1;
                   while (right1!=left+1){
                       int middle=(left+right1)/2;
                       if (check(2*middle,A,B)){
                           left=middle;
                       }else {
                           right1=middle;
                       }
                   }
                   int ou=2*left;
                   int right2=right/2+1;
                   int left2=0;
                   while (right2!=left2+1){
                       int middle1=(left2+right2)/2;
                       if (check(2*middle1+1,A,B)){
                           left2=middle1;
                       }else {
                           right2=middle1;
                       }
                   }
                   int qi=2*left2+1;
                   if (qi>ou){
                       out.print(qi);
                   }else {
                       out.print(ou);
                   }
               }else {
                   int left3=0;
                   int right3=right/2+1;
                   while (right3!=left3+1){
                       int middle=(left3+right3)/2;
                       if (check(2*middle,A,B)){
                           left3=middle;}else {
                           right3=middle;
                       }
                   }int ou=2*left3;
                   int left4=0;
                   int right4=right/2+1;
                   while (right4!=left4+1){
                       int middle=(left4+right4)/2;
                       if (check(2*middle+1,A,B)){
                           left4=middle;
                       }else {
                           right4=middle;
                       }

                   }  int qi=2*left4+1;
                   if (qi>ou){
                       out.print(qi);
                   }else {
                       out.print(ou);
                   }



               }



            }else {
                out.print("-1");
            }

            out.close();





        }

        public static boolean check(int k,String A,String B){
            if (k>A.length()| k>B.length()){
                return false;
            }

            int[] pow=new int[28];
            for (int a=1;a<28;a++){
                int t=a;
                for (int j=1;j<k;j++){
                    t=t*27;
                }
                pow[a]=t;
            }

            int d=0;
            int[] pa=new int[A.length()];
            int[] pad=new int[A.length()];
            for (int a=0;a<k;a++){
                char b=A.charAt(a);
                int c=b-96;
                d=d*27+c;
            }
            pa[0]=d;

            for (int a=0;a+k<A.length();a++){
                char yuan=A.charAt(a);
                int yuan1=yuan-96;
                char xin=A.charAt(a+k);
                int xin1=xin-96;
                d= (((d-pow[yuan1])*27)+xin1);
                pa[a+1]=d;
            }
            d=0;
            for (int a=A.length()-1;a>A.length()-k-1;a--){
                char b=A.charAt(a);
                int c=b-96;
                d=d*27+c;
            }
            pad[A.length()-k]=d;
            for (int a=0;a+k<A.length();a++){
                char yuan =A.charAt(A.length()-a-1);
                int yuan1=yuan-96;
                char xin=A.charAt(A.length()-a-1-k);
                int xin1=xin-96;
                d=(d-pow[yuan1])*27+xin1;
                pad[A.length()-k-a-1]=d;
            }

            int[]ahui=new int[A.length()];
            int e=0;
            for (int a=0;a<pa.length;a++){
                if (pa[a]==pad[a]){
                    ahui[e]=pad[a];
                    e++;
                }
            }
            Arrays.sort(ahui);
            d=0;
            int[] pb=new int[B.length()];
            int[] pbd=new int[B.length()];
            for (int a=0;a<k;a++){
                char b=B.charAt(a);
                int c=b-96;
                d=d*27+c;
            }
            pb[0]=d;
            for (int a=0;a+k<B.length();a++){
                char yuan=B.charAt(a);
                int yuan1=yuan-96;
                char xin=B.charAt(a+k);
                int xin1=xin-96;
                d=  (((d-pow[yuan1])*27)+xin1);
                pb[a+1]=d;
            }
            d=0;
            for (int a=B.length()-1;a>B.length()-k-1;a--){
                char b=B.charAt(a);
                int c=b-96;
                d=d*27+c;
            }
            pbd[B.length()-k]=d;
            for (int a=0;a+k<B.length();a++){
                char yuan =B.charAt(B.length()-a-1);
                int yuan1=yuan-96;
                char xin=B.charAt(B.length()-a-1-k);
                int xin1=xin-96;
                d=(d-pow[yuan1])*27+xin1;
                pbd[B.length()-k-a-1]=d;
            }

            int[]bhui=new int[B.length()];
            int f=0;
            for (int a=0;a<pb.length;a++){
                if (pb[a]==pbd[a]){
                    bhui[f] = pbd[a];f++;
                    }
                }

            Arrays.sort(bhui);
            int ad=A.length()-1;
            int bd=B.length()-1;


            while (ad!=-1&&bd!=-1){
                if (ahui[ad]==bhui[bd]&&ahui[ad]!=0){
                    return true;
                }else {
                    if (ahui[ad]==bhui[bd]&&ahui[ad]==0){
                        ad--;
                    }else  if (ahui[ad]>bhui[bd]){
                        ad--;

                    }else if (ahui[ad]<bhui[bd]){
                        bd--;
                    }
                }
            }


            return false;
        }



    }
    class QReader62 {
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

    class QWriter62 implements Closeable {
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