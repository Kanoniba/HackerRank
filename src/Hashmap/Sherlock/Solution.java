package Hashmap.Sherlock;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

class Result {


    public static int sherlockAndAnagrams(String s) {
        // Write your code here
        int length = s.length();
        int wordNum = 1;
        int position = 0;
        int count = 0;
        for(wordNum=1;wordNum<length;wordNum++) {
            for (int i = 0; i < length-wordNum; i++) {
                String str = s.substring(i,i+wordNum);
                // System.out.println("str:"+str);
                for(int j=i+1;j<length+1-wordNum;j++){
                    String compareStr = s.substring(j,j+wordNum);
                    if(isAnagram(str,compareStr)){
                        count++;
                    }
                }
            }
        }
        System.out.println("total:"+count);
        return count;
    }

    public static boolean isAnagram(String a,String b){
        HashMap<Character, Integer> hashA = parse(a);
        HashMap<Character, Integer> hashB = parse(b);
        //System.out.println("str1:"+a+ " ,str2:"+b);
        return hashA.equals(hashB);
    }

    public static HashMap<Character, Integer> parse(String s) {
        HashMap<Character, Integer> hash = new HashMap<>();
        for (char c : s.toCharArray()) {
            int times = hash.computeIfAbsent(c, key -> 0);
            hash.put(c, times + 1);
        }
        return hash;
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {

        int a = Result.sherlockAndAnagrams("fdbdidhaiqbggqkhdmqhmemgljaphocpaacdohnokfqmlpmiioedpnjhphmjjnjlpihmpodgkmookedkehfaceklbljcjglncfal");

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
