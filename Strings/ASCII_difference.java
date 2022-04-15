package Strings;

import java.util.Scanner;

public class ASCII_difference {
    public static String asciiDiffernce(String str){
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));

        for(int i = 1; i<str.length(); i++){
            char curr = str.charAt(i);
            char prev = str.charAt(i-1);
            sb.append(curr - prev);
            sb.append(curr);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(asciiDiffernce(str));
    }
}
