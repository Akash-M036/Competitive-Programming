
import java.io.*;
import java.util.*;

public class findtriplets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        Arrays.sort(arr);
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int target = x - arr[i] - arr[r];
                if (arr[l] == target) {
                    System.out.println(arr[i] + " " + arr[l] + " " + arr[r]);
                    while (l < r && arr[l] == arr[l + 1]) l++;
                    while (l < r && arr[r] == arr[r - 1]) r--;
                    l++;
                    r--;
                } else if (arr[l] < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
    }
}
