package Level_2.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class numbers {
    private static void closestNumber(List<Integer> numbers) {
        Collections.sort(numbers);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < numbers.size(); i++){
            min = Math.min(min, Math.abs(numbers.get(i) - numbers.get(i - 1)));
        }
        for (int i = 1; i < numbers.size(); i++){
            if (numbers.get(i) - numbers.get(i-1) == min){
                System.out.print(numbers.get(i-1) + " " + numbers.get(i));
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            arr.add(scn.nextInt());
        }
        closestNumber(arr);
    }
}
