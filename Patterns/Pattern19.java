package Patterns;
import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.Scanner;
/*

------------------------------------------    Pattern 19 :   -----------------------------------------

*       *   *   *
*       *
*   *   *   *   *
        *       *
*   *   *       *

 */
public class Pattern19 {

    static void pattern19(int n){

        for (int i =1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                if(i==1){
                    if(j==1 || j > n/2)
                        System.out.print("*\t");
                    else
                        System.out.print("\t");
                }
                else if(i <= n / 2){
                    if(j==1 || j == n/2 + 1)
                        System.out.print("*\t");
                    else
                        System.out.print("\t");
                }
                else if(i == n / 2 + 1){
                    System.out.print("*\t");
                }
                else if(i < n){
                    if(j == n/2 + 1 || j == n)
                        System.out.print("*\t");
                    else
                        System.out.print("\t");
                }
                else {
                    if(j <= n/2 + 1 || j == n)
                        System.out.print("*\t");
                    else
                        System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pattern19(n);
    }
}