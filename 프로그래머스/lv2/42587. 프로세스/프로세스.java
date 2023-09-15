import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int p : priorities){
            pq.offer(p);
        }
        int cnt = 0;
        boolean flag = false;
        while(!pq.isEmpty()){
            for(int i = 0; i < priorities.length; i++){
                // 우선순위가 가장 높은 것을 뺀다.
                if(pq.peek() == priorities[i]){
                    // 몇 번째로 빼는 것인지 answer에 ++
                    pq.poll();
                    cnt++;
                    
                    if(i == location){
                    answer = cnt;
                    flag = true;
                    break;
                    }
                }
                
            }
            if(flag) break;
        }
        return answer;
    }
}