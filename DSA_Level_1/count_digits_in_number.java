// https://www.geeksforgeeks.org/program-count-digits-integer-3-different-methods/

package DSA_Level_1;

public class count_digits_in_number {

    private static int countDigit(long n) {
        if(n/10==0)
            return 1;

        return 1 + countDigit(n/10);
    }
    public static void main(String[] args){
        long n = 345289467;
        System.out.print("Number of digits : " + countDigit(n));
    }
}
