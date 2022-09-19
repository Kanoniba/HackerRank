package LEO.B;

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
     * Complete the 'requestsServed' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY timestamp
     *  2. INTEGER_ARRAY top
     */

    public static int requestsServed(List<Integer> timestamp, List<Integer> top) {
        // Write your code here


        Collections.sort(timestamp);
        Collections.sort(top);

        System.out.println(timestamp);
        System.out.println(top);

        int count = 0;
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> end_queue = new LinkedList<>();
        for (int i = 0; i < top.size(); i++) {
            int nowTop = top.get(i);

            //add to statck and queuq
            for (int j = 0; j < timestamp.size(); j++) {
                int compare = timestamp.get(j);

                if (nowTop >= compare) {
                    stack.push(compare);
                }
                else {
                    end_queue.offer(compare);
                }
            }
            //
            System.out.println("S1:" + stack);
            System.out.println("Q1:" + end_queue);
            int breakCount = 0;
            while (!stack.empty() && breakCount < 5) {
                stack.pop();
                count++;
                breakCount++;
            }

            System.out.println("S2:" + stack);
            System.out.println("Q2:" + end_queue);
            // back to array list
            timestamp = new ArrayList<>();

            while (!stack.empty()) {
                timestamp.add(stack.pop());
            }
            while (!end_queue.isEmpty()) {
                timestamp.add(end_queue.poll());
            }

            System.out.println("A:" + timestamp);


        }

        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        String path = Solution.class.getResource("Input").getPath();
        File doc = new File(path);
        Scanner bufferedReader = new Scanner(doc);

        int timestampCount = Integer.parseInt(bufferedReader.nextLine().trim());

        List<Integer> timestamp = IntStream.range(0, timestampCount).mapToObj(i -> {

                    return bufferedReader.nextLine().replaceAll("\\s+$", "");

                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int topCount = Integer.parseInt(bufferedReader.nextLine().trim());

        List<Integer> top = IntStream.range(0, topCount).mapToObj(i -> {

                    return bufferedReader.nextLine().replaceAll("\\s+$", "");

                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.requestsServed(timestamp, top);
        System.out.println(result);

    }
}