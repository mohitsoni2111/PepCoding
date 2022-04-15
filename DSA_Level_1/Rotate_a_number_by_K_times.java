package DSA_Level_1;

public class Rotate_a_number_by_K_times {

    // Function to find the count of digits in N
    static int noOfDigits(int n){
        int digit = 0;
        while(n>0){
            digit++;
            n=n/10;
        }
        return digit;
    }

    // Function to rotate number N by K times (Anti-Clockwise)
    static void rotateNumberByK(int N, int K){
        int count = noOfDigits(N);                                  // 5

        // Update K so that only need to handle left rotation
        K = ((K % count) + count) % count;                          // ((1 % 5) + 5) % 5 = 1

        // Stores first K digits of N
        int leftNumber = N / (int)Math.pow(10, count - K);          // 12345 / 10^4 = 1

        // Remove the first K digits
        N = N % (int)Math.pow(10, count - K);                       // 2345

        int leftDigit = noOfDigits(leftNumber);                     // 1

        // Append leftNumber to right of digits of N
        N = (N * (int)Math.pow(10, leftDigit)) + leftNumber;        // 23451

        System.out.println(N);
    }

    // Driver function
    public static void main(String args[]){

        int N = 12345, K = 1;

        // Function Call
        rotateNumberByK(N, K);  //23451 (for K = 1)
    }
}
