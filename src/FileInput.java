import Hashmap.CountTriplets.Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInput {
    public static void main(String[] args) throws FileNotFoundException {

        String path = Solution.class.getResource("Input").getPath();
        File doc = new File(path);
        Scanner bufferedReader = new Scanner(doc);

        String A = bufferedReader.nextLine();
        String B = bufferedReader.nextLine();

    }
}
