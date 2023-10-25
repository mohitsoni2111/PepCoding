package Level_2.Arrays;

import java.util.Scanner;

public class Next_Greater_Element_III {
    private static void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }
    private static void reverse(char[] charArray, int start) {
        int i = start, j = charArray.length - 1;
        while (i < j){
            swap(charArray, i, j);
            i++;
            j--;
        }
    }
    public static int nextGreaterElement(int n) {
        char[] charArray = ("" + n).toCharArray();
        int i = charArray.length - 2;
        while (i >= 0 && charArray[i] >= charArray[i + 1]){
            i--;
        }

        if (i < 0) return -1;

        int j = charArray.length - 1;
        while (j >= 0 && charArray[j] <= charArray[i]){
            j--;
        }
        swap(charArray, i, j);
        reverse(charArray, i + 1);
        try {
            return Integer.parseInt(new String(charArray));
        } catch (Exception e){
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int res = nextGreaterElement(n);

        System.out.println(res);
    }
}
