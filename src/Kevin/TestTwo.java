package Kevin;

import java.util.ArrayList;
import java.util.List;

public class TestTwo {

    public static void main(String[] arg) {
        List<Integer> arr;
        arr = new ArrayList<>();
        arr.add(50);
        arr.add(50);
        System.out.println(minPenalty(arr));
    }

    public static int minPenalty(List<Integer> arr) {
        List<Integer> primeList = new ArrayList<>();
        List<Integer> nonPrimeList = new ArrayList<>();
        for (Integer i : arr) {
            if (isPrime(i)) {
                primeList.add(i);
            }   else {
                nonPrimeList.add(i);
            }
        }
        if (primeList.size() == nonPrimeList.size() ||
        Math.abs(primeList.size() - nonPrimeList.size()) == 1) {
            return 0;
        }

        if (primeList.size() > nonPrimeList.size()) {
            return getMin(primeList, primeList.size() - (nonPrimeList.size() + 1));
        }

        return getMin(nonPrimeList, nonPrimeList.size() - (primeList.size() + 1));
    }

    private static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int getMin(List<Integer> list, int n) {
        List<Integer> temp = new ArrayList<>(list);
        List<Integer> res = new ArrayList<>();

        while (res.size() < n) {
            int min = -1;
            int pos = 0;
            for (int i = 0 ;i<temp.size(); i++) {
                if (min == -1 || min > temp.get(i)) {
                    min = temp.get(i);
                    pos = i;
                }
            }
            res.add(min);
            temp.remove(pos);
        }
        int sum = 0;
        for (Integer i : res) {
            sum += i;
        }
        return sum;
    }
}
