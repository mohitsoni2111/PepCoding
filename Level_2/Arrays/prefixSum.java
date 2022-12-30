package Level_2.Arrays;

import java.util.*;

public class prefixSum {
    private static int prefixSumSol(List<Integer> arr) {
        Collections.sort(arr);

        long sum = 0;
        int count = 0;
        for (int i = arr.size() - 1; i >= 0; i--) {
            sum += arr.get(i);
            if (sum <= 0) {
                break;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scn.nextInt());
        }
        int a = prefixSumSol(arr);
//        System.out.print(Integer.MAX_VALUE);
        System.out.print(a);
    }
}
