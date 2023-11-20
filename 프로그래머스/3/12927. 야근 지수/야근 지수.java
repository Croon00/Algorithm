import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;

        // Demi는 가끔은 야근을 한다..
        // 야근 하면 피로도 쌓임
        // 야근 피로도 = 시작한 시점 + 남은 일의 작업량 제곱
        // 1시간 동안 1만큼 작업량 처리
        // 퇴근 시간 까지 남은 N 시간과 각 일에 대한 작업량 works에 대한 피로도 최소한 값
        
        // works 20,000 이하 , 50000이하의 자연수
        // n 100만
        
        // 남은 작업량에서 현재 남은 시간을 빼야 한다
        // PriortyQueue를 써서 그때그때 가장 큰 값을 뽑아서 거기서 빼야 하겠는데?
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int work : works){
            pq.add(work);
        }
        
        // 1부터 n 까지 작업량 빼서 넣기
        for(int i = 0; i < n; i++){
            int num = 0;
            if(!pq.isEmpty()){
                num = pq.poll();
            }
            else{
                break;
            }
            num--;
            if(num != 0){
                pq.add(num);
            }
        }
        
        // 남은 작업량 제곱으로 넣기
        while(!pq.isEmpty()){
            int num = pq.poll();
            answer += num * num;
        }
        return answer;
    }
}