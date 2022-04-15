package Patterns;
import java.util.Scanner;
/*

------------------------------------------    Pattern 9 :   -----------------------------------------

*               *
   *        *
        *
   *        *
*               *

 */
public class Pattern9 {

    static void pattern9(int n){

        for(int i =1; i<=n ; i++){
            for (int j=1; j<=n; j++){
                if(i==j || i+j==n+1)
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
        pattern9(n);
    }
}
