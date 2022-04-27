package Level_2.Bit_Manipulation;

import java.util.Scanner;

public class Utf_8_Encoding {
    public static boolean solution(int[] arr) {

        int remainingBytes = 0;
        for (int val : arr){
            if (remainingBytes == 0) {
                if ((val >> 7) == 0b0) {               // 1st byte of 1 length char
                    remainingBytes = 0;
                } else if ((val >> 5) == 0b110) {      // 1st byte of 2 length char
                    remainingBytes = 1;
                } else if ((val >> 4) == 0b1110) {     // 1st byte of 3 length char
                    remainingBytes = 2;
                } else if ((val >> 3) == 0b11110) {    // 1st byte of 4 length char
                    remainingBytes = 3;
                }
            }
            else {
                if ((val >> 6) == 0b10){
                    remainingBytes--;
                }
                else {
                    return false;
                }
            }
        }
        return remainingBytes == 0;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
}
