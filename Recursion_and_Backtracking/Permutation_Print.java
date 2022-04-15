package Recursion_and_Backtracking;

public class Permutation_Print {
    private static void printPermutatations(String str, String answerSoFar) {
        if (str.length() == 0){
            System.out.println(answerSoFar);
            return;
        }

        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            String rest = str.substring(0, i) + str.substring(i + 1);
            printPermutatations(rest, answerSoFar + ch);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        printPermutatations(str, "");
    }
}
