class Solution {
    static int answer;
    static boolean[][] board;
    public int solution(int n) {
        
        
        answer = 0;
        
        // 가로길이에서 하나 두었을 때 
        // 그 다음 행 부터 끝 행 까지
        // 같은 열이면 x, 대각 선이면 x
        
        // n은 열, 들어 있는 값은 행의 값
        int [] arr = new int[n];
        
        nQueen(0, arr, n);
        
        return answer;
    }
   static void nQueen(int depth, int[] arr, int n){
       // 모든 열을 채운 경우 가능한 배치 ++
       if(depth == n){
           answer++;
           return;
       }
       
       for(int i = 0; i < n; i++){
           // 해당 열이 i행에 퀸이 놓일 경우
           arr[depth] = i;
           
           // 가능한 위치인 경우 다음 열로 넘어가서 체크 하기
           if(check(depth, arr)){
               nQueen(depth + 1, arr, n);
           }
       }
   }
    
    static boolean check(int col, int[] arr) {
        // 0번째 열 부터 해당 열 전 까지를 확인하면서
        for(int i = 0; i < col; i++){
            // 해당 열에 있는 값이랑 같은 행에 위치 하고 있는지 확인
            if(arr[col] == arr[i]){
                return false;
            }
            
            // 대각선 위 혹은 아래에 위치하고 있는지 확인
            // 열의 차와 행의 차가 같은 경우 대각선에 위치해있는 것이다.
            else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        
        
        return true;
    }
    
}