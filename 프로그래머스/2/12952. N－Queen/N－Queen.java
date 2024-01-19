class Solution {
    static int answer;
    static boolean[][] board;
    public int solution(int n) {
        
        
        answer = 0;
        
        // 가로길이에서 하나 두었을 때 
        // 그 다음 행 부터 끝 행 까지
        // 같은 열이면 x, 대각 선이면 x
        
        board = new boolean[n][n];
        
       
        nQueen(0, n);
        
        return answer;
    }
    static void nQueen(int depth, int n) {
        // 끝 행에 도착 했으면 가능한 퀸의 경우
        if(depth == n){
            answer++;
            return;
        }
        
        // 열을 넘기면서 하나씩 여왕 놓기
        for(int i = 0; i < n; i++){
            // 가능 하다면 다음 depth로 넘어가기
            if(check(depth, i, n)){
                board[depth][i] = true;
                nQueen(depth + 1, n);
                board[depth][i] = false;
            }
        }
    }
    
    
    static boolean check(int depth, int col, int n){
        
        int left = col;
        int right = col;
        
        for(int i = depth - 1; i >= 0; i--){
            // 위에 확인
            if(board[i][col]){
                return false;
            }
            
            // 왼쪽 위 확인
            left--;
            if(left >= 0 && board[i][left]){
                return false;
            }
            
            // 오른쪽 위 확인
            right++;
            if(right < n && board[i][right]){
                return false;
            }
        }
        
        return true;
    }
}