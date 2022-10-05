
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int T, N, Dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Dp = new int [11];
        Dp[1] = 1;
        Dp[2] = 2;
        Dp[3] =  4;

        for(int i = 4; i < 11; i++){
            Dp[i] = Dp[i - 1] + Dp[i - 2] + Dp[i - 3];
        }


        T = Integer.parseInt(br.readLine());

        for(int i = 1; i <= T; i++){
            N = Integer.parseInt(br.readLine());
            sb.append(Dp[N]).append("\n");
        }

        System.out.println(sb);

    }
}
