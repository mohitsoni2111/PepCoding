package Level_2.Bit_Manipulation;

import java.util.Scanner;

public class Reduce_N_To_1 {
    public static int solution(long n) {

        int steps = 0;

        while (n != 1){
            if (n % 2 == 0){
                n = n / 2;
            }
            else if (n == 3){
                steps = 2;
                break;
            }
            else if ((n & 3) == 1){         // n % 4 == 1
                n = n - 1;
            }
            else if ((n & 3) == 3){         // n % 4 == 3
                n = n + 1;
            }
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(solution(n));
    }
}
