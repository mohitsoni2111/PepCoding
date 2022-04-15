package Hashmap_And_Heaps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Hashmap {
    public static class HashMap<K, V> {
        private class HMNode {
            K key;
            V value;

            HMNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size; // n
        private LinkedList<HMNode>[] buckets; // N = buckets.length

        public HashMap() {
            initbuckets(4);
            size = 0;
        }

        private void initbuckets(int N) {
            buckets = new LinkedList[N];
            for (int bi = 0; bi < buckets.length; bi++) {
                buckets[bi] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hashCode = key.hashCode();
            return Math.abs(hashCode) % buckets.length;
        }

        private int getIndexWithinBucket(K key, int bucketIndex) {
            int dataIndex = 0;
            for (HMNode node : buckets[bucketIndex]){
                if (node.key.equals(key)){
                    return dataIndex;
                }
                dataIndex++;
            }
            return -1;
        }

        private void rehash() throws Exception {
            LinkedList<HMNode>[] oldBucketArray = buckets;
            initbuckets(oldBucketArray.length * 2);
            size = 0;

            for (LinkedList<HMNode> hmNodes : oldBucketArray) {
                for (HMNode node : hmNodes) {
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) throws Exception {
            int bucketIndex = hashFunction(key);
            int dataIndex = getIndexWithinBucket(key, bucketIndex);

            if (dataIndex != -1){
                HMNode node = buckets[bucketIndex].get(dataIndex);
                node.value = value;
            }
            else {
                HMNode node = new HMNode(key, value);
                buckets[bucketIndex].add(node);
                size++;
            }
            double lambda = size * 1.0 / buckets.length;
            if (lambda > 2.0)
                rehash();
        }

        public V get(K key) throws Exception {
            int bucketIndex = hashFunction(key);
            int dataIndex = getIndexWithinBucket(key, bucketIndex);

            if (dataIndex != -1) {
                HMNode node = buckets[bucketIndex].get(dataIndex);
                return node.value;
            }
            else
                return null;
        }

        public boolean containsKey(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = getIndexWithinBucket(key, bucketIndex);

            return dataIndex != -1;
        }

        public V remove(K key) throws Exception {
            int bucketIndex = hashFunction(key);
            int dataIndex = getIndexWithinBucket(key, bucketIndex);

            if (dataIndex != -1) {
                HMNode node = buckets[bucketIndex].remove(dataIndex);
                size--;
                return node.value;
            }
            else
                return null;
        }

        public ArrayList<K> keyset() {
            ArrayList<K> keys = new ArrayList<>();
            for (LinkedList<HMNode> bucket : buckets) {
                for (HMNode node : bucket) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public int size() {
            return size;
        }

        public void display() {
            System.out.println("Display Begins");
            for (int bi = 0; bi < buckets.length; bi++) {
                System.out.print("Bucket" + bi + " ");
                for (HMNode node : buckets[bi]) {
                    System.out.print( node.key + "@" + node.value + " ");
                }
                System.out.println(".");
            }
            System.out.println("Display Ends");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap();

        String str = br.readLine();
        while (!str.equals("quit")) {
            if (str.startsWith("put")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                Integer val = Integer.parseInt(parts[2]);
                map.put(key, val);
            } else if (str.startsWith("get")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.get(key));
            } else if (str.startsWith("containsKey")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.containsKey(key));
            } else if (str.startsWith("remove")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.remove(key));
            } else if (str.startsWith("size")) {
                System.out.println(map.size());
            } else if (str.startsWith("keyset")) {
                System.out.println(map.keyset());
            } else if (str.startsWith("display")) {
                map.display();
            }
            str = br.readLine();
        }
    }
}
