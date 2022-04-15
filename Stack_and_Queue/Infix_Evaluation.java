package Stack_and_Queue;

import java.util.Stack;

public class Infix_Evaluation {

    public static int precedence(char operator){        // Since only '*', '/' will return 2;
        if (operator =='+' || operator =='-') return 1;
        else return 2;
    }

    public static int operation(int val1, int val2, char operator){
        if (operator =='+') return val1 + val2;
        else if (operator =='-') return val1 - val2;
        else if (operator =='*') return val1 * val2;
        else return val1 / val2;
    }

    private static int infixEvaluation(String str) {
        if (str == null) return -1;

        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for(char c : str.toCharArray()){
            if (c == '('){
                operators.push(c);
            }
            else if (Character.isDigit(c)){
                operands.push(c - '0');
            }
            else if (c == ')'){
                while (operators.peek() != '('){
                    char operator = operators.pop();
                    int val2 = operands.pop();
                    int val1 = operands.pop();
                    int result = operation(val1, val2, operator);
                    operands.push(result);
                }
                operators.pop();
            }
            else if (c == '+' || c == '-' || c == '*' || c == '/'){
                // c wants to solve higher priority operators first
                while (!operators.isEmpty() && operators.peek() != '(' && precedence(c) <= precedence(operators.peek())){
                    char operator = operators.pop();
                    int val2 = operands.pop();
                    int val1 = operands.pop();
                    int result = operation(val1, val2, operator);
                    operands.push(result);
                }
                // c is pushing in last
                operators.push(c);
            }
        }
        while (!operators.isEmpty()){
            char operator = operators.pop();
            int val2 = operands.pop();
            int val1 = operands.pop();
            int result = operation(val1, val2, operator);
            operands.push(result);
        }
        return operands.peek();
    }

    public static void main(String[] args){
        String str = "2+6*4/8-3";
        System.out.println(infixEvaluation(str));
    }
}
