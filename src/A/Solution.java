package A;

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
     * Complete the 'slotWheels' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY history as parameter.
     */

    public static int slotWheels(List<String> history) {
        int n = history.size();
        int k = history.get(0).length();
        ArrayList<Integer>[] arrayLists = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            arrayLists[i] = new ArrayList<Integer>();
            char[] chars = history.get(i).toCharArray();
            for (int j = 0; j < k; j++) {
                arrayLists[i].add(Integer.valueOf(chars[j]) - 48);
            }

            Collections.sort(arrayLists[i], Collections.reverseOrder());
            System.out.println(arrayLists[i]);

        }
        int count = 0;
        int length = arrayLists[0].size();
        for (int i = 0; i < length ; i++) {
            int max = -1;
            for (int j = 0; j < length ; j++) {
                int a = arrayLists[j].get(i);
                max = Math.max(a, max);
                //System.out.println("b:" + max);
            }
            count+= max;
            System.out.println("big:" + max);
        }


       // System.out.println(history);
        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

        String path = Solution.class.getResource("Input").getPath();
        File doc = new File(path);
        Scanner bufferedReader = new Scanner(doc);
        int historyCount = Integer.parseInt(bufferedReader.nextLine().trim());

        List<String> history = IntStream.range(0, historyCount).mapToObj(i -> {

                    return bufferedReader.nextLine();

                })
                .collect(toList());

        int result = Result.slotWheels(history);
        System.out.println(result);


    }
}
