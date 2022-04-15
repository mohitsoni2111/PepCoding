package Hashmap_And_Heaps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Write_Priority_Queue_Using_Heap {
    public static class PriorityQueue {
        ArrayList<Integer> data;
        public PriorityQueue() {
            data = new ArrayList<>();
        }

        private void swap(int i, int j) {
            int ith = data.get(i);
            int jth = data.get(j);
            data.set(i, jth);
            data.set(j, ith);
        }

        private void upHeapify(int i) {
            if (i == 0) return;

            int parentIndex = (i - 1) / 2;
            if (data.get(i) < data.get(parentIndex)){
                swap(i , parentIndex);
                upHeapify(parentIndex);
            }
        }

        public void add(int val) {
            data.add(val);
            upHeapify(data.size() - 1);
        }

        private void downHeapify(int parentIndex) {
            int mini = parentIndex;
            int leftIndex = 2 * parentIndex + 1;
            if (leftIndex < data.size() && data.get(leftIndex) < data.get(mini))
                mini = leftIndex;
            int rightIndex = 2 * parentIndex + 2;
            if (rightIndex < data.size() && data.get(rightIndex) < data.get(mini))
                mini = leftIndex;

            if (mini != parentIndex) {
                swap(parentIndex, mini);
                downHeapify(mini);
            }
        }

        public int remove() {
            if (this.size() == 0){
                System.out.println("UnderFlow");
                return -1;
            }
            swap(0, data.size() - 1);
            int val = data.remove(data.size() - 1);
            downHeapify(0);
            return val;
        }

        public int peek() {
            if (this.size() == 0){
                System.out.println("UnderFlow");
                return -1;
            }
            return data.get(0);
        }

        public int size() {
            return data.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue qu = new PriorityQueue();

        String str = br.readLine();
        while (!str.equals("quit")) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}
