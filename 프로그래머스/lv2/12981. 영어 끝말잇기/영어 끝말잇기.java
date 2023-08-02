import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int [] wordsCnt = new int[n];
        wordsCnt[0]++; // 첫 번째 사람 단어 늘리기
        List<String> str = new ArrayList<>();
        str.add(words[0]); // 첫 번째 단어 
        // 단어의 갯수만큼
        
        for(int i = 1; i < words.length; i++){
            wordsCnt[i % n]++; // 현재 단어 말 한 사람의 갯수 늘리기
            
            // 현재 단어가 앞에 단어 마지막 알파벳과 같은지 확인
            if(words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)){
                // 다른 경우 n으로 나눈 나머지의 + 1
                answer[0] =  (i % n) + 1;
                answer[1] =  wordsCnt[i % n];
                break;
            }
            // 현재  단어가 이미 나온 단어인지 확인
            else if(str.contains(words[i])){
                answer[0] =  (i % n) + 1;
                answer[1] =  wordsCnt[i % n];
                break;
            }
            
            // 둘다 아닌경우 단어 늘리기
            str.add(words[i]);

        }

        return answer;
    }
}