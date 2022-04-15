package Recursion_and_Backtracking;

import java.util.ArrayList;

public class Get_Keypad_combination {

    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    private static ArrayList<String> getKPC(String str) {
        if (str.length() == 0){
            ArrayList<String> bres= new ArrayList<>();
            bres.add("");
            return bres;
        }
        char ch = str.charAt(0);        // 6
        String rem = str.substring(1);  // 78

        ArrayList<String> rres = getKPC(rem);   // 6 words of 78
        ArrayList<String> mres = new ArrayList<>();

        String codeForCh = codes[ch - '0'];     // '0' -> 48 , '6' -> 54, therefore '6'-'0' = 6
        for (int i = 0; i < codeForCh.length(); i++){
            char chcode = codeForCh.charAt(i);
            for (String rstr : rres){
                mres.add(chcode + rstr);
            }
        }

        return mres;
    }


    static void printArrayList(ArrayList<String> arrList) {
        arrList.remove("");
        for (int i = 0; i < arrList.size(); i++)
            System.out.print(arrList.get(i) + " ");
    }
    public static void main(String[] args) {
        String str = "678";
        printArrayList(getKPC(str));
    }
}
