package Hashmap.CountTriplets;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {


        if (r == 1) {
            return CombinationFormula(Long.valueOf(arr.size()), Long.valueOf(3));
        }

        long count = 0;
        HashMap<Long, Long> hashmap = new HashMap<>();
        int size = arr.size();
        for (int i = size - 1; i > -1; i--) {
            long positionNum = arr.get(i);
            if(!checkPow(r,positionNum)){
                continue;
            }
            long nextNumOne = positionNum * r;
            long nextNumTwo = positionNum * r * r;

            if (hashmap.containsKey(nextNumOne) && hashmap.containsKey(nextNumTwo)) {
                long valueOne = hashmap.get(nextNumOne);
                long valueTwo = hashmap.get(nextNumTwo);
                count += valueOne * valueTwo;
            }

            long exists = hashmap.computeIfAbsent(positionNum, key -> Long.valueOf(0));
            hashmap.put(positionNum, exists + 1);
        }

        //System.out.println(hashmap);
        return count;
    }

    private static boolean checkPow(long r, long l) {
        if (l == 1)
            return true;
        if (l == r)
            return true;
        if (l % r != 0)
            return false;

        Long d = l;

        while (d != 1) {
            if (d % r != 0)
                return false;
            d = d / r;
            if (d - r == 0)
                return true;
            else if (d < r)
                return false;
        }
        return true;
    }

    // math formula
    private static Long CombinationFormula(Long n, Long k) {
        Long a = Long.valueOf(1);
        Long b = Long.valueOf(1);
        if (k > n / 2) {
            k = n - k;
        }
        for (int i = 1; i <= k; i++) {
            a *= (n + 1 - i);
            b *= i;
        }
        return a / b;
    }


    public static void main(String[] args) throws IOException {

        String path = Solution.class.getResource("fileIn").getPath();
        File doc = new File(path);
        Scanner sc = new Scanner(doc);

        String A = sc.nextLine();
        String B = sc.nextLine();
        String[] nr = A.replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(nr[0]);
        long r = Long.parseLong(nr[1]);
        List<Long> arr = Stream.of(B.replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());
        long ans = countTriplets(arr, r);
        System.out.println("ans=" + ans);

    }
}
