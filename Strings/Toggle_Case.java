package Strings;

import java.util.Scanner;

public class Toggle_Case {

    public static String toggleCase(String str){
        String ans = "";
        for(char c : str.toCharArray()){
            if(c >= 'a' && c <= 'z') {
                c = (char) ('A' + c - 'a');
                ans += c;
            }
            else if(c >= 'A' && c <= 'Z'){
                c = (char) ('a' + c - 'A');
                ans += c;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(toggleCase(str));
    }
}
