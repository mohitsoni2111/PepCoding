package Strings;

import java.util.Scanner;

public class String_Compression {

    private static String stringCompression1(String str) {
        if(str==null) return null;

        String ans = String.valueOf(str.charAt(0));         // or String ans = str.charAt(0) + "";
        for (int i = 1; i < str.length(); i++){
            char curr_chr = str.charAt(i);
            char prev_chr = str.charAt(i-1);
            if(curr_chr!=prev_chr)
                ans+=curr_chr;
        }
        return ans;
    }


    private static String stringCompression2(String str) {
        if (str==null) return null;

        int n = str.length();
        int count = 1;
        String ans = str.charAt(0) + "";

        for (int i = 1; i < n; i++){
            char curr_chr = str.charAt(i);
            char prev_chr = str.charAt(i-1);

            if(curr_chr==prev_chr)
                count++;
            else {
                if (count > 1){
                    ans += count;
                    count = 1;
                }
                ans +=curr_chr;
            }
        }
        if (count > 1){
            ans += count;
            count = 1;
        }

        return ans;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(stringCompression1(str));
        System.out.println(stringCompression2(str));
    }
}
