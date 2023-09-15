import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        //초 단위로 기록된 주식가격이 담긴 배열 prices, 가격이 떨어지지 않은 기간은 몇 초인지
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < prices.length - 1; i++){
            int price = prices[i];
            int cnt = 0;
            for(int j = i + 1; j < prices.length; j++){
                cnt++;
                if(price > prices[j]){
                    break;
                }
            }
            ans.add(cnt);
        }
        int[] answer = new int[ans.size() + 1];
        for(int i = 0; i < answer.length - 1; i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}