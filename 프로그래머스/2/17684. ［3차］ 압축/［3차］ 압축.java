import java.util.*;

class Solution {
    public int[] solution(String msg) {
        // LZW 압축 -->
        // 길이가 1인 모든 단어를 포함하도록 사전을 초기화
        // 사전에서 현재 입력과 일치하는 가장 긴 문자열 w 찾기
        // w에 해당하는 사전의 색인 번호를 출력, w를 제거
        // 입력에서 처리되지 않은 다음 글자 남아있다면 c, w + c에 해당하는 단어를 사전에 등록한다.
        

        
        List<String> word = new ArrayList<>();
        
        // 알파벳 넣기
        for(char i = 'A'; i <= 'Z'; i++){
            word.add(String.valueOf(i));
        }
        System.out.println(word);
        
        List<Integer> ans = new ArrayList<>();
        
        
        // 0번째 알파벳 부터 입력
        String w = String.valueOf(msg.charAt(0));
        int ansNum = 0;
        int index = 1;
        // msg끝으로 오면 끝
        while(true){
            
            // 다음 글자 알려주는 index 값이 msg 길이 넘은 경우
            if(index == msg.length()){
                for(int i = 0; i < word.size(); i++){
                    if(w.equals(word.get(i))) ans.add(i + 1);
                }
                break;
            }
            
            
            // 다음 알파벳
            String c = String.valueOf(msg.charAt(index));
            String temp = w + c;
            boolean flag = false;
            
            for(int i = 0; i < word.size(); i++){
                // 출력 값
                if(w.equals(word.get(i))) ansNum = i + 1;
                // 다음 글자를 더한 글자가 사전에 이미 있으면 현재 입력 바꾸기
                if(temp.equals(word.get(i))){
                    flag = true;
                    w = temp;
                    index++;
                }
            }
            // 다음 글자를 더한 글자가 사전에 없는 경우
            if(!flag){
                // 현재 입력한 값의 출력을 넣고
                // 현재 입력은 다음 글자부터 시작
                // 새로 사전에 추가
                ans.add(ansNum);
                w = c;
                index++;
                word.add(temp);
            }
            
            
            
        }
        int [] answer = ans.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}