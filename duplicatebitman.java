
import java.io.*;
import java.util.*;

public class duplicatebitman {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String valid = sc.nextLine();
        HashMap<Character,Integer> map = new HashMap<>();
        int vis = 0;
        for(char ch : valid.toCharArray()){
            int val = ch-'a';
            if((vis & (1<<val)) == 0 ){
                vis = (vis | (1<<val));
                continue;
            }
            else{
                map.put(ch,map.getOrDefault(ch,0)+1);
            }
        }
          for(char ch : valid.toCharArray()){
            if(map.getOrDefault(ch,0)!=0){
                System.out.print(ch+" ");
                map.put(ch,0);
            }
          }
    }
}
