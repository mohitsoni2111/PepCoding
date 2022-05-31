package Level_2.Dynamic_Programming;

import java.util.Scanner;

public class Temple_Offerings {
    public static int totalOffering(int[] height) {
        int[] larray = new int[height.length];
        larray[0] = 1;
        for (int i = 1; i < height.length; i++){
            if (height[i] > height[i - 1]){
                larray[i] = larray[i - 1] + 1;
            } else {
              larray[i] = 1;
            }
        }
        int[] rarray = new int[height.length];
        rarray[rarray.length - 1] = 1;
        for (int i = height.length - 2; i >= 0; i--){
            if (height[i] > height[i + 1]){
                rarray[i] = rarray[i + 1] + 1;
            } else {
                rarray[i] = 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < height.length; i++){
            ans += Math.max(larray[i], rarray[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = scn.nextInt();
        }
        System.out.println(totalOffering(height));
    }
}
