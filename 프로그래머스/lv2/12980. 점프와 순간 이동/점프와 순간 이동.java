import java.util.*;

public class Solution {
    public int solution(int n) {
        // 한 번에 k 칸을 앞으로 점프 or 현재까지 온 거리 x 2에 해당하는 위치로 순간이동
        // k 칸 만큼 점프하면 k만큼 건전지 사용량 듬, 순간이동은 건전지 사용량 x
        // 사용해야할 최소한의 건전시 량
        // 순간이동을 최대한 사용하면서 점프는 최소
        // int [] dp = new int[n + 1];
        // dp[1] = 1;
        // dp[2] = 1;
        // dp[3] = 2; // dp[2]에서 + 1칸 가기
        // dp[4] = 1; // dp[2]와 같다
        // dp[5] = 2; // dp[4] 에다가 +1
        // dp[6] = 2; // dp[3]과 같다
        // dp[7] = 3; // dp[6] 에다가 + 1
        // dp[8] = 1; // dp[4]와 같다.
        
        // for(int i = 3; i <= n; i++){
        //     // 홀 수 일때 짝 수 일때 나누어서
        //     if(i % 2 != 0){
        //         dp[i] = dp[i - 1] + 1;
        //     }
        //     else{
        //         dp[i] = dp[i / 2];
        //     }
        // }
        

        int ans = 0;
        // 탑 다운 방식으로
        while(n != 0){
            // 홀 수 일때 + 1
            if(n % 2 != 0){
                n--;
                ans++;
            }
            else{
                n = n / 2;
            }
        }
        
        return ans;
    }
}