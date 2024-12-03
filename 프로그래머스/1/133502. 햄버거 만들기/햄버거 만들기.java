/*
    재료 조리 --> 순서에 맞게 쌓여서 완성된 버거
    빵 - 야채 - 고기 - 빵 순서로만 햄버거 포장임
*/
import java.util.*;

class Solution {
    
    // 1 - 빵, 2 - 야채, 3 - 고기
    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        
        
        // 리스트에 담으면서
        for(int i = 0; i <ingredient.length; i++){
            list.add(ingredient[i]);
            
            // 사이즈가 4크기 이상인 경우
            while(list.size() >= 4){
                int index = list.size() - 1;
                
                int temp = list.get(index);
                int temp2 = list.get(index - 1);
                int temp3 = list.get(index - 2);
                int temp4 = list.get(index - 3);
                
                // 1231 완성되면 빼기
                if(temp == 1 && temp2 == 3 && temp3 == 2 && temp4 == 1){
                    answer++;
                    for(int j = index; j >= index - 3; j--){
                        list.remove(j);
                    }
                }
                // 1231이 아닌 경우 건너띄기
                else{
                    break;
                }
            }
        }
        
        
        return answer;
    }
}