package Stack_and_Queue;

import java.util.Scanner;
import java.util.Stack;

public class Duplicate_Brackets {
    static boolean duplicateBrackets(String str){
        if(str==null) return false;

        Stack<Character> stack = new Stack<>();
        for(int i =0; i< str.length(); i++){
            char c = str.charAt(i);
            if(c == ')'){
                if(stack.peek()== '('){
                    return true;
                }
                else {
                    while (stack.peek()!='('){
                        stack.pop();
                    }
                }
            }
            else {
                stack.push(c);
            }
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(duplicateBrackets(s));
    }
}
