package Recursion_and_Backtracking;

import java.util.ArrayList;

public class Subsequences_of_Strings {
    private static ArrayList<String> findSubSequences(String str) {
        if (str.length()==0){
            ArrayList<String> empty = new ArrayList<>();
            empty.add("");
            return empty;
        }

        char ch = str.charAt(0);
        String subStr = str.substring(1);
        ArrayList<String> subsequences = findSubSequences(subStr);

        ArrayList<String> res = new ArrayList<>();
        for (String s : subsequences){
            res.add(s);
            res.add(ch + s);
        }
        return res;
    }

    static void printArrayList(ArrayList<String> arrList) {
        arrList.remove("");
        for (int i = 0; i < arrList.size(); i++)
            System.out.print(arrList.get(i) + " ");
    }

    public static void main(String[] args) {
        String str = "abed";
        printArrayList(findSubSequences(str));
    }
}
