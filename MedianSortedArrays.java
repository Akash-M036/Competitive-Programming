
       /*
       1 5 11
       2 6  7 10 19   
       1 2 5 6 7 10 11 19 ->6.5    
       */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MedianSortedArrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }
        int left = 0;
        int right = 0;
        int current = 0;
        int prev = 0;
        int total = n + m;
        int target = total / 2;
        while ((left + right) <= target) {
            prev = current;
            if (left < n && (right >= m || arr1[left] <= arr2[right])) {
                current = arr1[left];
                left++;
            } 
            else {
                current = arr2[right];
                right++;
            }
        }
        if (total % 2 != 0) {
            System.out.println((double) current);
        } else {
            System.out.println((prev + current) / 2.0);
        }
    }
}
