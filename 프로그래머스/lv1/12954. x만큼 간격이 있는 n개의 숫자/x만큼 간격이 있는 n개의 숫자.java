class Solution {
    public long[] solution(int x, int n) {
        long[] answer = {};
        answer = new long[n];
        for(int i = 0; i < n; i++){
            if(i == 0) answer[i] = x;
            else answer[i] = (long) x * (i + 1);
        }
        return answer;
    }
}