package Level_2.Bit_Manipulation;
import java.io.*;
import java.util.*;

public class Number_Of_Valid_Words {
    public static ArrayList<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < 26; i++){
            map.put((char)('a' + i), new ArrayList<>());
        }

        for (String word : words){
            int mask = 0;
            for (char ch : word.toCharArray()){
                int bit = ch - 'a';
                mask = mask | (1 << bit);
            }
            HashSet<Character> set = new HashSet<>();
            for (char ch : word.toCharArray()){
                if (set.contains(ch))
                    continue;
                set.add(ch);
                map.get(ch).add(mask);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (String puzzle : puzzles){
            int puzzleMask = 0;
            for (char ch : puzzle.toCharArray()){
                int bit = ch - 'a';
                puzzleMask = puzzleMask | (1 << bit);
            }
            char firstChar = puzzle.charAt(0);
            ArrayList<Integer> wordsToCheck = map.get(firstChar);
            int count = 0;
            for (int wordMask : wordsToCheck){
                if ((wordMask & puzzleMask) == wordMask){
                    count++;
                }
            }
            result.add(count);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0 ; i < words.length; i++) {
            words[i] = scn.next();
        }
        int m = scn.nextInt();
        String[] puzzles = new String[m];
        for (int i = 0 ; i < m ; i++) {
            puzzles[i] = scn.next();
        }
        ArrayList<Integer> ans = findNumOfValidWords(words, puzzles);
        for (int i = 0 ; i < m ; i++) {
            System.out.println(puzzles[i] + " -> " + ans.get(i));
        }
    }
}
