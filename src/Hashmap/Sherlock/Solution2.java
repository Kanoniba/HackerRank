package Hashmap.Sherlock;
import java.io.*;
import java.util.*;

class Result2 {

    //這個解答有問題，一些test過不了~~會有微妙誤差。
    public static int sherlockAndAnagrams(String s) {
        // Write your code here
        ArrayList<String> list = splitSubString(s);
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String subString : list) {
            HashMap<Character, Integer> hm = parse(subString);
            String str;
            str = hm.toString().replace("=", "");
            str = str.replace(" ", "");
            str = str.replace(",", "");
            int exist = hashMap.computeIfAbsent(str, key -> 0);
            hashMap.put(str, exist + 1);
        }
        int total = 0;
        //System.out.println("hashmap:"+hashMap);
        Set<String> set = hashMap.keySet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String next = it.next();
            int value = hashMap.get(next);
            if (value > 1) {
                total += CombinationFormula(value, 2);
                System.out.println(next + "=" + value + " com=" + CombinationFormula(value, 2));
            } else {
                //System.out.println(next+"="+value+" com="+CombinationFormula(value, 2));
            }
        }
        System.out.println("total:" + total);
        return total;
    }

    //split sub Strings
    public static ArrayList<String> splitSubString(String str) {
        int length = str.length();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= i; j--) {
                String sub = (str.substring(i, j + 1));
                if (!sub.equals(""))
                    list.add(sub);
            }
        }
        return list;
    }

    //calculate string hash
    public static HashMap<Character, Integer> parse(String s) {
        HashMap<Character, Integer> hash = new HashMap<>();
        for (char c : s.toCharArray()) {
            int times = hash.computeIfAbsent(c, key -> 0);
            hash.put(c, times + 1);
        }
        return hash;
    }

    // math formula
    private static int CombinationFormula(int n, int k) {
        int a = 1, b = 1;
        if (k > n / 2) {
            k = n - k;
        }
        for (int i = 1; i <= k; i++) {
            a *= (n + 1 - i);
            b *= i;
        }
        return a / b;
    }

}

public class Solution2 {
    public static void main(String[] args) throws IOException {

        int a = Result2.sherlockAndAnagrams("abcdefghijklmnopqrstuvwxyzzzz");
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int q = Integer.parseInt(bufferedReader.readLine().trim());
//
//        IntStream.range(0, q).forEach(qItr -> {
//            try {
//                String s = bufferedReader.readLine();
//
//                int result = Result.sherlockAndAnagrams(s);
//
//                bufferedWriter.write(String.valueOf(result));
//                bufferedWriter.newLine();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
