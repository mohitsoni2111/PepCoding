package Stack_and_Queue;

import java.util.Stack;

public class Infix_to_Postfix {
    static int precedence(char ch){
        switch (ch){
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    private static String infixToPostfix(String exp) {
        String result = new String("");
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++){
            char c = exp.charAt(i);

            // If the scanned character is operand add it to output
            if (Character.isLetterOrDigit(c))
                result += c;

            else if (c == '(')
                stack.push(c);

            else if (c == ')'){
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();

                // Remove '(' from the stack
                stack.pop();
            }

            // An operator is encountered
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek()))
                    result += stack.pop();

                stack.push(c);
            }
        }

        // Pop all the operators from the stack
        while (!stack.isEmpty()){
            if (stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }

    // Driver code
    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
    }
}
