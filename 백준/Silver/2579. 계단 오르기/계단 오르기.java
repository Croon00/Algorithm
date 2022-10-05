

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        // 마지막 계단을 밟는법 --> 연속으로 2계단 밟던지 점프해서 밟던지
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N + 1];
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int [] Dp = new int[N + 1];

        // 첫 번째 계단이랑, --> 첫번째 밟는 값
        Dp[1] = arr[1];

        
        if(N >= 2){
            // 두 번째 계단은 첫번째 밟고 두번째 계단 밟은거
            Dp[2] = arr[1] + arr[2];
        }
        

        // 3 번째 계단 부터는 이전 계단 안밟고 온 것과 밟은경우
        // (이전 계단을 밟은 경우에는 -3 한계단에서 올라와서 -1계단의 값과 현재 계단 값을 더해주어야 한다.)
        for(int i = 3; i <= N; i++){
            Dp[i] = Math.max(Dp[i - 2], Dp[i-3] + arr[i - 1]) + arr[i];
        }

        // 마지막 계단은 무조건 밟아야 함으로 N 값
        System.out.println(Dp[N]);



    }



}