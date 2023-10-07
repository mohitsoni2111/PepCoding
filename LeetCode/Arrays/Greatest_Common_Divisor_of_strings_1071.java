package LeetCode.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greatest_Common_Divisor_of_strings_1071 {

    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";

        int gcd = gcd(str1.length(), str2.length());

        return str1.substring(0, gcd);
    }

    public static int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        String result = gcdOfStrings(str1, str2);
        System.out.println(result);
    }
}
