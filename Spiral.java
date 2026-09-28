import java.util.*;

public class Spiral {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        Solution sol = new Solution();
        List<Integer> result = sol.spiralOrder(n, m, matrix);
        System.out.println(result);
        sc.close();
    }
}

class Solution {
    int[] mrow = {0, 1, 0, -1};
    int[] mcol = {1, 0, -1, 0};
    List<Integer> ans = new ArrayList<>();
    public int k = 0;

    public void move(int i, int j, int[][] mat, boolean[][] vis) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[i].length) {
            k = (k + 1) % 4;
            return;
        }
        if (vis[i][j]) {
            k = (k + 1) % 4;
            return;
        }
        vis[i][j] = true;
        ans.add(mat[i][j]);
        move(i + mrow[k], j + mcol[k], mat, vis);
        move(i + mrow[k], j + mcol[k], mat, vis);
    }

    public List<Integer> spiralOrder(int n, int m, int[][] matrix) {
        boolean[][] vis = new boolean[n][m];
        move(0, 0, matrix, vis);
        return ans;
    }
}
