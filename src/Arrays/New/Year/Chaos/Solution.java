package Arrays.New.Year.Chaos;

import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        // find after 2 position ,if num big than it , +1 or 2
        int length = q.size();
        int sum = 0;
        int nowNum = 0;
        for (int i = 0; i < length; i++) {
            nowNum = q.get(i);
            int d = nowNum - i - 1;
            if (d > 2) {
                System.out.println("Too chaotic");
                return;
            } else if (nowNum < i + 2) {
                for (int j = i - 1; j >= nowNum - 2 && j > -1; j--) {
                    if (q.get(j) > nowNum)
                        sum++;
                }
            }
        }
        System.out.println(sum);
    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int t = Integer.parseInt(bufferedReader.readLine().trim());

            for (int tItr = 0; tItr < t; tItr++) {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                String[] qTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                List<Integer> q = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    int qItem = Integer.parseInt(qTemp[i]);
                    q.add(qItem);
                }

                Result.minimumBribes(q);
            }

            bufferedReader.close();
        }
    }
}

