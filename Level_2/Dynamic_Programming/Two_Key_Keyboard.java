package Level_2.Dynamic_Programming;
import java.util.Scanner;

// See DSA_Level_1.Prime_Factors
public class Two_Key_Keyboard {
    // Just find prime factorization of number
    // n = 18 = 2 X 3^2
    // Ans = 2 X 1(pow of 2) + 3 X 2(pow of 3) = 8
    public static int minSteps(int n) {
        int ans = 0;

        while (n % 2==0){
            ans += 2;
            n /= 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i+=2){
            while (n % i == 0){
                ans += i;
                n /= i;
            }
        }

        // If n is prime
        if(n > 2)
            ans = n;

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(minSteps(n));
    }
}
