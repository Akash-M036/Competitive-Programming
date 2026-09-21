import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getWays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. LONG_INTEGER_ARRAY c
     */

    public static long getWays(int idx,int n, List<Long> c,long[][] dp) {
       if(n==0)
        return 1;
        if(n<0)
        return 0;
        if(dp[idx][n]!=-1)
            return dp[idx][n];
        long ans =0;
        for(int i =idx;i<c.size();i++){
            long a = c.get(i);
            ans=ans+getWays(i,n-(int)a,c,dp);
        }
       // System.out.println(n+" "+ans);
        return dp[idx][n] =ans;
    }

}

public class Cointimes {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long[][] dp = new long[c.size()+1][n+1];
        for(long[] r : dp)
        Arrays.fill(r,-1);
        long ways = Result.getWays(0,n, c,dp);

        bufferedWriter.write(String.valueOf(ways));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
