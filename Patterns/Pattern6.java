package Patterns;
import java.util.Scanner;
/*

------------------------------------------    Pattern 6 :   -----------------------------------------
*   *   *       *   *   *
*	*	            *	*
*	    		    	*
*	*	            *	*
*   *   *       *   *   *

 */
public class Pattern6 {

    static void pattern6(int n){
        int space = 1;
        int star = 3;

        for(int i =1; i<=n ; i++){
            for (int j=1; j<=star; j++)
                System.out.print("*\t");
            for (int j=1; j<=space; j++)
                System.out.print("\t");
            for (int j=1; j<=star; j++)
                System.out.print("*\t");

            if(i <= n/2){
                space+=2;
                star--;
            }
            else{
                space-=2;
                star++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pattern6(n);
    }
}
