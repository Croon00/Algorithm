import java.util.*;
class Solution {
    
    static boolean [] visited;
    static int ans;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        ans = 0;
        // begin, target 단어의 집합 words있다.
        // 가장 짧은 words안에 있는 단어로 변환하여 target단어 만들기
        
        visited = new boolean[words.length];
        dfs(begin, target, 0, words);
        answer = ans;
        
        return answer;
    }
    
    static void dfs(String word, String target, int cnt, String[] words){
        if(word.equals(target)){
            ans = cnt;
            return;
        }
        
        // 단어끼리의 비교
        for(int i = 0; i < words.length; i++){
            if(visited[i]) continue; // 이미 바꾼 알파벳이면 안바꾸게
            int diff = 0;
            // 단어 안에서 알파벳 끼리 비교
            for(int j = 0; j < word.length(); j++){
                if(word.charAt(j) != words[i].charAt(j)) diff++;
            }
            
            // 알파벳 차가 1개 나면 단어 바꾸고 cnt + 1하기
            if(diff == 1){
                visited[i] = true;
                dfs(words[i], target, cnt + 1, words);
                visited[i] = false;
            }
        }
    }
}