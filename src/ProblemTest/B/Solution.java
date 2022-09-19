package ProblemTest.B;

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
     * Complete the 'filledOrders' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY order
     *  2. INTEGER k
     */

    public static int filledOrders(List<Integer> order, int k) {
        // Write your code here
        int count = 0;

        Collections.sort(order);
        System.out.println(order);
        for (int i = 0; i < order.size(); i++) {
            if (k >= order.get(i)) {
                count++;
                k-=order.get(i);
            }
        }

        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        String path = Solution.class.getResource("Input").getPath();
        File doc = new File(path);
        Scanner bufferedReader = new Scanner(doc);

        int orderCount = Integer.parseInt(bufferedReader.nextLine().trim());

        List<Integer> order = IntStream.range(0, orderCount).mapToObj(i -> {

                    return bufferedReader.nextLine().replaceAll("\\s+$", "");

                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int k = Integer.parseInt(bufferedReader.nextLine().trim());
        int result = Result.filledOrders(order, k);
        System.out.println(result);

    }
}
