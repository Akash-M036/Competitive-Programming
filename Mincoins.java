import java.io.*;
import java.util.*;

public class Mincoins {
    public static int minden(int n,List<Integer> coins,int[] dp){
        if(n==0)
            return 0;
        if(n<0)
            return Integer.MAX_VALUE;
        if(dp[n]!=-1)
            return dp[n];
        int ans = Integer.MAX_VALUE;
        for(int i =0; i<coins.size();i++){
            int a = coins.get(i);
            int temp = minden(n-a,coins,dp);
            if(temp!=Integer.MAX_VALUE)
                ans = Math.min(ans,1+temp);
        }
        return dp[n]= ans;
    }
    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        List<Integer> coins = new ArrayList<>();
        while(st.hasMoreTokens()){
            coins.add(Integer.parseInt(st.nextToken()));
        }
        if(n==0){
              System.out.println(0);
        return;
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int pri = minden(n,coins,dp);
        if(pri==Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(pri);
    }
}
