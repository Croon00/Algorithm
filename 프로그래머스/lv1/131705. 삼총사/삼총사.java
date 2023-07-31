class Solution {
    public int solution(int[] number) {
        
        // number의 길이가 최고 13개 임으로 3중 for문 가능
        // 혹은 여러 사람 중 3명 뽑는 것으로 하는 dfs도 가능
        int answer = 0;
        for(int i = 0; i < number.length - 2; i++){
            for(int j = i + 1; j < number.length - 1; j++){
                for(int k = j + 1; k < number.length; k++){
                    if(number[i] + number[j] + number[k] == 0) answer++;
                }
            }
        }
        return answer;
    }
}