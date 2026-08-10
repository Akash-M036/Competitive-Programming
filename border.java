import java.io.*;
import java.util.*;

public class border {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String given = sc.nextLine();
        String[] pre = new String[given.length()-1];
        String[] suff = new String[given.length()-1];
        pre[0] = given.charAt(0)+"";
        suff[0] = given.charAt(given.length()-1)+"";
        for(int i =1; i<given.length()-1;i++){
            pre[i]=pre[i-1]+given.charAt(i);
        }
         for(int i =1; i<given.length()-1;i++){
            suff[i]= given.charAt(given.length()-1-i)+suff[i-1];
        }
        // Arrays.sort(pre);
         Arrays.sort(suff);
        // for(int i =given.length()-2; i>=0;i--){
        //     if(pre[i].equals(suff[i])){
        //         System.out.println(pre[i]);
        //         return;
        //     }
        // }
        HashMap<String,Integer> map = new HashMap<>();
        for(int i =0; i<given.length()-1;i++){
            map.put(pre[i],map.getOrDefault(pre[i],0)+1);
        }
        for(int i =given.length()-2; i>=0;i--){
            if(map.containsKey(suff[i])){
                System.out.println(suff[i]);
                return;
            }
    }
    System.out.println("");
}
}
