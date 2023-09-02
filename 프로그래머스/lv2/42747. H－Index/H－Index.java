import java.util.*;
class Solution {
    public int solution(int[] citations) {
        
        // H-Index는 과학자의 생산성과 영향력을 나타내는 지표
        // H-Index를 나타내는 값인 h를 구하려함
        // n개의 논문(1 ~ 1000) 중 인용된 논문 h번 이상 인용된 논문이 h편 이상(0 ~ 10,000)
        // 나머지 논문이 h번 이하 인용되었다면 h의 최대값이 이 과학자의 H-index
        // 오름차순으로 정렬해서 해당 논문의 인용 수를 이용해서 비교하면서 갯수를 센 후 찾으면되겠는데?
        
        Arrays.sort(citations);
        int answer = 0;

        for(int i = citations[citations.length - 1]; i >= 0; i--){
            int num = i;
            int cnt = 0; // h번 이상 인용된 논문 수
            for(int j = citations.length - 1; j >= 0; j--){
                if(num <= citations[j]) cnt++;
            }
            
            if(cnt >= num){
                answer = num;
                break;
            }
        }
        return answer;
    }
}