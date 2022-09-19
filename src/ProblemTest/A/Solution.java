package ProblemTest.A;

import java.io.*;
import java.util.*;


class Result {

    /*
     * Complete the 'decryptPassword' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String decryptPassword(String s) {
        // Write your code here

        char[] chars = s.toCharArray();

        //*
        int dcount = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '0' && Character.isDigit(chars[dcount])) {
                char tmp = chars[dcount];
                chars[dcount] = chars[i];
                chars[i] = tmp;
                dcount++;
            }
        }

        System.out.println(String.valueOf(chars));
        //51Pa*0Lp*0e
        //Pa*1Lp*5e

        for (int i = 0; i < chars.length; i++) {
            if (i > 1 && chars[i] == '*') {
                char low = chars[i - 1];
                char up = chars[i - 2];
                if (Character.isUpperCase(up) && Character.isLowerCase(low)) {
                    char tmp = chars[i - 2];
                    chars[i - 2] = chars[i - 1];
                    chars[i - 1] = tmp;
                }
            }
        }
        String str = String.valueOf(chars);
        str = str.replace("*", "");
        str = str.replace("0", "");
        // 51Pa*0Lp*0e
        // 51aP0pL0e
        //


        return  str;
    }

    public static String swap(String str, int l, int r, int delete) {
        char[] chars = str.toCharArray();
        char tmp = chars[l];
        chars[l] = chars[r];
        chars[r] = tmp;
        return String.valueOf(chars).substring(delete, chars.length);
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {

        String path = Solution.class.getResource("Input").getPath();
        File doc = new File(path);
        Scanner bufferedReader = new Scanner(doc);
        String s = bufferedReader.nextLine();
        String result = Result.decryptPassword(s);
        System.out.println(result);
    }
}
