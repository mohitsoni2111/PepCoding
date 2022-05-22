package Level_2.Dynamic_Programming;

import java.util.Scanner;

public class Boolean_Parenthesization {
    public static int solution(String str1, String str2) {
        int n = str1.length();
        int[][] dpTrue = new int[n][n];
        int[][] dpFalse = new int[n][n];

        for (int g = 0; g < dpTrue.length; g++){
            for (int i = 0, j = g; j < dpTrue.length; i++, j++){

                if (g == 0){
                    char ch = str1.charAt(i);
                    if (ch == 'T'){
                        dpTrue[i][j] = 1;
                        dpFalse[i][j] = 0;
                    }
                    else {
                        dpTrue[i][j] = 0;
                        dpFalse[i][j] = 1;
                    }
                }
                else {
                    for (int k = i; k < j; k++){
                        char operator = str2.charAt(k);
                        int ltc = dpTrue[i][k];
                        int rtc = dpTrue[k + 1][j];
                        int lfc = dpFalse[i][k];
                        int rfc = dpFalse[k + 1][j];

                        if (operator == '&'){
                            dpTrue[i][j] += ltc * rtc;
                            dpFalse[i][j] += lfc * rtc + ltc * rfc + lfc * rfc;
                        }
                        else if (operator == '|'){
                            dpTrue[i][j] += ltc * rtc + lfc * rtc + ltc * rfc;
                            dpFalse[i][j] += lfc * rfc;
                        }
                        else {  // operator is '^'
                            dpTrue[i][j] += ltc * rfc + lfc * rtc;
                            dpFalse[i][j] += lfc * rfc + ltc * rtc;
                        }
                    }
                }
            }
        }
        return dpTrue[0][dpTrue.length - 1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(solution(s1, s2));
    }
}
