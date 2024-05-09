class Solution {
    
    
    public int solution(String dirs) {
        // 게임 캐릭터 4가지 명령으로 움직임 
        // 0 ,0 위치에서 시작
        // 캐릭터가 처음 걸어본 길의 길이 구하기
        // 선을 이미 갔던 것으로 만들어야 함
    
        
        
        
        
        // board를 20 / 20 / 4방향 으로 배열 만들기
        boolean [][][] board = new boolean[11][11][4];
        
        // 시작 지점은 5, 5
        int Row = 5;
        int Col = 5;
        
        int answer = 0;
        
        for(int i = 0; i < dirs.length(); i++){
            // 해당 키워드를 받으면서 이동할 수 있을 때
            if(dirs.charAt(i) == 'L' && Col - 1 >= 0){
                // 아직 안가본 곳이면
                if(board[Row][Col][0] == false){
                    answer++;
                    board[Row][Col][0] = true;
                }
                Col--;
                board[Row][Col][2] = true;
            }
            else if(dirs.charAt(i) == 'U' && Row - 1 >= 0){
                
                if(board[Row][Col][1] == false){
                    answer++;
                    board[Row][Col][1] = true;
                }
                Row--;
                board[Row][Col][3] = true;
                
            }
            
            else if(dirs.charAt(i) == 'R' && Col + 1 < 11){
                
                if(board[Row][Col][2] == false){
                    answer++;
                    board[Row][Col][2] = true;
                }
                Col++;
                board[Row][Col][0] = true;
                
            }
            else if(dirs.charAt(i) == 'D' && Row + 1 < 11){
                
                if(board[Row][Col][3] == false){
                    answer++;
                    board[Row][Col][3] = true;
                }
                
                Row++;
                board[Row][Col][1] = true;
                
            }
        }
        
        return answer;
    }
}