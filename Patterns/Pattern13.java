package Patterns;
import java.util.Scanner;
/*

------------------------------------------    Pattern 13 :   -----------------------------------------

1
1   1
1   2   1
1   3   3   1
1   4   6   4   1
1   5   10  10  5   1

 */
public class Pattern13 {

    static void pattern13(int n){

        for (int i =0; i<=n; i++){
            int icj = 1;
            for (int j=0; j<=i; j++){
                System.out.print(icj + "\t");
                icj = (icj * (i - j)) / (j + 1);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pattern13(n);
    }
}
