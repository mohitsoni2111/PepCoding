package Hashmap_And_Heaps;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class merge_K_Sorted_Lists {

    public static class Pair implements Comparable<Pair>{
        int listIndex;
        int dataIndex;
        int value;
        Pair(int listIndex, int dataIndex, int value){
            this.listIndex = listIndex;
            this.dataIndex = dataIndex;
            this.value = value;
        }
        public int compareTo(@NotNull Pair o){
            return this.value - o.value;
        }
    }
    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
        ArrayList<Integer> rv = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < lists.size(); i++){
            Pair p = new Pair(i, 0, lists.get(i).get(0));
            pq.add(p);
        }
        while (pq.size() > 0){
            Pair p = pq.remove();
            rv.add(p.value);
            p.dataIndex++;
            if (p.dataIndex < lists.get(p.listIndex).size()){
                p.value = lists.get(p.listIndex).get(p.dataIndex);
                pq.add(p);
            }
        }
        return rv;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < k; i++){
            ArrayList<Integer> list = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                list.add(Integer.parseInt(elements[j]));
            }

            lists.add(list);
        }

        ArrayList<Integer> mlist = mergeKSortedLists(lists);
        for(int val: mlist){
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
