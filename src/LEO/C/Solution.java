package LEO.C;

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
     * Complete the 'validateAddresses' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY addresses as parameter.
     */

    public static List<String> validateAddresses(List<String> addresses) {
        // Write your code here
        boolean isIP4 = false;
        boolean isIP6 = false;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < addresses.size(); i++) {
            isIP6 = validIP6(addresses.get(i));
            isIP4 = validIP4(addresses.get(i));
            if (isIP6)
                result.add("IPv6");
            else if (isIP4)
                result.add("IPv4");
            else
                result.add("Neither");

        }
        return result;
    }

    public static boolean validIP4(String ip) {
        Pattern PATTERN = Pattern.compile(
                "\\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b");
        boolean pass = PATTERN.matcher(ip).matches();
        if (pass)
            return validIP4_power(ip);
        else
            return false;
    }

    public static boolean validIP4_power(String ip) {
        String[] split = ip.split("\\.");

        for (int i = 0; i < split.length; i++) {
            if(split[i].length()>2) {
                char hun = split[i].charAt(0);
                char ten = split[i].charAt(1);
                if (hun == '0' || ten == '0') {
                    int value = Integer.valueOf(split[i]);
                    if (value > 7)
                        return false;
                }
            }
            else if(split[i].length()>1) {
                char hun = split[i].charAt(0);
                if (hun == '0') {
                    int value = Integer.valueOf(split[i]);
                    if (value > 7)
                        return false;
                }
            }

        }
        return true;
    }


    public static boolean validIP6(String ip) {
        Pattern PATTERN_a = Pattern
                .compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");

        Pattern PATTERN_b = Pattern
                .compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

        return PATTERN_a.matcher(ip).matches() || PATTERN_b.matcher(ip).matches();

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        String path = Solution.class.getResource("Input").getPath();
        File doc = new File(path);
        Scanner bufferedReader = new Scanner(doc);


        int addressesCount = Integer.parseInt(bufferedReader.nextLine().trim());

        List<String> addresses = IntStream.range(0, addressesCount).mapToObj(i -> {

                    return bufferedReader.nextLine();

                })
                .collect(toList());

        List<String> result = Result.validateAddresses(addresses);
        System.out.println(result);

    }
}