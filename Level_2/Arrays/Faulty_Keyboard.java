package Level_2.Arrays;

public class Faulty_Keyboard {
    public boolean isLongPressedName(String name, String typed) {
        int m = name.length();
        int n = typed.length();
        int i = 0;

        if(m > n) return false;
        if(m == n && name.equals(typed)) return true;

        for(int j = 0; j < n; j++){
            if(i < m && name.charAt(i) == typed.charAt(j)){
                i++;
            } else if(j == 0 || typed.charAt(j-1) != typed.charAt(j)) return false;
        }

        return i == m;
    }
}
