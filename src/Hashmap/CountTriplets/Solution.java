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
        HashMap<Long,Integer> hashmap = new HashMap<>();
        for(long num:arr){
            int value = hashmap.computeIfAbsent(num,key->0);
            hashmap.put(num,value+1);
        }
        System.out.println(hashmap);
        //System.out.println(hashmap.size());
        Set<Long> set = hashmap.keySet();
        ArrayList<Long> sortList = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(Long l:set){
            sortList.add(l);
        }
        Collections.sort(sortList,new LongComparator());
        Iterator<Long> it = sortList.iterator();
        while (it.hasNext()){
            Long num = it.next();
            System.out.println(num);
            arrayList.add(hashmap.get(num));
        }
        int count = 0;
        if(arrayList.size()<3) {
            arrayList.add(1);
            arrayList.add(1);
        }
        for(int i=0;i<arrayList.size()-2;i++){

            int one =  arrayList.get(i);
            int two =  arrayList.get(i+1);
            int three =  arrayList.get(i+2);
            count+= one * two * three;
        }

        return count;
    }

    static class LongComparator implements Comparator<Long>
    {
        public int compare(Long a, Long b)
        {
            return Long.compare(a,b);
        }
    }

    public static void main(String[] args) throws IOException {
        String A ="100 1";
        String B= "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1";
        String[] nr =A.replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(nr[0]);
        long r = Long.parseLong(nr[1]);
        List<Long> arr = Stream.of(B.replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());
        long ans = countTriplets(arr, r);
        System.out.println("ans="+ans);

    }
}
