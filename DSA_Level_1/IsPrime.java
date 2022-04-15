package DSA_Level_1;

import java.util.Scanner;

public class IsPrime {

    public static boolean isPrimeNumber(int n){
        if(n <= 1) return false;
        if(n <= 3) return true;
        if(n % 2 == 0 || n % 3 == 0) return false;

        for(int i = 5; i <= Math.sqrt(n); i = i + 6)
            if(n % i == 0 || n % (i+2) == 0)
                return false;

        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isPrimeNumber(n));

    }
}
