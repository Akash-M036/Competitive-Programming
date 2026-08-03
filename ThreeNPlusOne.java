
import java.io.*;
import java.util.*;
public class ThreeNPlusOne {
    public static int steps(long l, HashMap<Long,Integer> map){
        if(l==1){
            return 1;
        }
        if(map.containsKey(l)){
            return map.get(l);
        }
        int ans =0;
        if((l&1)==0){
           ans = 1+ steps(l/2,map);
        }
        else
         ans = 1 + steps(3*l+1,map);
         map.put(l,ans);
         return ans;
    }
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int a = sc.nextInt();
         int b = sc.nextInt();
         int maxsteps=1;
         int i , j;
         if(a>=b){
            i=b;
            j=a;
         }
         else
            {
                j=b;
                i=a;
            }
        HashMap<Long,Integer> map = new HashMap<>();
         for(int k =i; k<=j;k++){
            maxsteps = Math.max(maxsteps,steps(1L*k,map));
         }
         System.out.println(i+" "+j+" "+maxsteps);
         
    }
}
