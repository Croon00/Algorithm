import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1){
            int [] answer = {-1};
            return answer;
        }
        
        int [] answer = new int[arr.length - 1];
        
        int minNum = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i = 0; i < arr.length; i++){
            minNum = Math.min(minNum, arr[i]);
            
        }
        
        int cnt = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == minNum) continue;
            else{
                answer[cnt++] = arr[i];
            }
        }
        
        
        return answer;
    }
}