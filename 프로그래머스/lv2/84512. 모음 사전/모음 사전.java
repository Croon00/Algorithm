import java.util.*;
class Solution {
    static List<String> dictionary;
    public int solution(String word) {
        // A E I O U 만을 사용하여 만들 수 있는, 길이 5 이하의 모든 단어가 수록
        // word가 매개변수로 주어질 때 몇 번째 단어인지 return
        
        // A E I O U를 완전탐색으로 배열에 넣어주고 배열 인덱스를 뽑기
        String [] str = {"A", "E", "I", "O", "U"};
        
        dictionary = new ArrayList<>();
        dfs(0,str, "");
        int answer = 0;

        for(int i = 0; i < dictionary.size(); i++){
            if(word.equals(dictionary.get(i))){
                answer = i + 1;
            }
        }
        
        return answer;
    }
    
    // 순서 o, 중복 o 
    static void dfs(int cnt, String [] str, String word){
        if(cnt > 0){
            dictionary.add(word);
        }
        // 길이가 5개가 되면 return 해서 끝낸다.
        if(cnt == 5){
            return;
        }
        
        // 중복 있음으로
        for(int i = 0; i < str.length; i++){
            dfs(cnt + 1, str, word + str[i]);
        }
    }
}