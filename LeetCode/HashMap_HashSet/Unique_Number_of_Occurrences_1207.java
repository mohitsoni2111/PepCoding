package LeetCode.HashMap_HashSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Unique_Number_of_Occurrences_1207 {

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : arr){
            map.putIfAbsent(a, 0);
            map.put(a, map.get(a) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (set.contains(entry.getValue())) {
                return false;
            }
            set.add(entry.getValue());
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(",");
        int[] num1 = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            num1[i] = Integer.parseInt(input[i]);
        }
        boolean result = uniqueOccurrences(num1);

        System.out.println(result);
    }
}
