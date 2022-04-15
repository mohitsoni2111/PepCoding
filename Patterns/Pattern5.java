package Patterns;
import java.util.Scanner;
/*

------------------------------------------    Pattern 5 :   -----------------------------------------
		*
	*	*	*
*	*	*	*	*
	*	*	*
		*
 */
public class Pattern5 {

    static void pattern5(int n){
        int space = n/2;
        int star = 1;

        for(int i =1; i<=n ; i++){
            for (int j=1; j<=space; j++)
                System.out.print("\t");
            for (int j=1; j<=star; j++){
                System.out.print("*\t");
            }
            if(i <= n/2){
                space--;
                star+=2;
            }
            else{
                space++;
                star-=2;
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pattern5(n);
    }
}
