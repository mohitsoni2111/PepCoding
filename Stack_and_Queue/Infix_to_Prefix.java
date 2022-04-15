package Stack_and_Queue;

import java.util.Stack;

public class Infix_to_Prefix {

    static boolean isAlpha(char c){
        return (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z');
    }
    static boolean isDigit(char c) {
        return (c >= '0' && c <= '9');
    }
    static boolean isOperator(char c){
        return (!isAlpha(c) && !isDigit(c));
    }
    static String reverse(char[] str, int start, int end){
        char temp;
        while (start < end){
            temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(str);
    }
    static int precedence(char c){
        return switch (c) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    private static String infixToPostfix(char[] infix1) {
        System.out.println(infix1);
        String infix = '(' + String.valueOf(infix1) + ')';
        int length = infix.length();
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++){
            char c = infix.charAt(i);
            // If the scanned character is an operand, add it to output.
            if (isAlpha(c) || isDigit(c))
                result.append(c);

            else if (c == '(')
                stack.push(c);

            else if (c == ')'){
                while (!stack.isEmpty() && stack.peek() != '(')
                    result.append(stack.pop());

                // Remove '(' from the stack
                stack.pop();
            }

            // Operator found
            else {
                if (isOperator(stack.peek())){
                    while (precedence(c) < precedence(stack.peek()) ||
                            precedence(c) <= precedence(stack.peek()) && c == '^')
                        result.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()){
            if (stack.peek() == '(')
                return "Invalid Expression";
            result.append(stack.pop());
        }
        return result.toString();
    }

    private static String infixToPrefix(String exp){
        char[] infix = exp.toCharArray();
        int length = infix.length;

        String infix_rev = reverse(infix, 0, length - 1);
        infix = infix_rev.toCharArray();

        // Replace '(' with ')' and vice versa
        for (int i = 0; i < length; i++){
            if (infix[i] == '('){
                infix[i] = ')';
                i++;
            }
            else if (infix[i] == ')'){
                infix[i] = '(';
                i++;
            }
        }

        String prefix = infixToPostfix(infix);

        // Reverse Postfix
        prefix = reverse(prefix.toCharArray(), 0, length - 1);
        return prefix;
    }


    // Driver code
    /*
    Step 1: Reverse the infix expression i.e A+B*C will become C*B+A. Note while
            reversing each ‘(‘ will become ‘)’ and each ‘)’ becomes ‘(‘.
    Step 2: Obtain the “nearly” postfix expression of the modified expression i.e CB*A+.
    Step 3: Reverse the postfix expression. Hence, in our example prefix is +A*BC.

    As per Infix to Postfix, we have to pop all the operators from the stack which are greater than or equal to in
    precedence than that of the scanned operator. But here, we have to pop all the operators from the stack which are
    greater in precedence than that of the scanned operator. Only in the case of “^” operator, we pop operators from
    the stack which are greater than or equal to in precedence.
     */
    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPrefix(exp));
    }
}
