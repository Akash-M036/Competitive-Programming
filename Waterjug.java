import java.io.*;
import java.util.*;

public class Waterjug {
    public static int eGcd(int a , int b){
    if(b==0)
        return a;
      return eGcd(b,a%b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //  System.out.println("Enteer A:");
      StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
      //  System.out.println("Enteer B:");
        int b = Integer.parseInt(st.nextToken());
        int  t = Integer.parseInt(st.nextToken());
        int gcd = eGcd(a,b);
        if(t%gcd==0)
            System.out.print("YES");
        else
            System.out.print("NO");
    }
}
