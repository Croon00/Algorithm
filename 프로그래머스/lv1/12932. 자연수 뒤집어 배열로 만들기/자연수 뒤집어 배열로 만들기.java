import java.util.*;

class Solution {
    public Long[] solution(long n) {
        Long[] answer = {};
        
        List<Long> ans = new ArrayList<Long>();
        
        while(n > 0){
            long temp =  n % 10;
            System.out.println(temp);
            ans.add(temp);
            n /= 10;
        }
        
        answer = new Long[ans.size()];
        
        for(int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}