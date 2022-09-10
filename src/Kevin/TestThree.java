package Kevin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestThree {

    public static void main(String[] arg) {
        Integer[] starting;
        Integer[] ending;

        starting = new Integer[] {5, 2, 3, 7};
        ending = new Integer[]   {7, 2, 4, 8};
        System.out.print("Answer: 2, output: ");
        System.out.println(getThreeNonOverlappingIntervals(Arrays.asList(starting), Arrays.asList(ending)));

        starting = new Integer[] {1, 2, 4, 3, 7};
        ending = new Integer[]   {3, 4, 6, 5, 8};
        System.out.print("Answer: 1, output: ");
        System.out.println(getThreeNonOverlappingIntervals(Arrays.asList(starting), Arrays.asList(ending)));
    }

    public static long getThreeNonOverlappingIntervals(List<Integer> starting, List<Integer> ending) {
        long res = 0;
        List<List<Integer>> listNumbers = getIntervals(starting, ending);
        for (int i = 0; i < listNumbers.size(); i++) {
            if (!isContent(i, listNumbers)) {
                res++;
            }
        }
        return res;
    }

    private static boolean isContent(int pos, List<List<Integer>> listIntervals) {
        List<Integer> intervals = listIntervals.get(pos);
        for (int i = 0; i < listIntervals.size(); i++) {
            if (i == pos) {
                continue;
            }
            List<Integer> temp = listIntervals.get(i);
            if (temp.get(0) <= intervals.get(0) && intervals.get(0) <= temp.get(1) ||
                    temp.get(0) <= intervals.get(1) && intervals.get(1) <= temp.get(1)) {
                return true;
            }
        }
        return false;
    }

    private static List<List<Integer>> getIntervals(List<Integer> starting, List<Integer> ending) {
        List<List<Integer>> listIntervals = new ArrayList<>();
        for (int i = 0; i < starting.size(); i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(starting.get(i));
            temp.add(ending.get(i));
            listIntervals.add(temp);
        }
        return listIntervals;
    }
}
