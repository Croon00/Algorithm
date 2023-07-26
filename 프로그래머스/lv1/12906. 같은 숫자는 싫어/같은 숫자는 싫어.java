import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        List<Integer> answer = new ArrayList<Integer>();
        int num = -1;
        for(int i = 0; i < arr.length; i++){
            if(num == arr[i]) continue;
            num = arr[i];
            answer.add(arr[i]);
        }
        
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.

        return answer;
    }
}