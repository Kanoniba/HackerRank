package Hashmap.HashTables.RansomNote;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {
        // Write your code here
        HashMap<Character,Integer> hash_magz = parse(magazine);
        HashMap<Character,Integer> hash_note = parse(note);
        System.out.println(hash_magz.toString());
        System.out.println(hash_note.toString());
        Set<Character> set_character = hash_note.keySet();
        Iterator<Character> it = set_character.iterator();
        while(it.hasNext()){
            char c = it.next();
            int n_times = hash_note.get(c);
            int m_times = hash_magz.computeIfAbsent(c,key-> 0);
            if(n_times > m_times)
            {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

    public static HashMap<Character,Integer> parse(List<String> source){
        HashMap<Character,Integer> hash = new HashMap<>();
        for(String s: source){
            for(char c : s.toCharArray()){
               int times =  hash.computeIfAbsent(c,key-> 0);
               hash.put(c,times+1);
            }
        }
        return hash;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "));

        List<String> note = Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "));

        Result.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}
