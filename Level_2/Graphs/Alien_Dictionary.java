package Level_2.Graphs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class Alien_Dictionary {
    public static String alienOrder(String[] words) {
        Map<Character, HashSet<Character>> map = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        for(String st : words){
            for(char ch: st.toCharArray()){
                inDegree.put(ch, 0);
            }
        }

        for(int i = 0; i < words.length-1; i++) {
            String curr = words[i];
            String next = words[i + 1];
            boolean flag = false;

            int len = Math.min(curr.length(), next.length());

            for (int j = 0; j < len; j++) {
                char ch1 = curr.charAt(j);
                char ch2 = next.charAt(j);

                if (ch1 != ch2) {
                    HashSet<Character> set = new HashSet<>();
                    if (map.containsKey(ch1)) {
                        set = map.get(ch1);
                        if (!set.contains(ch2)) {
                            set.add(ch2);
                            inDegree.put(ch2, inDegree.get(ch2) + 1);
                            map.put(ch1, set);
                        }
                    } else {
                        set.add(ch2);
                        inDegree.put(ch2, inDegree.get(ch2) + 1);
                        map.put(ch1, set);
                    }
                    flag = true;    // Find the mismatched
                    break;
                }
            }

            if (!flag && curr.length()>next.length()){
                return "";
            }
        }

        LinkedList<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : inDegree.keySet()){
            if (inDegree.get(ch) == 0){
                queue.addLast(ch);
            }
        }

        int count = 0;
        while (!queue.isEmpty()){
            char rem = queue.removeFirst();
            sb.append(rem);
            count++;

            if (map.containsKey(rem)){
                HashSet<Character> nbrs = map.get(rem);

                for (char nbr : nbrs){
                    inDegree.put(nbr, inDegree.get(nbr)-1);

                    if (inDegree.get(nbr) == 0){
                        queue.addLast(nbr);
                    }
                }
            }
        }

        if (count == inDegree.size()){
            return sb.toString();
        } else {
            return "";
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] words = br.readLine().split(" ");

        System.out.println(alienOrder(words));
    }
}
