package Trie;

import java.util.HashMap;
import java.util.Scanner;

public class Maximum_XOR_of_Two_Numbers_in_an_Array_421 {

    class TrieNode{
        HashMap<Character, TrieNode> childrenMap = new HashMap<>();
    }

    public int findMaximumXOR(int[] nums) {
        int maxNum = nums[0];

        for (int num : nums){
            maxNum = Math.max(maxNum, num);
        }

        // length of maximum number in nums[]
        int L = (Integer.toBinaryString(maxNum)).length();

        // zero left padding to ensure L bits for each number
        int n = nums.length, bitmask = 1 << L;
        String[] strNums = new String[n];
        for (int i= 0; i < n; i++){
            strNums[i] = Integer.toBinaryString(bitmask | nums[i]).substring(1);
        }

        TrieNode trie = new TrieNode();
        int max_XOR = 0;
        for (String num : strNums){
            TrieNode node = trie, xor_Node = trie;
            int curr_XOR = 0;

            // Trie Insertion
            for (Character bit : num.toCharArray()){
                if (node.childrenMap.containsKey(bit)){
                    node = node.childrenMap.get(bit);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.childrenMap.put(bit, newNode);
                    node = newNode;
                }

                // compute max xor of that new number
                // with all previously inserted
                Character toggleBit = bit == '1' ? '0' : '1';
                /*
                Try to go down to the opposite bit at each step if it's possible.
                Add 1-bit at the end of current XOR.

                If not, just go down to the same bit.
                Add 0-bit at the end of current XOR.
                 */
                if (xor_Node.childrenMap.containsKey(toggleBit)){
                    curr_XOR = (curr_XOR << 1) | 1;
                    xor_Node = xor_Node.childrenMap.get(toggleBit);
                } else {
                    curr_XOR = (curr_XOR << 1);
                    xor_Node = xor_Node.childrenMap.get(bit);
                }
            }
            max_XOR = Math.max(max_XOR, curr_XOR);

        }
        return max_XOR;
    }
}
