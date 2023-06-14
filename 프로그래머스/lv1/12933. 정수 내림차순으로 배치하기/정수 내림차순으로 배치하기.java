import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String abs = String.valueOf(n);
        
        long[] nums = new long[abs.length()];
        
        
        for(int i = 0; i < abs.length(); i++){
            nums[i] = n % 10;
            n /= 10;
        }
        
        Arrays.sort(nums);
        
        for(int i = nums.length - 1; i >= 0; i--){
            answer += nums[i];
            
            if(i == 0) continue;
            answer *= 10;
        }
    
        
        return answer;
    }
}