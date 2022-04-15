package Patterns;
import java.util.Scanner;
/*

------------------------------------------    Pattern 2 :   -----------------------------------------
* * * * *
* * * *
* * *
* *
*

 */
public class Pattern2 {

    static void pattern2(int n){
        for(int i =1; i<=n ; i++){
            for (int j=n; j>=i; j--)
                System.out.print("*\t");
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pattern2(n);
    }
}
