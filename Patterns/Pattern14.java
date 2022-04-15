package Patterns;
import java.util.Scanner;
/*

------------------------------------------    Pattern 14 :   -----------------------------------------

x * 1 = x
x * 2 = 2x
x * 3 = 3x
....
x * 10 = 10x

 */
public class Pattern14 {

    static void pattern14(int n){

        for (int i =1; i<=10; i++){
            System.out.println(n + " * " + i + " = " + n*i);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pattern14(n);
    }
}
