import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        // 단 한 명의 선수를 제외하고는 모든 선수가 마라톤 완주함
        // 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때
        // 완주하지 못한 선수의 이름을 return
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String p : participant){
            // map 에서 getOrDEfault --> get으로 p 키 값이 있으면 그것을 가져오고 아니면 0으로 해서 가져온다.
            map.put(p, map.getOrDefault(p, 0) + 1); // 해당 이름의 밸류 값을 +1 씩해서 키밸류 넣기
        }
        
        for(String c : completion){
            map.put(c, map.get(c) - 1); // 해당 이름의 밸류 값을 - 1 해준다.
        }
        
        String answer = "";
        for(String key : map.keySet()){
            // 0이 아닌 경우에 통과 못함
            if(map.get(key) != 0){
                answer += key;
            }
        }
        return answer;
    }
}