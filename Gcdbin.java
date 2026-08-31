import java.util.*;
import java.io.*;
public class Gcdbin{
    public static int eGcd(int a , int b){
        int shift = 0;
        while(a%2==0 && b%2==0){
            a= a/2;
            b=b/2;
            shift++;
        }
        while(a%2==0){
            a= a/2;            
        }
        while(b%2==0){
            b= b/2;            
        }
        while(a!=b){
            if(a>b){
               a= (a-b)/2;
            }
            else{
               b= (b-a)/2;
            }
            while(a%2==0){
            a= a/2;            
        }
        while(b%2==0){
            b= b/2;            
        }
            
        }
        return a*(int)Math.pow(2,shift); // a<<shift;
        
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


/* 
1100--0110--X--
1010--0101--X--



*/

