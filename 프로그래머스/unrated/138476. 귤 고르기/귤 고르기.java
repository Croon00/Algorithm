import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // 귤 수확 수확한 귤 중 k 개 골라서 상자 하나에 담아 판매
        // 크기가 일정하지 않아 보기에 좋지 않음 --> 서로 다른 종류의 수를 최소화
        // 인덱스로 가장 큰 것 부터
        
        int [] index = new int[10000001];
        
        for(int i = 0; i < tangerine.length; i++){
            index[tangerine[i]]++;
        }

        
        int answer = 0;

        Arrays.sort(index);
        
        // 그냥 제일 뒤에서부터 빼서 0 이하면 해당 답 내놓기
        for(int i = index.length - 1; i >= 0; i--){
            if(index[i] == 0) continue;
            if(k <= 0) {
                break;
            }
            else{
                k -= index[i];
                answer++;
            }
        }
        
        return answer;
    }
}