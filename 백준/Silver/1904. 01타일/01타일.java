import java.util.*;
import java.io.*;

public class Main {


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long [] dp = new long[1000001];

        // 초기 갯수 초기화
        // 점화식으로 만들기
        // dp[1] = 1
        // dp[2] = 00, 11
        // dp[3]은 001, 100, 111 3개
        // dp[4]는 0011, 0000, 1001, 1100, 1111 5개
        // dp[5]는 00111, 00001, 10011, 11001, 11111, 00100, 10000, 11100

        // 11100 11001 10011 00111 10000 00001 11111 00100
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i < 1000001; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }
        int N = Integer.parseInt(br.readLine());
        System.out.println(dp[N]);
    }
}
