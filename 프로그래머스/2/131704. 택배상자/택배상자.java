/*
    택배상자를 트럭에 싣는 
    1번 ~ n번 번호증가 상자 순서대로 내릴 수 있음
    순서와 맞게 실어야 함
    잠시 다른 곳에 보관 가능
    보조 컨테이너 벨트 추가 --> 가장 마지막에 넣은 것을 먼저 꺼내게 됨 --> Stack
    
    // 네번째, 세번째, 첫번째, 두번째, 다섯번째 순서로 뽑아야 한다.
*/
import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int [] boxNum = new int[order.length + 1];
        
        // 컨베이어 벨트
        Stack<Integer> stack = new Stack<Integer>();
        
        int idx = 0;
        // 1번 부터 상자를 받는다.
        for(int i = 1; i <= order.length; i++){
            stack.push(i);
            
            // 스택 비울때 까지
            while(!stack.isEmpty()){
                
                // 현재 상자 번호가 실어야 하는 번호이면
                if(stack.peek() == order[idx]){
                    stack.pop();
                    idx++;
                    answer++;
                }
                
                else{
                    break;
                }
            }
        }
    
        
        return answer;
    }
}