package Patterns;
import java.util.Scanner;
/*

------------------------------------------    Pattern 16 :   -----------------------------------------
1                       1
1   2               2   1
1   2   3       3   2   1
1   2   3   4   3   2   1
 */
public class Pattern16 {

    static void pattern16(int n){
        int star = 1;
        int space = 2*n - 3;
        int val = 1;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= star; j++){
                System.out.print(val + "\t");
                val++;
            }
            for(int j = 1; j <= space; j++){
                System.out.print("\t");
            }
            if( i == n){
                star--;
                val--;
            }

            for(int j = 1; j <= star; j++){
                val--;
                System.out.print(val + "\t");
            }
            star++;
            space-=2;

            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pattern16(n);
    }
}
