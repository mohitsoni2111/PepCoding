package Patterns;
import java.util.Scanner;
/*

------------------------------------------    Pattern 17 :   -----------------------------------------

        *
        *   *
*   *   *   *   *
        *   *
        *
        
 */
public class Pattern17 {

    static void pattern17(int n){
        int space = n/2;
        int star = 1;

        for(int i =1; i<=n ; i++) {
            for (int j = 1; j <= space; j++) {
                if(i == n / 2 + 1){
                    System.out.print("*\t");
                }
                else {
                    System.out.print("\t");
                }
            }
            for (int j = 1; j <= star; j++) {
                System.out.print("*\t");
            }
            if (i <= n / 2) {
                star++;
            } else {
                star--;
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pattern17(n);
    }
}
