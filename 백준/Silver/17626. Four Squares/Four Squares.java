import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int [] dp = new int[N + 1];
        // dp 초기 부분 초기화
        dp[0] = 0;
        dp[1] = 1;

        int min;
        // 2 부터 N 까지
        for(int i = 2; i <= N; i++){
            min = Integer.MAX_VALUE;
            // 제곱 수가 해당 i와 같을 경우 까지
            for(int j = 1; j * j <= i; j++){
                // i 번째의 값에 (j * j)인 제곱수를 빼서 그것이 기존에 있던 dp 값인 경우가 있을 수 있다.
                // ex) i= 9 dp[9-9] == dp[0]임으로 0
                min = Math.min(min, dp[i - j * j]);
            }
            // 추가 적으로 min에 +1씩 해준다.
            dp[i] = min + 1;
        }
        System.out.println(dp[N]);
    }
}