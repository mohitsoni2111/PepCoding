package Hashmap_And_Heaps;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Hashmap_and_Heap {

    public static Character highestFrequencyCharacter(@NotNull String inputString){
        HashMap<Character, Integer> map = new HashMap<>();
        char[] strArray = inputString.toCharArray();
        for (char c : strArray){
            if (map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
            }
        }
        char mfc = strArray[0];
        for (Character key : map.keySet()){
            if (map.get(key) > map.get(mfc))
                mfc = key;
        }
        return mfc;
    }
    public static void getCommonElements(int @NotNull [] arr1, int[] arr2){

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr1){
            if (map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
                map.put(i, 1);
        }
        for (int i : arr2){
            if (map.containsKey(i)){
                System.out.println(i);
                map.remove(i);
            }
        }
    }
    public static void getCommonElementsRetainAll(int @NotNull [] arr1, int[] arr2){

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : arr1){
            set1.add(i);
        }
        for (int i : arr2){
            set2.add(i);
        }
        set2.retainAll(set1);
        System.out.println(set2);
    }
    public static void getCommonElementsRetainAll2(int @NotNull [] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr1){
            if (map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
                map.put(i, 1);
        }
        for (int i : arr2){
            if (map.containsKey(i) && map.get(i) > 0){
                System.out.println(i);
                map.put(i, map.get(i) - 1);
            }
        }
    }
    public static void longestConsecutiveElements(int @NotNull [] arr){
        if (arr.length == 0) return;

        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i : arr){
            map.put(i, true);
        }
        for (int i : arr){
            if (map.containsKey(i - 1))
                map.put(i, false);
        }
        int ml = 0;
        int msp = 0;
        for (int i : arr){
            if (map.get(i)){
                int tl = 1;
                while (map.containsKey(i + tl))
                    tl++;
                if (tl > ml){
                    msp = i;
                    ml = tl;
                }
            }
        }
        for (int i = 0; i < ml; i++)
            System.out.println(msp + i);
    }

    // Heaps ~ Priority Queues
    public static void findKLargestElements(int @NotNull [] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++){
            if (i < k)
                pq.add(arr[i]);
            else {
                if (arr[i] > pq.peek()) {
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }
        while (pq.size() > 0)
            System.out.println(pq.remove());
    }
    public static void sortNearlySortedArray(int[] arr,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i <=k; i++){
            pq.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++){
            System.out.println(pq.remove());
            pq.add(arr[i]);
        }
        while (pq.size() > 0){
            System.out.println(pq.remove());
        }
    }





    public static void main(String[] args){
        String s = "zmszeqxllzvheqwrofgcuntypejcxovtaqbnqyqlmrwitc";
//        System.out.println(highestFrequencyCharacter(s));
        int[] arr1 = {9,5,5,9,8,5,5,8,0,3,1,8,9,7,1,0,6,5,9,1,1,8,2,4,2,9,1,5};
        int[] arr2 = {9,0,3,5,8};
//        getCommonElements(arr1, arr2);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] ranks = {9,0,3,5,8};
        for (int i : ranks)
            pq.add(i);
        while (pq.size() > 0) {
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
