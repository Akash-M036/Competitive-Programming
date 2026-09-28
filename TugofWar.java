import java.util.*;

public class TugofWar {
    static int[] a;
    static int[][][] memo;
    static int n, total;

    static int solve(int i, int count, int sum) {
        if (count == n / 2)
            return Math.abs(total - 2 * sum);

        if (i == n)
            return Integer.MAX_VALUE;

        if (memo[i][count][sum] != -1)
            return memo[i][count][sum];

        int take = solve(i + 1, count + 1, sum + a[i]);
        int skip = solve(i + 1, count, sum);

        return memo[i][count][sum] = Math.min(take, skip);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            total += a[i];
        }

        memo = new int[n][n / 2 + 1][total + 1];

        for (int[][] x : memo)
            for (int[] y : x)
                Arrays.fill(y, -1);

        System.out.println(solve(0, 0, 0));
    }
}