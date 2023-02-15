import java.util.Scanner;
import java.util.Stack;

public class cs203_pofang {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int T= in.nextInt();
        for (int i=0;i<T;i++){
            int x= in.nextInt();
            String y= in.next();
            if (isValid(y)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }


    public static boolean isValid(String s) {
                 Stack<Character> stack = new Stack();
               for(Character ch : s.toCharArray()){
                        if(ch=='{'){
                                stack.push('}');
                             }else if(ch == '('){
                                 stack.push(')');
                             }else if(ch == '['){
                                 stack.push(']');
                             }else{
                                 if(stack.isEmpty() || stack.pop() != ch){
                                         return false;
                                     }
                             }
                     }
                 return stack.isEmpty();
             }
}
