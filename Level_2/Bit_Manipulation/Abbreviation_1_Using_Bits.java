package Level_2.Bit_Manipulation;

import java.util.Scanner;

public class Abbreviation_1_Using_Bits {
    public static void solve(String str){
        for (int i = 0; i < (1 << str.length()); i++){
            StringBuilder sb = new StringBuilder();
            int count = 0;

            for (int j = 0; j < str.length(); j++){
                char ch = str.charAt(j);
                int bit = str.length() - 1 - j;

                if ((i & (1 << bit)) == 0){
                    if (count == 0){
                        sb.append(ch);
                    }
                    else {
                        sb.append(count);
                        sb.append(ch);
                        count = 0;
                    }
                }
                else {
                    count++;
                }
            }
            if (count > 0) {
                sb.append(count);
            }
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solve(str);
    }
}
