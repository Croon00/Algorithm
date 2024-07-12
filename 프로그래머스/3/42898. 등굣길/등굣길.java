import java.util.*;

/*
    집에서 학교까지 가는 길 m x n
    집이 있는 곳 (1, 1) 학교가 있는 곳 (m, n)
    오른쪽과 아래로만 움직여 갈 수 있는 최단 경로 개수
    
    오른쪽 아래 로만 움직임으로 왼쪽에 있는 경로의 수 + 위에 있는 경로의 수 
*/

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int [][] dp = new int[m][n];
        
        // 잠긴 구역 넣기
        for(int i = 0; i < puddles.length; i++){
            int x = puddles[i][0];
            int y = puddles[i][1];
            
            dp[x - 1][y - 1] = -1;
        }
        
        // 첫 행의 겨우 모두 1
        // 잠긴 구역 만나면 그 이후로는 못 감으로 0으로 남긴다.
        for(int i = 1; i < n; i++){
            if(dp[0][i] == -1) break;
            dp[0][i] = 1;
        }
        
        // 첫 열 경우 모두 1
        // 잠긴 구역 만나면 그 이후로는 못 감으로 0으로 남긴다.
        for(int i = 1; i < m; i++){
            if(dp[i][0] == -1) break;
            dp[i][0] = 1;
        }
        
        // 그 이외의 격자의 경우
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                // 현재 물에 잠긴 경우 건너띄기
                if(dp[i][j] == -1) continue;
                
                int upCnt = dp[i - 1][j];
                int leftCnt = dp[i][j - 1];
                
                // 위와 왼쪽 전부 물에 잠긴경우
                if(upCnt == -1 && leftCnt == -1){
                    dp[i][j] = 0;
                    continue;
                }
                // 둘 다 잠기지 않은 경우
                if(upCnt != -1 && leftCnt != -1){
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
                    continue;
                }
                
                //위만 잠긴 경우
                if(upCnt == -1){
                    dp[i][j] = dp[i][j - 1];
                }
                //왼쪽만 잠긴 경우
                if(leftCnt == -1){
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        
        int answer = dp[m - 1][n - 1];
        return answer;
    }
}