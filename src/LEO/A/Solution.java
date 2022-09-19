package LEO.A;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    public static void countOfDistinctIntegers(Set<Integer> set, int n) {

        for (int i = 1; i <= n; i++) {
            int divided = n - i;
            if (n % i == 1 && !set.contains(divided)) {
                set.add(divided);
                countOfDistinctIntegers(set, divided);
            }
            if (i == n) {
                set.add(n);
            }
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        String path = Solution.class.getResource("Input").getPath();
        File doc = new File(path);
        Scanner bufferedReader = new Scanner(doc);

        String[] firstMultipleInput = bufferedReader.nextLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> ar = Stream.of(bufferedReader.nextLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Set<Integer> set = new HashSet<Integer>();
        Result.countOfDistinctIntegers(set, 7);
        int result = set.size();

        System.out.println(String.valueOf(result));

    }
}
