import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        // n과 left right
        
        // n 행 n열 크기의 비어있는 2차원 배열
        // i = 1, 2, 3, ..., n
        // 1행 1열 부터 i행 i열 까지의 영역 내의 모든 빈칸을 i로 채우기
        // n은 1000만
        // 2차원 for문 돌리면 무조건 시간제한..
        
        // 각 인덱스 값은 행과 열에서 max 값이 넣어진다.
        // 맨위 행은 1234
        // 그 다음 행은 2234 ~~~
        // 그 다음 행은 3334 ~~~
        // 이런 규칙으로 오게 되고 이것을 행으로 나누어서 붙이면 
        // 123422343334 ~~
        
        // 이중에서 left시작 부터 right 까지
        int length = (int) right -  (int) left;
        int [] answer = new int[length + 1];
        int index = 0;
        // 
        for(long i = left; i <= right; i++){
            // n의 값으로 나눴을 때 나오는 값이 행
            // 나머지 값이 열이다
            // left가 0부터 시작함으로 +1 씩 해준다.
            long row =  i / n + 1;
            long col =  i % n + 1;
            
            // 행과 열 중 큰  값이 해당 값
            answer[index++] = Math.max((int) row, (int) col);
        }
        return answer;
    }
}