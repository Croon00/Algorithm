// 키를 몇 번 누르냐에 따라 나오는 값 최소 값으로 만들기
import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        // target을 최소 값으로 만들어야 함 
        // keymap 1 ~ 100개, 원소의 길이 1 ~ 100개 targets 1 ~ 100개, 원소의 길이 1 ~ 100개
        
        // 알파벳 배열을 만들어서 각 알파벳 키의 최소 걸리는 값을 넣어놓고 받기
        
        int [] keyCnt = new int[26];
        
        for(int i = 0; i < keyCnt.length; i++){
            keyCnt[i] = 150;
        }
        
        for(int i = 0; i < keymap.length; i++){
            String temp = keymap[i];
            
            for(int j = 0; j < temp.length(); j++){
                char tempChar = temp.charAt(j);
                // 해당 알파벳 인덱스가 들어있는 값이 현재 누르는 키 횟수에 비해 클 경우
                // 현재 누르는 키 횟수로 변경
                int keyIndex = tempChar - 'A';
                keyCnt[keyIndex] = Math.min(j + 1, keyCnt[keyIndex]);
            }
        }
        
        
        
        for(int i = 0; i < targets.length; i++){
            String temp = targets[i];
            for(int j = 0; j < temp.length(); j++){
                Character tempChar = temp.charAt(j);
                
                int CharIndex = tempChar - 'A';
                // 150인경우 해당 키가 없었음으로 -1,
                // 해당 키 최소 값을 answer에 더해준다
                if(keyCnt[CharIndex] == 150){
                    answer[i] = -1;
                    break;
                
                }else{
                    answer[i] += keyCnt[CharIndex];
                }
            }
        }
        
        return answer;
    }
}