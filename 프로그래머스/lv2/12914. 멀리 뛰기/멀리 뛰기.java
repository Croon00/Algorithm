class Solution {
    public long solution(int n) {
        // 멀리 뛰기
        // 효진이는 한 번에 1칸 또는 2칸
        // 도달하는 방법의 가지수를 1234567를 나눈 나머지를 리턴 
        
        
        // 1칸은 1칸 뛰기 1개
        // 2 칸은 1칸 뛰기 2번 혹은 2칸 뛰기 1번 총 2개
        // 3칸은 1칸 뛰기 + 2칸 뛰기 or 2칸 뛰기 + 1칸 뛰기 or 1칸 뛰기 3번 총 3가지 방법
        // 4칸은 3칸에서 했던거에서 1 씩 있고, 
        long [] dp = new long[2001];
        
        dp[1] = 1;
        dp[2] = 2;
        
        
        for(int i = 3; i <= 2000; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        
        
        
    
        long answer = 0;
        answer = dp[n];
        return answer;
    }
}