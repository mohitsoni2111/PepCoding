package Patterns;
import java.util.Scanner;
/*

------------------------------------------    Pattern 15 :   -----------------------------------------

		*                   1                   1                    1                   1                   1
	*	*	*           1   1   1           2   2   2            2   2   2           2   3   4           2   3   2
*	*	*	*	*-> 1   1   1   1   1-> 3   3   3   3   3->  3   3   3   3   3-> 3   4   5   6   7-> 3   4   5   4   3
	*	*	*           1   1   1           4   4   4            2   2   2           2   3   4           2   3   2
		*                   1                   5                    1                   1                   1

 */
public class Pattern15 {

    static void pattern15(int n){
        int space = n / 2;
        int star = 1;
        int val = 1;

        for (int i = 1; i<=n; i++){
            for(int j = 1; j<=space; j++){
                System.out.print("\t");
            }

            int cval = val;
            for(int j = 1; j<=star; j++){
                System.out.print(cval + "\t");
                if(j <= star / 2)
                    cval++;
                else
                    cval--;

                // cval++; (Step 5)
            }
            if (i <= n/2){
                space--;
                star+=2;
                val++;
            }
            else {
                space++;
                star-=2;
                val--;
            }
            // val++ (Step 3)
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pattern15(n);
    }
}
