import java.util.Scanner;

public class CS203_1_4 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int ci= Integer.parseInt(in.nextLine());
        for (int c=0;c<ci;c++){
        String zong=in.nextLine();
        char[] ma=zong.toCharArray();
        int[] j=new int[40];
        for (int a=0;a< ma.length;a++){
             int b = Integer.parseInt("" + ma[a]);
            a++;
            if (ma[a]=='w'){
                j[b]++;
            }else if (ma[a]=='b'){
                j[b+10]++;
            }else if (ma[a]=='s'){
                j[b+20]++;
            }else {
                j[b+30]++;
            }
        }
        int hu=0;
        for (int d=1;d<38;d++){
            if(j[d]>=2){//将牌
                j[d]=j[d]-2;
                for (int e=1;e<38;e++) {
                    if (j[e] >= 3) {//刻子一号
                        j[e] = j[e] - 3;
                        for (int f = 1; f < 38; f++) {
                            if (j[f] >= 3) {//刻子二号
                                j[f] = j[f] - 3;
                                for (int g = 1; g < 38; g++) {
                                    if (j[g] >= 3) {//刻子三号
                                        j[g] = j[g] - 3;
                                        for (int h = 1; h < 38; h++) {//刻子四号
                                            if (j[h] >= 3) {
                                                hu = 1;
                                            }
                                        }
                                        for (int h = 2; h < 29; h++) {//三刻一顺
                                            if (j[h - 1] == 1 && j[h] == 1 && j[h + 1] == 1) {
                                                hu = 1;
                                            }
                                        }
                                        j[g] = j[g] + 3;
                                    }
                                }
                                for (int g = 2; g < 29; g++) {//两刻两顺
                                    if (j[g - 1] >= 1 && j[g] >= 1 && j[g + 1] >= 1) {
                                        j[g - 1]--;
                                        j[g]--;
                                        j[g + 1]--;
                                        for (int h = 2; h < 29; h++) {
                                            if (j[h - 1] == 1 && j[h] == 1 && j[h + 1] == 1) {
                                                hu = 1;
                                            }
                                        }
                                            j[g - 1]++;
                                            j[g]++;
                                            j[g + 1]++;
                                    }
                                }
                                    j[f] = j[f] + 3;
                            }
                        }
                        //一刻三顺
                        for (int f = 2; f < 29; f++) {
                            if (j[f - 1] >= 1 && j[f] >= 1 && j[f + 1] >= 1) {
                                j[f - 1]--;
                                j[f]--;
                                j[f + 1]--;
                                for (int g = 2; g < 29; g++) {
                                    if (j[g - 1] >= 1 && j[g] >= 1 && j[g + 1] >= 1) {
                                        j[g - 1]--;
                                        j[g]--;
                                        j[g + 1]--;
                                        for (int h = 2; h < 29; h++) {
                                            if (j[h - 1] == 1 && j[h] == 1 && j[h + 1] == 1) {
                                                hu = 1;
                                            }
                                        }
                                            j[g - 1]++;
                                            j[g]++;
                                            j[g + 1]++;
                                    }
                                }
                                    j[f - 1]++;
                                    j[f]++;
                                    j[f + 1]++;
                            }
                        }
                            j[e] = j[e] + 3;
                    }
                }
                    //四顺子
                    for(int e=2;e<29;e++){
                        if (j[e-1]>=1&&j[e]>=1&&j[e+1]>=1){
                            j[e-1]--;
                            j[e]--;
                            j[e+1]--;
                            for (int f = 2; f < 29; f++) {
                                if (j[f - 1] >= 1 && j[f] >= 1 && j[f + 1] >= 1) {
                                    j[f - 1]--;
                                    j[f]--;
                                    j[f + 1]--;
                                    for (int g = 2; g < 29; g++) {
                                        if (j[g - 1] >= 1 && j[g] >= 1 && j[g + 1] >= 1) {
                                            j[g - 1]--;
                                            j[g]--;
                                            j[g + 1]--;
                                            for (int h = 2; h < 29; h++) {
                                                if (j[h - 1] == 1 && j[h] == 1 && j[h + 1] == 1) {
                                                    hu = 1;
                                                }
                                            }
                                                j[g - 1]++;
                                                j[g]++;
                                                j[g + 1]++;
                                        }
                                    }
                                        j[f - 1]++;
                                        j[f]++;
                                        j[f + 1]++;
                                }
                            }
                                j[e-1]++;
                                j[e]++;
                                j[e+1]++;
                        }
                    }
                    j[d]=j[d]+2;
            }
        }
        if (hu==1){
            System.out.println("Blessing of Heaven");
        }else {
            System.out.println("Bad luck");
        }


        }
    }
}
