package Patterns;
import java.util.Scanner;
/*

------------------------------------------    Pattern 7 :   -----------------------------------------
*   
    *
        *	    
            *	
                *   

 */
public class Pattern7 {

    static void pattern7(int n){

        for(int i =1; i<=n ; i++){
            for (int j=1; j<=n; j++){
                if(i==j)
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
        pattern7(n);
    }
}
