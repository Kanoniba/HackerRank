// 組合法 Cn 取 r
package MathTool;

import java.util.Scanner;

public class Combination {

    public static void main(String[] args) {

        Long n = Long.valueOf(100000 );
        Long k = Long.valueOf(3);
        // System.out.println(Combination(n,k));
        System.out.println(CombinationFormula(n, k));
    }

    // math formula
    private static Long CombinationFormula(Long n, Long k) {
        Long a = Long.valueOf(1);
        Long b = Long.valueOf(1);
        if (k > n / 2) {
            k = n - k;
        }
        for (int i = 1; i <= k; i++) {
            a *= (n + 1 - i);
            b *= i;
        }
        return a / b;
    }

    // loop
    private static Long Combination(Long n, Long k) {
        if (k == 0 || k == n)
            return Long.valueOf(1);
        else
            return Combination(n - 1, k) + Combination(n - 1, k - 1);
    }


}
