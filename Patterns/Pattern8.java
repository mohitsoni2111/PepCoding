package Patterns;
import java.util.Scanner;
/*

------------------------------------------    Pattern 8 :   -----------------------------------------

                *
            *
        *
    *
*

 */
public class Pattern8 {

    static void pattern8(int n){

        for(int i =1; i<=n ; i++){
            for (int j=1; j<=n; j++){
                if(i+j==n+1)
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
        pattern8(n);
    }
}
