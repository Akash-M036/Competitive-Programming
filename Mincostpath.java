import java.io.*;
import java.util.*;

public class Mincostpath {
    public static int mincost(int i , int j , List<List<Integer>> arr){
        if(i>=arr.size() || j>=arr.size())
            return Integer.MAX_VALUE;
        if(i== arr.size()-1 && j==arr.size()-1)
            return arr.get(i).get(j);
        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        int diag = Integer.MAX_VALUE;
        int x = mincost(i,j+1,arr);
        int y = mincost(i+1,j,arr);
        int z = mincost(i+1,j+1,arr);
        if(x!=Integer.MAX_VALUE)
            right = arr.get(i).get(j)+x;
        if(y!=Integer.MAX_VALUE)
            down = arr.get(i).get(j)+y;
        if(z!=Integer.MAX_VALUE)
            diag = arr.get(i).get(j)+z;
        return Math.min(Math.min(right,down),diag);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> arr = new ArrayList<>();
        if(sc.hasNextLine()){
            String s = sc.nextLine().trim();
            if(!s.isEmpty()){
                String[] val = s.split("\\s+");
                int n = val.length;
                List<Integer> rowone = new ArrayList<>();
                for(int j=0; j<n; j++){
                    rowone.add(Integer.parseInt(val[j]));
                }
                arr.add(rowone);
                for(int i = 1; i< n;i++){
                    List<Integer> row = new ArrayList<>();
                    for(int j =0; j< n;j++){
                        row.add(sc.nextInt());
                    }
                    arr.add(row);
                }
            }
        }
       System.out.println(mincost(0,0,arr)); 
    }
}