// 정수로 이루어진 배열 numbers,
import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        
        // 위치는 고정임으로 정렬 x
        // 완전 탐색 하면 너무 큰데
        // 흠
        // 투포인터로 풀어보기 x
        // 스택 / 큐
        int [] answer = new int[numbers.length];
        
        // 뒤에서 가장 가까운 값을 비교해야 하기 때문에 Stack으로 넣기 (가장 최근에 넣은 값 꺼내기)
        Stack<Integer> stack = new Stack<>();
        for(int i = numbers.length - 1; i >= 0; i--){
            
            // 스택 빌 때까지
            while(!stack.isEmpty()){
                // 스택의 가장 최근 값이 더 큰 경우, answer에 담기
                if(numbers[i] < stack.peek()){
                    answer[i] = stack.peek();
                    break;
                }
                // 자기 자신 뒤의 값이 더 작은 값이면 stack에서 빼버리자
                else{
                    stack.pop();
                }
            }
            // 스택이 비어버렸으면 자기 자신 보다 큰 값이 없었던 것으로 -1 추가
            if(stack.isEmpty()) answer[i] = -1;
            stack.push(numbers[i]);

        }
        return answer;
    }
}