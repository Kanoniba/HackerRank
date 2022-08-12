package Hashmap.FrequencyQueries;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int n = queries.size();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int cmd = queries.get(i).get(0);
            int num = queries.get(i).get(1);

            // cmd 1 - insert
            if (cmd == 1) {
                int value = map.computeIfAbsent(num, key -> 0);
                map.put(num, value + 1);
                max = Math.max(max, value + 1);
            }
            // cmd 2 - insert
            else if (cmd == 2) {
                int value = map.computeIfAbsent(num, key -> 1);
                if (value > 0) {
                    map.put(num, value - 1);
                    max = Math.max(max, value - 1);
                }
            }
            // cmd 3 - check
            else {

                if (max < num)
                    ans.add(0);
                else {
                    boolean[] valid = {false};
                    map.forEach((k, v) -> {
                        if (v == num) {
                            valid[0] = true;
                        }
                    });
                    int out = valid[0] ? 1 : 0;
                    ans.add(out);
                }
            }

        }//System.out.println("q" + queries);
        // System.out.println("m" + map);

        return ans;
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String path = Solution.class.getResource("Input").getPath();

        File doc = new File(path);
        Scanner sc = new Scanner(doc);

        int q = sc.nextInt();
        sc.nextLine();

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(sc.nextLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);
        System.out.println("ans:" + ans);
//        bufferedWriter.write(
//                ans.stream()
//                        .map(Object::toString)
//                        .collect(joining("\n"))
//                        + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
