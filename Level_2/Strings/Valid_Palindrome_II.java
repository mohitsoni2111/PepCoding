package Level_2.Strings;

public class Valid_Palindrome_II {
    private boolean isPalindromeCheck(String s, int left, int right) {
        while (left < right){
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        boolean flag = false;
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)){
                return isPalindromeCheck(s, left + 1, right) || isPalindromeCheck(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }
}
