import java.util.*;

public class Spiral {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] a = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();

        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;

        while (top <= bottom && left <= right) {

            for (int j = left; j <= right; j++)
                System.out.print(a[top][j] + " ");
            top++;

            for (int i = top; i <= bottom; i++)
                System.out.print(a[i][right] + " ");
            right--;

            if (top <= bottom) {
                for (int j = right; j >= left; j--)
                    System.out.print(a[bottom][j] + " ");
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    System.out.print(a[i][left] + " ");
                left++;
            }
        }
    }
}
