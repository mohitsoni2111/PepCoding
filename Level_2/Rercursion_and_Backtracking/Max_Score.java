package Level_2.Rercursion_and_Backtracking;

import java.util.Scanner;

public class Max_Score {

    public static int solution(String[] words, int[] farr, int[] score, int idx) {
        if (idx == words.length) return 0;

        int scoreNo = solution(words, farr, score, idx + 1); // not included

        // include
        int scoreWord = 0;
        String word = words[idx];
        boolean flag = true; // true if yes call can be made
        for (int i = 0; i < words.length; i++){
            char ch = word.charAt(i);

            if (farr[ch - 'a'] == 0) {
                flag = false;
            }

            farr[ch - 'a']--;
            scoreWord += score[ch - 'a'];

        }

        int scoreYes = 0;
        if (flag){
            scoreYes = scoreWord + solution(words, farr, score, idx + 1);
        }

        for (int i = 0; i < words.length; i++){
            char ch = word.charAt(i);
            farr[ch - 'a']++;
        }

        return Math.max(scoreNo, scoreYes);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int nofWords = scn.nextInt();
        String[] words = new String[nofWords];
        for(int i = 0 ; i < words.length; i++) {
            words[i] = scn.next();
        }
        int nofLetters = scn.nextInt();
        char[] letters = new char[nofLetters];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = scn.next().charAt(0);
        }
        int[] score = new int[26];
        for (int i = 0; i < score.length; i++) {
            score[i] = scn.nextInt();
        }
        if (words.length == 0 || letters.length == 0) {
            System.out.println(0);
            return;
        }
        int[] farr = new int[score.length];
        for (char ch : letters) {
            farr[ch - 'a']++;
        }
        System.out.println(solution(words, farr, score, 0));

    }
}
