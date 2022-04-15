package Stack_and_Queue;

import java.util.Scanner;
import java.util.Stack;

public class Balanced_Bracket {

    static boolean handleClosing(Stack<Character> stack, char correspondingChar){
        if(stack.size()== 0 || stack.peek() != correspondingChar){
            return false;
        }
        else {
            stack.pop();
            return true;
        }
    }

    static boolean balancedBrackets(String str){
        if(str==null) return false;

        Stack<Character> stack = new Stack<>();
        boolean val;
        for(int i =0; i< str.length(); i++){
            char c = str.charAt(i);
            if(c == '[' || c == '{' || c =='('){
                stack.push(c);
            }
            else if(c == ')') {
                val = handleClosing(stack, c);
                if(!val)
                    return false;
            }
            else if(c == '}') {
                val = handleClosing(stack, c);
                if(!val)
                    return false;
            }
            else if(c == ']') {
                val = handleClosing(stack, c);
                if(!val)
                    return false;
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(balancedBrackets(s));
    }
}
