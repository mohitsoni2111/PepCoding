package Level_2.Rercursion_and_Backtracking;

import java.util.*;

public class Pattern_Matching {
    public static void solution(String str, String pattern, HashMap<Character,String> map, String op){
        if (pattern.length() == 0){
            if (str.length() == 0){
                HashSet<Character> alreadyPrinted = new HashSet<>();
                for (int i = 0; i < op.length(); i++){
                    char ch = op.charAt(i);
                    if (!alreadyPrinted.contains(ch)){
                        System.out.print(ch + " -> " + map.get(ch) + ", ");
                        alreadyPrinted.add(ch);
                    }
                }
                System.out.print(".");
            }
            return;
        }

        char ch = pattern.charAt(0);
        String rop = pattern.substring(1);
        if (map.containsKey(ch)){
            String previousMapping = map.get(ch);
            if (str.length() >= previousMapping.length()){
                String leftPart = str.substring(0, previousMapping.length());
                String rightPart = str.substring(previousMapping.length());
                if (previousMapping.equals(leftPart)){
                    solution(rightPart, rop, map, op);
                }
            }
        }
        else {
            for (int i = 0; i < str.length(); i++){
                String leftPart = str.substring(0, i + 1);
                String rightPart = str.substring(i + 1);
                map.put(ch, leftPart);
                solution(rightPart, rop, map, op);
                map.remove(ch);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        String pattern = scn.next();
        HashMap<Character,String> map = new HashMap<>();
        solution(str,pattern,map,pattern);
    }
}
