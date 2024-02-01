import java.util.*;

class Solution {
    
    // 실패율
    // 스테이지에 도달 했으나 아직 클리어 하지 못한 플레이어 수 / 스테이지에 도달한 플레이어 수
    // 스테이지의 개수 N, 겡미을 이용하느 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages
    public int[] solution(int N, int[] stages) {
        
        
        // N 1 ~ 500
        // stages 1 ~ 20만
        
        // stages에 1 이상 N + 1이하의 자연수가 담겨있음  N + 1은 N 번째 스테이지 까지 클리어 한 사용자
        // 각 자연수는 현재 도전 중인 스테이지의 번호
        
        // 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면된다.
        
        int [] stage = new int[N + 1];
        
        // 스테이지 마다 실패율을 담을 hashmap
        HashMap<Integer, Double> failPer = new HashMap<>();
        
        // 스테이지에 실패율 담기
        
        // 총 인원
        int totalP = stages.length;
        
        // 해당 스테이지에 있는 인원 ++
        for(int i = 0; i < stages.length; i++){
            if(stages[i] > N) continue;
            stage[stages[i]]++;
        }
        
        for(int i = 1; i < N + 1; i++){
            // 스테이지에 있는 실패율 넣기 측정
            if(stage[i] > 0){
                Double fail = (double) stage[i] / (double) totalP;
                // 해당 i번째 스테이지의 실패율 넣기
                failPer.put(i, fail);
                // 전체 인원 수 빼기
                totalP -= stage[i];
            }
            else{
                failPer.put(i, 0.0);
            }
        }
        

        // 실패율로 내림차순으로 정렬
        List<Integer> keyStage = new ArrayList<>(failPer.keySet());
        
        Collections.sort(keyStage, (v1, v2) -> (failPer.get(v2).compareTo(failPer.get(v1))));
        
        int [] answer = new int[N];
        
        for(int i = 0; i < N; i++){
           answer[i] = keyStage.get(i);
        }
        
        System.out.println(keyStage);
        
        
        return answer;
    }
}