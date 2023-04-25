import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String S = br.readLine();

        int [] nums = new int[S.length()];

        int zero = 0;
        boolean zeroB = false;
        int one = 0;
        boolean oneB = false;



        for(int i = 0; i < S.length(); i++){
            nums[i] = S.charAt(i) - '0';

            if(nums[i] == 0 && !zeroB){
                zeroB = true;
                oneB = false;
                zero++;
            }
            else if(nums[i] == 1 && !oneB){
                oneB = true;
                zeroB = false;
                one++;
            }
        }

        int ans = Math.min(one, zero);
        System.out.println(ans);
    }
}
