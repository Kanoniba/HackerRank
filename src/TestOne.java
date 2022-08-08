import java.util.Arrays;
import java.util.List;

public class TestOne {

    public static void main(String[] arg) {
        Integer[] points;
        int threshold;

        threshold = 4;
        points = new Integer[]{1, 2, 3, 5, 8};
        System.out.println(minNum(threshold, Arrays.asList(points)));
    }

    public static int minNum(int threshold, List<Integer> points) {
        int size = points.size();
        int min = -1;
        int minPos = 0;
        int pos = 0;
        for (Integer i : points) {
            if (min == -1 || min > i) {
                min = i;
                minPos = pos;
            }
            pos++;
        }
        int minLen = getStep(points, 0, minPos);
        boolean check = false;
        for (int i = 0; i < size; i++) {
            if (points.get(i) - min >= threshold) {
                minLen += getStep(points, minPos, i);
                check = true;
                break;
            }
        }
        return check ? minLen + 1 : size;
    }

    private static int getStep(List<Integer> points, int startPos, int targetPos) {
        int step = 0;
        int sPos = startPos + 1;
        int tPos = targetPos + 1;
        int pos = tPos - sPos;
        if (pos % 2 != 0) {
            pos--;
            step++;
        }
        return step + (pos / 2);
    }

}
