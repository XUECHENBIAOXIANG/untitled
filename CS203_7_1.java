import java.util.ArrayList;
import java.util.Scanner;

public class CS203_7_1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int num=in.nextInt();
        node71[] tree=new node71[n];
        for (int a=0;a<n;a++){
            tree[a]=new node71();
        }
        for (int i=0;i<n-1;i++){
            int a=in.nextInt()-1;
            int b=in.nextInt()-1;
            int w= in.nextInt();
            tree[a].child.add(tree[b]);
            tree[b].child.add(tree[a]);
            tree[a].weight.add(w);
            tree[b].weight.add(w);
        }
        node71[] q=new node71[n];
        int front=0;int rear=0;
        int cnt=0;
        q[rear++]=tree[0];
        q[0].x=0;
        while (rear!=front){
            node71 temp=q[front++];
            if (temp.x==num&&temp.child.size()==1){
                cnt++;
            }
            temp.isvisit=true;
            for (int d=0;d<temp.child.size();d++){
                if (!temp.child.get(d).isvisit){
                    q[rear++]=temp.child.get(d);
                    temp.child.get(d).x=temp.x+temp.weight.get(d);
                }
            }
        }

        System.out.println(cnt);

    }
}

class node71{
    int x;
    boolean isvisit;
    ArrayList<node71> child =new ArrayList<>();
    ArrayList<Integer> weight=new ArrayList<>();
}