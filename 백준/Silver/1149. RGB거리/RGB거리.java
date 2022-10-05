

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int [][] num = new int[N + 1][4];


        // RGB 값 받아 놓기
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 3; j++){
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 값 받아놓기
        int [][] Dp = new int[3][4];
        Dp[1][1] = num[1][1];
        Dp[1][2] = num[1][2];
        Dp[1][3] = num[1][3];

        // 2번째
        for(int i = 2; i <= N; i++){
            // 이번 집이 빨강이면 전 집에 파랑 혹은 녹색 중에 작은 값을 가져와서 현재 값을 더 해준다.
            Dp[2][1] = Math.min(Dp[1][2], Dp[1][3]) + num[i][1];
            
            // 이번 집이 파랑이면 전 집에 빨강 혹은 녹색 중에 작은 값을 가져와서 현재 값을 더 해준다.
            Dp[2][2] = Math.min(Dp[1][1], Dp[1][3]) + num[i][2];
            
            // 이번 집이 녹색이면 전 집에 빨강 혹은 파랑 중에 작은 값을 가져와서 현재 값을 더 해준다.
            Dp[2][3] = Math.min(Dp[1][1], Dp[1][2]) + num[i][3];
            
            // 누적 된 값을 덮어 씌우기
            Dp[1][1] = Dp[2][1];
            Dp[1][2] = Dp[2][2];
            Dp[1][3] = Dp[2][3];
        }
        
        // 세개의 경우 중 가장 작은 값을 가진 것을 출력
        int ans = Math.min(Dp[1][3],Math.min(Dp[1][1], Dp[1][2]));
        System.out.println(ans);
    }
}