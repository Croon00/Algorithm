

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int [][] arr = new int[N + 1][4];


        int [][] Dp = new int[5][4];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
        }

        // 최대 구하기 용
        Dp[1][1] = arr[1][1];
        Dp[1][2] = arr[1][2];
        Dp[1][3] = arr[1][3];

        // 최소 구하기 용
        Dp[3][1] = arr[1][1];
        Dp[3][2] = arr[1][2];
        Dp[3][3] = arr[1][3];

        for(int i = 2; i <= N; i++){
            // 최대 구하기

            // 첫 번째 녀석의 경우 위에서 자신의 위나 오른쪽 위
            Dp[2][1] = Math.max(Dp[1][1], Dp[1][2]) + arr[i][1];

            // 두 번째 녀석의 경우 자신의 위 전부 다
            Dp[2][2] = Math.max(Math.max(Dp[1][1], Dp[1][2]), Dp[1][3]) + arr[i][2];

            // 세 번재 녀셕의 경우 자신의 위 혹은 왼쪽 위
            Dp[2][3] = Math.max(Dp[1][2], Dp[1][3]) + arr[i][3];

            // 최소 구하기


            // 첫 번째 녀석의 경우 위에서 자신의 위나 오른쪽 위
            Dp[4][1] = Math.min(Dp[3][1], Dp[3][2]) + arr[i][1];

            // 두 번째 녀석의 경우 자신의 위 전부 다
            Dp[4][2] = Math.min(Math.min(Dp[3][1], Dp[3][2]), Dp[3][3]) + arr[i][2];

            // 세 번재 녀셕의 경우 자신의 위 혹은 왼쪽 위
            Dp[4][3] = Math.min(Dp[3][2], Dp[3][3]) + arr[i][3];



            // 값을 갱신
            Dp[1][1] = Dp[2][1];
            Dp[1][2] = Dp[2][2];
            Dp[1][3] = Dp[2][3];

            // 값을 갱신
            Dp[3][1] = Dp[4][1];
            Dp[3][2] = Dp[4][2];
            Dp[3][3] = Dp[4][3];
        }

        int max = Math.max(Dp[1][1], Math.max(Dp[1][2], Dp[1][3]));
        int min = Math.min(Dp[3][1], Math.min(Dp[3][2], Dp[3][3]));

        System.out.println(max + " " + min);
    }



}