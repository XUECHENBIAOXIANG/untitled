
import java.util.Scanner;

public class CS203_3_4 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int zongshu=in.nextInt();
        int maxhuan= in.nextInt();
        int cost=in.nextInt();
        long jieguo=0l;
        int [] yuan=new int[zongshu];
        for (int a=0;a<zongshu;a++){
            yuan[a]=in.nextInt();
            jieguo+=yuan[a];
        }

        int run_index=0;
        int[] lirun=new int[9*zongshu];
        int[] guo=new int[9*zongshu];
        for (int b=0;b<zongshu;b++){
            if (yuan[b]>0){
                String c=Integer.toString(yuan[b]);
                int[] kuai=new int[c.length()];
                for (int d=0;d<c.length();d++){
                    kuai[d]=Integer.parseInt(String.valueOf(c.charAt(d)));
                }
                for (int e=0;e<c.length();e++){
                    int f=kuai[e];
                    int zuida=0;
                    int zuida_index=0;
                    for (int g=c.length()-1;g>e;g--){
                        int h=kuai[g];
                        if (h>zuida){
                            zuida=h;zuida_index=g;
                        }
                    }
                    if (zuida<=f){
                        continue;
                    }else {
                        int kenneng= (int) ((zuida-f)*Math.pow(10,(c.length()-e-1))-(zuida-f)*Math.pow(10,(c.length()-zuida_index-1))-cost);
                        if (kenneng>=0){
                            kuai[zuida_index]=f;
                            kuai[e]=zuida;
                            lirun[run_index++]=kenneng;
                        }else {
                            break;
                        }
                    }
                }
            }else {
                String c=Integer.toString(yuan[b]);
                int[] kuai=new int[c.length()-1];
                for (int d=1;d< c.length();d++){
                    kuai[d-1]=Integer.parseInt(String.valueOf(c.charAt(d)));
                }
                for (int e=0;e< kuai.length;e++){
                    int f=kuai[e];
                    int zuida=10;
                    int zuida_index=0;
                    for (int g= kuai.length-1;g>e;g--){
                        int h=kuai[g];
                        if (h<zuida){
                            zuida=h;zuida_index=g;
                        }
                    }
                    if (zuida>=f){
                        continue;
                    }else {

                        int kenneng= (int) ((f-zuida)*Math.pow(10,(kuai.length-e-1))-(f-zuida)*Math.pow(10,(kuai.length-zuida_index-1))-cost);
                        if (kenneng>=0){
                            lirun[run_index++]=kenneng;
                            kuai[zuida_index]=f;
                            kuai[e]=zuida;
                        }else {
                            break;
                        }
                    }
                }
            }
        }


        mergesort(lirun,0, lirun.length-1,guo);

        for(int gg=0;gg<maxhuan;gg++){
            if (lirun[lirun.length-gg-1]==0){
                break;
            }

            jieguo+=lirun[lirun.length-gg-1];
        }

        System.out.println(jieguo);










    }

    public static void mergesort(int[]yuan,int left,int right,int[]guo){
        if (left<right){
            int middle=left+(right-left)/2;
            mergesort(yuan,left,middle,guo);
            mergesort(yuan,middle+1,right,guo);
            he(yuan,left,middle,right,guo);
        }
    }
    public static void he(int[]yuan, int left ,int middle,int right ,int[]guo){
        int zhi=left;
        int zuo=left;
        int you=middle+1;
        while (zuo<=middle&&you<=right){
            if (yuan[zuo]<=yuan[you]){
                guo[zhi]=yuan[zuo];
                zhi++;
                zuo++;
            }else {
                guo[zhi]=yuan[you];
                zhi++;
                you++;
            }
        }
        while (zuo<=middle){
            guo[zhi]=yuan[zuo];zhi++;zuo++;
        }
        while (you<=right){
            guo[zhi]=yuan[you];you++;zhi++;
        }
        for (int b=left;b<=right;b++){
            yuan[b]=guo[b];
        }
    }




}
