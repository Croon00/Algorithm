// 다트를 세 차례 던져 그 점수의 합계로 실력을 겨루기
// 총 3번의 기회, 기회 마다 얻을 수 있는 점수 0 ~ 10
// S, D, T 영역, 제곱, 2제곱, 3제곱 점수
// 스타상, 아차상, 스타상 --> 해당 점수와 바로 전에 얻은 점수를 각 2배로 만들기
// 아차상 --> 해당 점수는 마이너스
// 스타상 --> 첫 번째 기회에 나올 수 있다, 이때 첫 번째만 2배 됨
// 스타상은 다른 스타상과 중첩가능 --> 점수 4배
// 스타상과 아차상 중첩 --> -2 배
// S, D, T은 점수마다 하나씩 존재
// 스타상은 존재 할수도 있고 안할 수도 있다
import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
    // 점수는 0 ~ 10 사이 정수, 보너스 S,D,T
        
        List<Integer> scores = new ArrayList<>();
        
        int beforeScore = 0;
        int presentScore = 0;
        
        int index = -1;
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < dartResult.length(); i++){
            char temp = dartResult.charAt(i);
            
            
            // 숫자 부분
            if(temp >= '0' && temp <= '9'){
                // 1일 경우 큐에 넣기
                if(temp - '0' == 1){
                    queue.add(1);
                }
                
                // 0일 경우
                else if(temp -'0' == 0){
                    // 큐가 비어있지 않다면 10을 추가 하고 큐 비우기
                    if(!queue.isEmpty()){
                        queue.poll();
                        scores.add(10);
                    }
                    // 큐가 비어있다면 0 추가하기
                    else{
                        scores.add(0);
                    }
                    // 다음 인덱스로
                    index++;
                }
                // 이외 숫자는 그냥 추가
                else{
                   scores.add(temp - '0');
                    index++;
                }
                
            }
            // 숫자 이외 값이면
            else if(temp < '0' || temp > '9'){
                
                // 숫자 이외 값이 왔는데 queue가 비어있지 않다면
                // 숫자 1 빼고 index 증가
                if(!queue.isEmpty()){
                    queue.poll();
                    scores.add(1);
                    index++;
                }
                 // s/d/t 부분
                if(temp == 'S'){
                    
                }
                
                if(temp == 'D'){
                    scores.set(index, scores.get(index) * scores.get(index));
                    
                }
                if(temp == 'T'){
                    scores.set(index, scores.get(index) * scores.get(index) * scores.get(index));
                }
                
                if(temp == '*'){
                    if(index == 0){
                    scores.set(index, scores.get(index) * 2);
                }
                // 전 점수와 현재 점수
                    else{
                        scores.set(index, scores.get(index) * 2);
                        scores.set(index - 1, scores.get(index - 1) * 2);
                    }
                }
                if(temp == '#'){
                    scores.set(index, scores.get(index) * -1);
                }
            }
        }
        
        for(int i = 0; i < scores.size(); i++){
            answer += scores.get(i);
            System.out.println(scores.get(i));
        }
        return answer;
    }
}