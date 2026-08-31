import java.util.*;
import java.io.*;
public class Euclid{
    public static int eGcd(int a , int b){
    if(b==0)
        return a;
      return eGcd(b,a%b);
    }
    static int t1=0;
    static int t2=1;
    static int s1=1;
    static int s2=0;
    public static void findxy(int a , int b){
        if(b==0)
            return ;
        int t = t1-t2*(a/b);
        int s = s1-s2*(a/b);
        t1=t2;
        t2=t;
        s1=s2;
        s2 =s;
        findxy(b,a%b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enteer A:");
        int a = Integer.parseInt(br.readLine());
        System.out.println("Enteer B:");
        int b = Integer.parseInt(br.readLine());
        findxy(a,b);
        System.out.println("X of "+s1);
        System.out.println("Y of "+t1);
        
        
    }
    
}

/*
    4x+6y=2;
    4,6
    6,4-- 6*0+4
    4,2-- 4*1+2----->6=4+2------->
    2,0--2*2+0
    
    
    
    

*/
