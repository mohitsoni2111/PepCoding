package Recursion_and_Backtracking;

import java.util.Scanner;

public class Print_Encoding {
    private static void printEncoding(String que, String answerSoFar) {
        if (que.length() == 0){
            System.out.println(answerSoFar);
            return;
        }
        else if (que.length() == 1){
            char ch = que.charAt(0);
            if (ch == '0')
                return;
            else {
                int chv = ch - '0';
                char code = (char) ('a' + chv - 1);
                System.out.println(answerSoFar + code);
            }
        }
        else {                                  // More than 2 characters
            char ch = que.charAt(0);
            String roq = que.substring(1);

            if (ch == '0')
                return;
            else {
                int chv = ch - '0';
                char code = (char) ('a' + chv - 1);
                printEncoding(roq, answerSoFar + code);
            }

            String ch12 = que.substring(0, 2);
            String roq12 = que.substring(2);

            int ch12v = Integer.parseInt(ch12);
            if (ch12v <=26){
                char code = (char) ('a' + ch12v - 1);
                printEncoding(roq12, answerSoFar + code);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        printEncoding(str, "");
    }
}
