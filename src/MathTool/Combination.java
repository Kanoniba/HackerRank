// 組合法 Cn 取 r
package MathTool;

import java.util.Scanner;

public class Combination {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        System.out.println(Combination(n,k));
        System.out.println(CombinationFormula(n, k));
    }

    // math formula
    private static int CombinationFormula(int n, int k) {
        int a=1,b=1;
        if(k>n/2) {
            k=n-k;
        }
        for(int i=1;i<=k;i++) {
            a*=(n+1-i);
            b*=i;
        }
        return a/b;
    }

    // loop
    private static int Combination(int n, int k) {
        if(k==0||k==n)
            return 1;
        else
            return Combination(n-1, k)+Combination(n-1, k-1);
    }



}
