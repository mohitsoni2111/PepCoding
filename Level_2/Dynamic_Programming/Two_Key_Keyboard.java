package Level_2.Dynamic_Programming;
import java.util.Scanner;

// See DSA_Level_1.Prime_Factors
public class Two_Key_Keyboard {
    // Just find prime factorization of number
    // n = 18 = 2 X 3^2
    // Ans = 2 X 1(pow of 2) + 3 X 2(pow of 3) = 8
    public static int minSteps(int n) {
        int ans = 0;

        for (int i = 2; i <= Math.sqrt(n);){
            if (n % i == 0){
                ans += i;
                n /= i;
            } else {
                i++;
            }
        }
        if (n != 1){
            ans += n;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(minSteps(n));
    }
}
