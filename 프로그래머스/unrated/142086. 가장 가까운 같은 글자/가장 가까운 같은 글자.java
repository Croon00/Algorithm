class Solution {
    public int[] solution(String s) {
        // 문자열 s가 주어졌을 때 s의 각 위치마다 자신보다 앞에 나왔으며, 자신과 가장 가까운 곳에 있는 같은 글자 어딨는지
        
        // 각 문자를 아스키코드로 변형해서 그 해당 위치 넣기
        // 알파벳 26자 넣을 배열
        int [] index = new int[27];
        for(int i = 0; i < 27; i++){
            index[i] = -1;
        }
        
        int [] answer = new int[s.length()];
        
        
        for(int i = 0; i < s.length(); i++){
            Character alphabet = s.charAt(i);
            int alphabetIndex = alphabet - 'a';
            
            // 앞에 없었던 알파벳일 때
            if(index[alphabetIndex] == -1){
                // -1로 정답에 넣고
                answer[i] = -1;
                // 해당 위치를 넣어준다.
                index[alphabetIndex] = i;
            }
            else{
                // 앞에서의 나왔던 알파벳과의 거리 차이 넣기
                // 현재 위치로 갱신해준다.
                answer[i] = i - index[alphabetIndex];
                index[alphabetIndex] = i;
            }
        }
        
        return answer;
    }
}