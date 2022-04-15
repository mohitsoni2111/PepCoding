package Stack_and_Queue;

import java.util.Stack;

public class Smallest_Number_Following_Pattern {

    private static void PrintMinNumberForPattern(String idid) {
        if (idid.length() > 8) return;
        Stack<Integer> stack = new Stack<>();
        int num = 1;

        for (int i = 0, j = 0;i < idid.length(); i++){
            char ch = idid.charAt(i);
            if (ch == 'd' || ch == 'D'){
                stack.push(num);
                num++;
            }
            else {
                stack.push(num);
                num++;

                while (!stack.isEmpty()){
                    System.out.print(stack.pop());
                }
            }
        }
        stack.push(num);
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }

    public static void main(String[] args){
        PrintMinNumberForPattern("IDID");
        PrintMinNumberForPattern("I");
        PrintMinNumberForPattern("DD");
        PrintMinNumberForPattern("II");
        PrintMinNumberForPattern("DIDI");
        PrintMinNumberForPattern("IIDDD");
        PrintMinNumberForPattern("DDIDDIID");
    }
}
