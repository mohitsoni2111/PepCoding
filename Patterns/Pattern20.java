package Patterns;
import java.util.Scanner;
/*

------------------------------------------    Pattern 20 :   -----------------------------------------

*               *
*               *
*       *       *
*   *       *   *
*               *

 */
public class Pattern20 {

    static void pattern20(int n){

        for (int i =1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                if(j==1 || j==n)
                    System.out.print("*\t");
                else if (i > n/2 && (i==j || i+j == n+1))
                    System.out.print("*\t");
                else
                    System.out.print("\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pattern20(n);
    }
}
