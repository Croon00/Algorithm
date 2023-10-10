import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        // 명예의 전당 이라는 TV 프로그램
        // 지금까지의 출연 구사둘의 점 수 중 상위 k번째 이내이면 명예의 전당 목록에 올리기
        // 매일 명예의 전당의 최하위 점수를 return 하는 함수
        
        List<Integer> honor = new ArrayList<>();
        int[] answer = new int[score.length];


        for(int i = 0; i < score.length; i++){
            
            // k 번째 채우기 전까지는 추가
            if(i < k){
                honor.add(score[i]);
                Collections.sort(honor);
                answer[i] = honor.get(0);
            }
            // k 번째 채운 후에는
            else{
                // 정렬 후
                // 여태 있는 값 보다 더 큰 값인 경우
                for(int j = 0; j < honor.size(); j++){
                    if(honor.get(j) < score[i]){
                        // 가장 작은 값을 삭제 후 그 값을 추가
                        honor.remove(0);
                        honor.add(score[i]);
                        Collections.sort(honor);
                        break;
                    }
                }
                answer[i] = honor.get(0);

            }
        }
        

        return answer;
    }
}