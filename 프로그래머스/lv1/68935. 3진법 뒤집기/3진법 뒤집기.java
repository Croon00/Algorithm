import java.util.*;

class Solution {
    public int solution(int n) {
        List<Integer> nums = new ArrayList<>();
        
        // 앞뒤 반전
        while(n > 0){
            int num = n % 3;
            nums.add(num);
            n /= 3;
        }
        int answer = 0;

        int cnt = 1;
        for(int i = nums.size() - 1; i >= 0; i--){
            answer += nums.get(i) * cnt;
            cnt *= 3;
        }
        return answer;
    }
}