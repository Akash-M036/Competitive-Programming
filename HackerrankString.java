import java.io.*;
import java.util.*;
public class HackerrankString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        String target = "hackerrank";
        int tl = target.length();
        
      while (q > 0) {
            String s = sc.nextLine();
            int tp = 0;
            
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == target.charAt(tp)) {
                    tp++;
                }
                if (tp == tl) {
                    break;
                }
            }
            if (tp == tl) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            
            q--;
        }
        sc.close();
    }
}

