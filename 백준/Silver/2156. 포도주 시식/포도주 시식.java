import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] wine = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N + 1];

        dp[1] = wine[1];

        if(N > 1){
            dp[2] = wine[1] + wine[2];
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 3] + wine[i] + wine[i - 1], dp[i - 2] + wine[i]));
        }

        System.out.println(dp[N]);
    }
}