package Patterns;
import java.util.Scanner;
/*

------------------------------------------    Pattern 1 :   -----------------------------------------
*
* *
* * *
* * * *
* * * * *

 */
public class Pattern1 {

    static void pattern1(int n){
        for(int i =1; i<=n ; i++){
            for (int j=1; j<=i; j++)
                System.out.print("*\t");
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pattern1(n);
    }
}
