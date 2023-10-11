package Level_2.Arrays;

import java.util.*;

public class Number_of_Flowers_in_Full_bloom_2251 {
    public static int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] sortedPeople = Arrays.copyOf(people, people.length);
        Arrays.sort(sortedPeople);

        Arrays.sort(flowers, (a, b) -> Arrays.compare(a, b));
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        int i = 0;
        for (int person : sortedPeople){
            while (i < flowers.length && flowers[i][0] <= person){
                heap.add(flowers[i][1]);
                i++;
            }
            while (!heap.isEmpty() && heap.peek() < person){
                heap.remove();
            }

            map.put(person, heap.size());
        }

        int[] ans = new int[people.length];
        for (int j = 0; j < people.length; j++){
            ans[j] = map.get(people[j]);
        }
        return ans;
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < 2; j++){
                arr[i][j] = scanner.nextInt();
            }
        }
        int k = scanner.nextInt();
        int [] people = new int[k];
        for (int i = 0; i < k; i++){
            people[i] = scanner.nextInt();
        }

        int[] res = fullBloomFlowers(arr, people);
        for (int re : res)
            System.out.println(re);
    }
}