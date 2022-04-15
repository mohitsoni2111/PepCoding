package Patterns;
import java.util.Scanner;
/*

------------------------------------------    Pattern 11 :   -----------------------------------------

1
2   3
4   5   6
7   8   9   10
11  12  13  14  15


 */
public class Pattern11 {

    static void pattern11(int n){
        int val = 1;
        for(int i =1; i<=n; i++){
            for (int j=1; j<=i; j++){
                System.out.print(val + "\t");
                val++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pattern11(n);
    }
}
