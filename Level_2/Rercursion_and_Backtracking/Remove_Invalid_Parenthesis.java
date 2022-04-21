package Level_2.Rercursion_and_Backtracking;

import java.util.*;

public class Remove_Invalid_Parenthesis {
    public static int getMin(String str){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if (ch == '('){
                stack.push(ch);
            }
            else if (ch == ')'){
                if (stack.size() == 0){
                    stack.push(ch);
                }
                else if (stack.peek() == ')'){
                    stack.push(ch);
                }
                else if (stack.peek() == '('){
                    stack.pop();
                }
            }
        }
        return stack.size();
    }

    public static void solution(String str, int minRemovalAllowed, HashSet<String> ans) {
        if (minRemovalAllowed == 0){
            int minimumRemovalNow = getMin(str);
            if (minimumRemovalNow == 0){
                if (!ans.contains(str)) {
                    System.out.println(str);
                    ans.add(str);
                }
            }
            return;
        }

        for (int i = 0; i < str.length(); i++){
            String left = str.substring(0, i);
            String right = str.substring(i + 1);
            solution(left + right, minRemovalAllowed + 1, ans);
        }
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int minimumRemoval = getMin(str);
        solution(str, minimumRemoval, new HashSet<>());
    }
}
