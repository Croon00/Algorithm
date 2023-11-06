class Solution {
    public int[] solution(int num, int total) {
        int[] answer;
        // num과 total이 주어질 때 연속된 수 num개를 더한 값이 total이 될 때, 정수 배열을 오름차순으로 담아 return
        
        int cnt = 0;
        int sum = 0;
        int start = total;
        if(total == 0){
            start = 1000;
        }
        int idx = start;
        
        while(true){
            sum += idx;
            cnt++;
            
            if(sum == total && cnt == num){
                answer = new int[start - idx + 1];
                int answerIdx = 0;
                for(int i = idx; i <= start; i++){
                    answer[answerIdx++] = i;
                }
                break;
            }
            idx--;
            // 갯수를 넘어버리면 다시
            if(cnt > num){ 
                cnt = 0;
                sum = 0;
                start--;
                idx = start;
            }
            
        }
        return answer;
    }
}