package B;

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


class Result {

    /*
     * Complete the 'getMinimumCost' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static long getMinimumCost(List<Integer> arr) {
        // Write your code here
        System.out.println(arr);
        int maxDiff = -999;
        int index = 0;
        for (int i = 0; i < arr.size() - 1; i++) {
            int absD = Math.abs(arr.get(i) - arr.get(i + 1));
            if (maxDiff < absD)
            {
                maxDiff = absD;
                index = i;
            }
        }
        int a = arr.get(index);
        int b = arr.get(index + 1);
        int newNum = a + b / 2;
        if (a + b % 2 != 0) newNum++;

        long sum = 0;
        System.out.println("index = " + index + " maxDiff="+maxDiff);
        List<Integer> newList = new ArrayList<Integer>();
        for (int i = 0; i < arr.size() - 1; i++) {

            if (i == index) {
                newList.add(arr.get(i));
                newList.add(newNum);
            } else {

                newList.add(arr.get(i));
            }
        }
        newList.add(arr.get(arr.size() - 1));
        System.out.println(newList);


        for (int i = 0; i < newList.size() - 1; i++) {
            int abs = newList.get(i) - newList.get(i + 1);
            sum += abs * abs;
        }


        return sum;
        // System.out.println("i:"+index +" diff:"+maxDiff);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        String path = Solution.class.getResource("Input").getPath();
        File doc = new File(path);
        Scanner bufferedReader = new Scanner(doc);

        int arrCount = Integer.parseInt(bufferedReader.nextLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {

                    return bufferedReader.nextLine().replaceAll("\\s+$", "");

                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        long result = Result.getMinimumCost(arr);

        System.out.println(result);
    }
}
