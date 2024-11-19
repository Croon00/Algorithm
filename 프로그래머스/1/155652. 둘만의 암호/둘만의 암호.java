/*
    s와 skip, 자연수 index
    s의 각 알파벳을 index 만큼 뒤의 알파벳으로 바꿈
    index만큼의 뒤의 알파벳 z를 넘어갈 경우 다시 a로 돌아감
    
    skip에 있는 문자열들은 뒤로 안 넘어감
*/

class Solution {
    public String solution(String s, String skip, int index) {
        
    
        String answer = "";
        // skip을 체크 하기위한 check 배열
        boolean [] check = new boolean [26];
        
        // skip에서 체크
        for(int i = 0; i < skip.length(); i++){
            int temp = skip.charAt(i) - 'a';
            check[temp] = true;
        }
        
        
        for(int i = 0; i < s.length(); i++){
            int temp = s.charAt(i);
            
            int cnt = 0;
            
            // index 만큼 채우기
            while(true){
                temp += 1;
                
                // z넘어가면 다시 a로
                if(temp > 'z') temp = 'a';
                
                int skipInt = temp - 'a';
                
                // skip에 있는 문자가 아닌 경우 카운트하기
                if(!check[skipInt]) cnt++;
                
                
                
                // index만큼 이동하면 끝내기
                if(cnt == index) break;
            }
            
            answer += (char) temp;
        }
        
        return answer;
    }
}