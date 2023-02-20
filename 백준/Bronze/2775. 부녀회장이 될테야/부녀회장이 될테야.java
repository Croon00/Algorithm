import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // a층의 b호에 살려면 아래 (a - 1)층의 1호부터 b호 까지 사람들의 수의 합 만큼
    // 사람들을 데려와 살아야 한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int [][] dp = new int[15][15];

        // 0층 초기화
        for (int i = 1; i < 15; i++){
            dp[0][i] = i;
        }
        for (int i = 1; i < 15; i++){
            for(int j = 1; j < 15; j++){
                for(int k = 1; k <= j; k++){
                    dp[i][j] += dp[i-1][k];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++){
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());

            sb.append(dp[a][b]).append("\n");
        }

        System.out.println(sb);
    }
}