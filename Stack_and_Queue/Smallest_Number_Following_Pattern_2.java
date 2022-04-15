package Stack_and_Queue;

public class Smallest_Number_Following_Pattern_2 {
    private static String findMinNumberPattern(String str) {
        if (str.length() > 9) return "-1";
        String ans = "";
        int i = 0;
        int curr = 1;
        int dCount = 0;

        while (i < str.length()){
            char ch = str.charAt(i);

            if (i == 0 && (ch == 'i' || ch == 'I')){        // First Character
                ans += curr;
                curr++;
            }
            if (ch == 'd' || ch == 'D')
                dCount++;

            // Count 'D' from i+1 index
            int j = i + 1;
            while (j < str.length() && (str.charAt(j) == 'D' || str.charAt(j) == 'd')){
                dCount++;
                j++;
            }
            int k = dCount;
            while (dCount > 0){
                ans += curr + dCount;
                dCount--;
            }

            curr += k + 1;
            dCount = 0;
            i = j;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findMinNumberPattern("DIDID"));
        System.out.println(findMinNumberPattern("DIDIII"));
        System.out.println(findMinNumberPattern("DDDIIDI"));
        System.out.println(findMinNumberPattern("IDIDIID"));
        System.out.println(findMinNumberPattern("DIIDIDD"));
        System.out.println(findMinNumberPattern("IIDIDDD"));
    }
}
