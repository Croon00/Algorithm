import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int [] answer = new int[commands.length];
        
        // 명령 만큼
        for(int i = 0; i < commands.length; i++){
            // 0부터 셈으로 -1 하기
            int start = commands[i][0] - 1;
            int stop = commands[i][1];
            int idx = commands[i][2] - 1;
            
            // 시작 부터 끝까지
            int [] temp = new int[stop - start];
            int idx2 = 0;
            for(int k = start; k < stop; k++){
                temp[idx2++] = array[k];
            }
            Arrays.sort(temp);
            // 정답에 idx 부분에 있는 숫자 넣기
            answer[i] = temp[idx];
        }
        return answer;
    }
}