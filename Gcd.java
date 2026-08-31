import java.util.*;
import java.io.*;
public class Gcd{
    public static int eGcd(int a , int b){
    if(b==0)
        return a;
      return eGcd(b,a%b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enteer A:");
        int a = Integer.parseInt(br.readLine());
        System.out.println("Enteer B:");
        int b = Integer.parseInt(br.readLine());
        System.out.println("GCD of "+a+","+b+":"+eGcd(a,b));
        
    }
    
}
