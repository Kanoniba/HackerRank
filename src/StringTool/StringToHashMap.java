package StringTool;

import java.util.HashMap;

public class StringToHashMap {

    public static void main(String[] args) {
        String str = "abbcccddddeeeee";
        HashMap<Character, Integer> hash = StringToHash(str);
        System.out.println(hash);
        // print {a=1, b=2, c=3, d=4, e=5}
    }

    public static HashMap<Character, Integer> StringToHash(String s) {
        HashMap<Character, Integer> hash = new HashMap<>();
        for (char c : s.toCharArray()) {
            int times = hash.computeIfAbsent(c, key -> 0);
            hash.put(c, times + 1);
        }
        return hash;
    }
}


