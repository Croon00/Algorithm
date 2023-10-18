import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clotheHashMap = new HashMap<>();
        
        for(String [] clothe : clothes){
            if(clotheHashMap.containsKey(clothe[1])){
                int temp = clotheHashMap.get(clothe[1]);
                clotheHashMap.put(clothe[1], temp + 1);
            }else{
                clotheHashMap.put(clothe[1], 2);
            }
        }
        
        for(String k : clotheHashMap.keySet()){
            answer *= clotheHashMap.get(k);
        }
        answer -= 1;
        return answer;
    }
}