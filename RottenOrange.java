import java.io.*;
import java.util.*;

public class RottenOrange {
    static int[] dirx = {0,1,0,-1};
    static int[] diry = {1,0,-1,0};
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
        boolean[][] vis = new boolean[arr.size()][arr.get(0).size()];
        int fc =0;
        for(int i =0; i<arr.size();i++){
            for(int j =0; j< arr.size();j++){
                if(arr.get(i).get(j)==1)   fc++;
            }
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i =0; i<arr.size();i++){
            for(int j =0; j< arr.get(0).size();j++){
                if(arr.get(i).get(j)==2) {
                    q.offer(new int[]{i,j,0});
                    vis[i][j] = true;
                }
            }
        }
        if(fc==0){
            System.out.println(0);
            return;
        }
        int maxdays=-1;
        while(!q.isEmpty()){
            int[] val = q.poll();
            int xi = val[0];
            int yj = val[1];
            int day = val[2];
            maxdays = Math.max(maxdays, day);
            for(int i =0; i<4;i++){
                int newx = xi+dirx[i];
                int newy = yj+diry[i];
                if(newx >=0 && newx<arr.size() &&newy>=0 && newy< arr.get(0).size()){
                    if(!vis[newx][newy] && arr.get(newx).get(newy)==1){
                        vis[newx][newy] = true;
                        q.offer(new int[]{newx,newy,day+1});
                        fc--;
                    }
                }
            }
        }
        if(fc>0)
            {
                System.out.println(-1);
            }
        else{
            System.out.println(maxdays);
        }
    }
}
