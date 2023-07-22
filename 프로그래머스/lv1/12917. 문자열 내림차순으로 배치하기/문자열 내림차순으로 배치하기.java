import java.util.*;

class Solution {
    public String solution(String s) {
        Character [] ch = new Character[s.length()];
        String answer = "";

        for(int i = 0; i < s.length(); i++){
            ch[i] = s.charAt(i);
        }
        
        Arrays.sort(ch);
        
        for(int i = ch.length - 1; i >= 0;  i--){
            answer += String.valueOf(ch[i]);
        }
        return answer;
    }
}