// N행 4열로 이루어져있는 게임의 땅
// 모든 칸에는 점수 쓰여있슴
// 4칸 중 한 칸만 밟으면서 내려와야 한다.
// 같은 열을 연속해서 밟으면 안됌
// 얻는 최대의 점수값을 return
class Solution {
    int solution(int[][] land) {
        int answer = 0;

        
        // 전형적인 dp
        int [][] dp = new int [2][4];
        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];
        
        // 자신의 위치에서 위에있는 누적값들을 더했을 때 가장 큰 값들을 남긴다 (자신 위에 값은 빼고)
        for(int i = 1; i < land.length; i++){
            dp[1][0] = Math.max(Math.max(dp[0][1], dp[0][2]), dp[0][3]) + land[i][0];
            dp[1][1] = Math.max(Math.max(dp[0][0], dp[0][2]), dp[0][3]) + land[i][1];
            dp[1][2] = Math.max(Math.max(dp[0][0], dp[0][1]), dp[0][3]) + land[i][2];
            dp[1][3] = Math.max(Math.max(dp[0][0], dp[0][1]), dp[0][2]) + land[i][3];
            
            dp[0][0] = dp[1][0];
            dp[0][1] = dp[1][1];
            dp[0][2] = dp[1][2];
            dp[0][3] = dp[1][3];
        }
        
        for(int i = 0; i < 4; i++){
            answer = Math.max(answer, dp[0][i]);
        }
        
        
        return answer;
    }
}