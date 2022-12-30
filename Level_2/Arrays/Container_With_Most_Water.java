package Level_2.Arrays;

import java.util.Scanner;

public class Container_With_Most_Water {
    public static int mostArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int water = 0;

        while (i < j) {
            int width = j - i;
            int height = Math.min(heights[i], heights[j]);

            water = Math.max(water, height * width);

            if (heights[i] < heights[j]) i++;
            else j--;
        }
        return water;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] heights = new int[n];
        for(int i = 0; i < n; i++) {
            heights[i] = scn.nextInt();
        }

        int res = mostArea(heights);
        System.out.println(res);
    }
}
