package Trie;

import java.util.HashMap;
import java.util.Map;

public class Design_File_System1166 {
    class TrieNode{
        Map<String, TrieNode> childrenMap = new HashMap<>();
        String name;
        int value;

        TrieNode(String name){
            this.name = name;
        }
    }


    class FileSystem {
        TrieNode root;

        public FileSystem() {
            root = new TrieNode("");
        }

        public boolean createPath(String path, int value) {
            // Obtain all the components
            String[] stringArray = path.split("/");

            TrieNode current = root;
            for (int i = 1; i < stringArray.length; i++){
                String str  = stringArray[i];

                if (!current.childrenMap.containsKey(str)){
                    if (i == stringArray.length - 1){
                        current.childrenMap.put(str, new TrieNode(str));
                    } else {
                        return false;
                    }
                }
                current = current.childrenMap.get(str);
            }
            if (current.value != 0){
                return false;
            }
            current.value = value;
            return true;

        }

        public int get(String path) {
            TrieNode current = root;

            String[] stringArray = path.split("/");
            for (int i = 1; i < stringArray.length; i++){
                String str = stringArray[i];
                if (!current.childrenMap.containsKey(str)){
                    return -1;
                }
                current = current.childrenMap.get(str);
            }
            return current.value;
        }
    }
}
