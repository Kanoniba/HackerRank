package Arrays.Left.Rotation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

//INPUT
// 5 4
// 1 2 3 4 5
// -> 5 1 2 3 4


    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Write your code here

        Queue<Integer> queue = new LinkedList<>(a);
        int length = a.size();
        int mod = d % length ;
        //System.out.printf("d="+d+" mod:"+mod+" length:"+length);
        //System.out.printf(queue.toString());

        for(int i=0;i<mod ;i++){
            int p = queue.poll();
            //System.out.printf("queue:"+p);
            queue.add(p);
        }
       // System.out.printf(queue.toString());

        List list = new ArrayList<Integer>(queue);
        return list;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aTemp[i]);
            a.add(aItem);
        }

        List<Integer> result = Result.rotLeft(a, d);
        System.out.printf(result.toString());
//        for (int i = 0; i < result.size(); i++) {
//            bufferedWriter.write(String.valueOf(result.get(i)));
//
//            if (i != result.size() - 1) {
//                bufferedWriter.write(" ");
//            }
//        }
//
//        bufferedWriter.newLine();


        //bufferedWriter.close();
        bufferedReader.close();
    }
}
