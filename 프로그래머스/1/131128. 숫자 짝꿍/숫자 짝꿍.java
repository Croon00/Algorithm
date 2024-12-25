/*
    두 정수 x, y 임의의 자리 공통으로 나타나는 정수 0  ~ 9으로 이용하여 만들 수 이쓴ㄴ 가장 큰 정수
    두 수 --> 짝궁 짝꿍 업승면 -1
    
*/
import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        
        // 자릿수가 3백만 --> 완전탐색으로 하면 너무 길음
        
        // 0 ~ 9숫자 배열 만든다음 cnt 쌓아서 가져오기
        
        int [] cnt = new int [10];
        int [] cnt2 = new int [10];
        
        // X에서 숫자 카운트
        for(int i = 0; i < X.length(); i++){
            int temp = X.charAt(i) - '0';
            
            cnt[temp]++;
        }
        
        // Y에서 숫자 카운트
        for(int i = 0; i < Y.length(); i++){
            int temp = Y.charAt(i) - '0';
            cnt2[temp]++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        boolean flag = false;
        
        for(int i = 9; i >= 0; i--){
            
            // 0만 서로 갖고 있을 땐 0
            if(i == 0 && !flag && cnt[i] > 0 && cnt2[i] > 0){
                answer.append("0");
                break;
            }
            
            // 두 개의 짝꿍이 모두 있을 때
            if(cnt[i] > 0 && cnt2[i] > 0){
                flag = true;
                
                while(true){
                    answer.append(String.valueOf(i));
                    
                    cnt[i]--;
                    cnt2[i]--;
                    
                    // 두 정수에 x,y나 없어진 경우 끝
                    if(cnt[i] == 0 || cnt2[i] == 0) break;
                }
            }
        }
        
        
        
        String ans = answer.toString();
        if(ans.equals("")){
            ans = "-1";
        }
        
        return ans;
    }
}