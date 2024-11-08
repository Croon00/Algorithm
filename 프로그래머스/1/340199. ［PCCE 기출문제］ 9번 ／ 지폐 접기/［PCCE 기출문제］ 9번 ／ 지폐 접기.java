/*
    민수는 다양한 지폐를 수집하는 취미
    지폐마다 크기가 다름, 지갑에 넣으려면 여러번 접기
    
    --> 접을때 항상 길이가 긴 쪽을 반으로 접기
    --> 잡기 전 길이가 홀수였다면 접은 후 소수점 버리기
    --> 접힌 지폐를 그대로 90도 돌려서 넣을 수 있으면 그만 접기
    
     최소 몇번 접어야 하는지
*/

class Solution {
    
    // wallet --> 지갑의 가로, 세로 크기
    // bill --> 지폐의 가로 세로 크기
    public int solution(int[] wallet, int[] bill) {
        
    
        int answer = 0;
        int wHeight = 0;
        int wWidth = 0;
        int bHeight = 0;
        int bWidth = 0;
        
        for(int i = 0; i < 2; i ++){
            wWidth = wallet[0];
            wHeight = wallet[1];
            bWidth = bill[0];
            bHeight = bill[1];
        }
        
        
        while(true){
            
            // 그냥 넣을때 가능하면 answer return
            if(wWidth - bWidth >= 0 && wHeight - bHeight >= 0){
                return answer;
            }
            
            // 안되는 경우 방향 바꾸어서 넣어보기 가능
            if(wWidth - bHeight >= 0 && wHeight - bWidth >= 0){
                return answer;
            }
                
            // 지폐 접기
            if(bWidth >= bHeight){
                bWidth = bWidth / 2;
                
            }
            else{
                bHeight = bHeight / 2;
            }
            answer++;
        }

    }
}