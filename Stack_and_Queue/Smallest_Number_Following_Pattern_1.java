package Stack_and_Queue;

import java.util.Stack;

public class Smallest_Number_Following_Pattern_1 {
    private static String PrintMinNumberForPattern(String str) {
        if (str.length() > 9) return "-1";
        String result = "";
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= str.length(); i++){
            stack.push(i + 1);

            if (i == str.length() || str.charAt(i) == 'I'){
                while (!stack.isEmpty()){
                    result += String.valueOf(stack.peek());
                    stack.pop();
                }
            }
        }
        return result;
    }

    // main function
    public static void main(String[] args) {
        System.out.println(PrintMinNumberForPattern("IDID"));
        System.out.println(PrintMinNumberForPattern("I"));
        System.out.println(PrintMinNumberForPattern("DD"));
        System.out.println(PrintMinNumberForPattern("II"));
        System.out.println(PrintMinNumberForPattern("DIDI"));
        System.out.println(PrintMinNumberForPattern("IIDDD"));
        System.out.println(PrintMinNumberForPattern("DDIDDIID"));
    }
}
