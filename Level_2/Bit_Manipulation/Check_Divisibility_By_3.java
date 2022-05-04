package Level_2.Bit_Manipulation;

import java.util.Scanner;

public class Check_Divisibility_By_3 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        int odd = 0;
        int even = 0;

        for (int i = 0; i < str.length(); i++){
            int bit = str.charAt(i) - '0';

            if (i % 2 == 0){
                even += bit;
            } else {
                odd += bit;
            }
        }

        int delta = even - odd;
        System.out.println(delta % 11 == 0);
    }
}
