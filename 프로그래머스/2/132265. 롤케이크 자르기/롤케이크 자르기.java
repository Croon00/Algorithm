import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        // 롤케이크 토핑들이 서로 공평하게 잘려야함
        // 집합의 순서는 바뀌지 않게.
        // 가짓수 방법을 구해라
        // 토핑의 가짓수 topping 1  ~ 1만
        // 총 토핑 갯수 topping.length  1 ~ 100만
        
        // 토핑의 가짓수 세기
        int toppingCnt = 0;
        int answer = 0;
        // 두개의 해쉬 맵으로해서 한쪽에 map에 전부 채운 후 
        // 다른 사람이 시작 부터 해서 그것을 뺏어오는 방법으로 가짓수 같을 때 answer++
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        
        // map1에 다 채우기
        for(int top : topping){
            map1.put(top, map1.getOrDefault(top, 0) + 1);
        }
        
        // map1 한테서는 빼고 map2에 넣기
        for(int top : topping){
            map2.put(top, map2.getOrDefault(top, 0) + 1);
            
            int temp = map1.get(top);
            
            // 해당 개수 0 되면 map1에서 지우기
            if(temp - 1 == 0){
                map1.remove(top);
            }
            // 0이 되지 않는 경우에는 빼주기
            else{
                map1.put(top, map1.get(top) - 1);
            }
            
            if(map1.size() == map2.size()){
                answer++;
            }
        }
        
        return answer;
    }
}