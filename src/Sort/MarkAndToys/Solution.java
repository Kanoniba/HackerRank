package Sort.MarkAndToys;

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
     * Complete the 'maximumToys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY prices
     *  2. INTEGER k
     */

    public static int maximumToys(List<Integer> prices, int k) {
        // Write your code here
        int nums = prices.size();
        int count = 0;
        //insert sort
        for (int i = 0; i < nums; i++) {
            for (int j = i+1; j < nums; j++) {
                if (prices.get(i) > prices.get(j)) {
                    //swap
                    int temp = prices.get(i);
                    prices.set(i, prices.get(j));
                    prices.set(j, temp);
                }
            }
            k -= prices.get(i);
            if(k > -1){
                count++;
            }
            else
                return count ;
        }
        return count ;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        String path = Solution.class.getResource("Input").getPath();
        File doc = new File(path);
        Scanner sc = new Scanner(doc);

        String[] firstMultipleInput = sc.nextLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> prices = Stream.of(sc.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.maximumToys(prices, k);

        System.out.println(result);
    }
}
