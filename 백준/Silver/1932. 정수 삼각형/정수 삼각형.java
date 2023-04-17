import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int floor = Integer.parseInt(br.readLine());
        int [][] dp = new int[floor][floor];
        int [][] nums = new int[floor][floor];
        for(int i = 0; i < floor; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i + 1; j++){
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < floor; i++){
            dp[floor - 1][i] = nums[floor - 1][i];
        }

        for(int i = floor - 2; i >= 0; i--){
            for(int j = 0; j < i + 1; j++){
                dp[i][j] = Math.max(nums[i][j] + dp[i + 1][j], nums[i][j] + dp[i + 1][j + 1]);
            }
        }
        System.out.println(dp[0][0]);
    }
}
