import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        // 내려가면서 거쳐간 숫자의 합이 가장 큰 경우 찾기
        
        
        // dp로 풀기
        int [][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        
        
        // 0번째랑 끝에는 자신 위에 있는 값에 자기 값 더하기
        // 나머지는 자신 위에 있는 값에 더한거랑 자신 오른쪽 위에 있는 값이랑 더한거
        for(int i = 1; i < triangle.length; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                }
                else if(j == triangle[i].length - 1){
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }
        
        for(int i = 0; i < triangle.length; i++){
            answer = Math.max(answer, dp[triangle.length - 1][i]);
        }
        return answer;
    }
}