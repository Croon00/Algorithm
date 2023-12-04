import java.util.*;
import java.io.*;

public class Main {

    // 동전 1
    // n 가지 종류의 동전
    // 각각 동전이 나타내는 가치 다름
    // 가치의 합이 k원이 되도록 하는 경우의 수 (동전은 몇개라도 사용 가능)
    // 순열 x 조합으로만
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n, k;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 동전 종류
        k = Integer.parseInt(st.nextToken()); // 합 k

        int [] coin = new int[n];

        // 인덱스의 값을 만드는데 경우의 수
        int [] dp = new int[k + 1];

        // 0을 만드는 것은 동전 0개 사용
        dp[0] = 1;

        // 동전을 한 가지만 사용할 경우 , 2 가지만 사용할 경우, 세가지 사용할 경우 ~~~


        for(int i = 0; i < n; i++){
            coin[i] = Integer.parseInt(br.readLine());
            // coin 값 으로 시작하여 j++ 하면서 k 값까지
            for(int j = coin[i]; j <= k; j++){
                // 현재 j의 값을 만들 수 있는 경우는 j의 값에서 - 현재 코인 값을 뺀 경우의 수를 더 한값값
               dp[j] = dp[j] + dp[j - coin[i]];
            }
        }

        System.out.println(dp[k]);

    }

}



