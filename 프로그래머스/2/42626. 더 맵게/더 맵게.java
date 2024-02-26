// 모든 음식의 스코빌 지수를 K 이상으로 만들기
// 스코빌 지수가 가장 낮은 두 개의 음식을 섞기
// 모든 스코빌 지수가 K 이상이 될 때까지 반복하여 섞기
// K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return

// 최소 힙에서 값을 빼와서 더해야 겠다.
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        while(true){
            // 가장 낮은 스코빌 지수가 K 이상일때 끝내기
            if(pq.peek() >= K) break;
            
            // 남은 음식이 1개일 때
            if(pq.size() == 1){
                int last = pq.poll();
                // 스코빌 지수 보다 높으면 끝내기
                if(last >= K) break;
                // 아닌 경우 -1 return
                else return -1;
            }
            answer++;
            int a = pq.poll();
            int b = pq.poll();
            
            b *= 2;
            pq.add(a + b);
        }
        return answer;
    }
}