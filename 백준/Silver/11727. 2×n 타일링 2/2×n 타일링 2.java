
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, Dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Dp = new int [1001];
        Dp[1] = 1;
        Dp[2] = 3;


        for(int i = 3; i < 1001; i++){
            Dp[i] = (Dp[i - 1] + (Dp[i - 2] * 2) ) % 10007;
        }

        N = Integer.parseInt(br.readLine());
        System.out.println(Dp[N]);

    }
}
