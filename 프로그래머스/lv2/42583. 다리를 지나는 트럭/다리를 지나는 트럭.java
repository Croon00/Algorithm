import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        // 트럭이 최대 bridge_length대 올라갈 수 있다.
        // 최대 weight 이하까지의 무게를 견딜 수 있다.
        // 다리에 완전히 오르지 않은 트럭의 무게는 무시
        
        // 큐에 대기 트럭 weight들을 넣는다.
        Queue <Integer> bridge = new LinkedList<>();
       
        
       
        int presentWeight = 0;
        int cnt = 0;
        // 대기 트럭이 모두 사라질 때 까지
        for(int truck : truck_weights){
            while(true){
                // 다리가 비어있으면
                if(bridge.isEmpty()){
                    bridge.offer(truck);
                    cnt++;
                    presentWeight = truck;
                    break;
                }
                // 다리가 비어있지 않으면
                else{
                    
                    // 다리가 꽉 차있으면
                    if(bridge.size() == bridge_length){
                        presentWeight -= bridge.poll();
                    }
                    // 다리가 꽉 차있지 않으면서 더 트럭 올릴 수 있는 경우
                    else if(presentWeight + truck <= weight){
                        presentWeight += truck;
                        bridge.offer(truck);
                        cnt++;
                        break;
                    }
                    // 다리에 무게 때문에 더 차를 올리지 못하는 경우
                    else{
                        bridge.offer(0);
                        cnt++;
                    }
                }
            }
        }
        
        cnt += bridge_length;
        
        answer = cnt;
      
        return answer;
    }
}