import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CountingSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[100];
        for(int i =0; i<n;i++){
            int inp = sc.nextInt();
            arr[inp]=arr[inp]+1;
        }
        int[] result = new int[n];
        int k=0;
        int i =0;
        while(k<100){
        while(i<n){
            if(arr[k]==0)
                break;
            result[i]=k;
            arr[k]--;
            i++;
        }
            k++;
        }
        for( i=0; i<n;i++){
            System.out.print(result[i]+" ");
        }
    }
}