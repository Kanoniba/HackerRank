import Hashmap.CountTriplets.Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInput {
    public static void main(String[] args) throws FileNotFoundException {

        String path = Solution.class.getResource("Input").getPath();
        File doc = new File(path);
        Scanner sc = new Scanner(doc);

        String A = sc.nextLine();
        String B = sc.nextLine();

    }
}
