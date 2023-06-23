import java.util.*;
import java.io.*;

public class Main {



    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int mod = 1000000000;
        int N = Integer.parseInt(br.readLine());
        // N의 계단 수를 갖고 있는 숫자를 구해야 함
        // N은 1~ 100 임으로 100계단까지 존재할 수 있음
        // N 자릿수에 0 ~ 9 값들이 올때
        long dp [][] = new long[N + 1][10];

        // 첫 번째 자리수는 1개 밖에 존재 하지 않는 경우의 수
        for(int i = 1; i < 10; i++){
            dp[1][i] = 1;
        }

        for(int i = 2; i <= N; i++){

            for(int j = 0; j < 10; j++){

                // j 가 0이라면 이전 자릿수에 값이 1인 경우에만 가능
                if(j == 0){
                    dp[i][j] = dp[i - 1][1] % mod;
                }

                // j 가 9라면 이전 자릿수에 값이 8인 경우에만 가능
                else if(j == 9){
                    dp[i][j] = dp[i - 1][8] % mod;
                }
                else{
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }
            }
        }

        long ans = 0;

        // N 개의 계단이 있는 수의 경우의 수를 전부 더 했을 때 값이 나온다.
        for(int i = 0; i < 10; i++){
            ans += dp[N][i];
        }
        System.out.println(ans % mod);

    }
}
