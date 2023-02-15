import java.util.Scanner;

public class CS203_3_3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int renshu=in.nextInt();
        int[] total=new int[renshu];
        int[] beiyong=new int[renshu];
        for (int a=0;a<renshu;a++){
            total[a]=in.nextInt();
        }
        mergesort(total,0, total.length-1,beiyong);



        int k=renshu/3;

        System.out.println(total[k]);

        int[] bian=new int[renshu];

        for (int a=0;a<k;a++){
            bian[3*a]=total[a];
        }

        for (int a=0;a< bian.length;a++){
            if (bian[a]==0){
                bian[a]=total[k];
                        k++;
            }
        }
        for (int a=0;a<renshu;a++){
            System.out.print(bian[a]+" ");
        }






    }

    public static void mergesort(int[]total,int i, int j,int[]beiyong){
        if (j>i){
            int middle=i+(j-i)/2;
            mergesort(total,i,middle,beiyong);
            mergesort(total,middle+1,j,beiyong);
            hecheng(total,i,middle,j,beiyong);
        }
    }
    public static void hecheng(int[]total,int i ,int middle,int j,int[]beiyong){
        int left=i;
        int right=middle+1;
        int mu=i;
        while (left<=middle&&right<=j){
            if (total[left]<=total[right]){
                beiyong[mu]=total[left];
                mu++;left++;
            }else {
                beiyong[mu]=total[right];
                mu++;right++;
            }
        }
        while (left<=middle){
            beiyong[mu]=total[left];
            mu++;left++;
        }
        while (right<=j){
            beiyong[mu]=total[right];
            mu++;right++;
        }
        for (int b=i;b<=j;b++){
            total[b]=beiyong[b];
        }


    }

 /*   public static void quicksort(int[]total, int i, int j){
        if (j > i) {
            int left=i;
            int right=j;
            int biaozhi= total[i];
            while (left<right){
                while (total[right]>biaozhi){
                    right--;
                }
                if (left!=right&&left<right){
                    total[left]=total[right];
                }

                while (total[left]<biaozhi&&left<right){
                    left++;
                }

                if (left!=right){
                 total[right]=total[left];
                }
            }
            total[left]=biaozhi;
            quicksort(total,i,left-1);
            quicksort(total,left+1,j);
        }else {
            return;
        }
    }
*/

}
