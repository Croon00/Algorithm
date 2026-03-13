/**
    알파벳 대문자로 종류
    n * m
    알파벳 하나로만 --> 지게차를 사용 출고 가능한거 뽑기
    BB처럼 같은 알파벳 두번 --> 모든 거 뽑기
    남은 컨테이너의 수 return
**/
import java.util.*;

class Solution {
    static boolean [][] deleted;
    
    public int solution(String[] storage, String[] requests) {
        
        int n = storage[0].length(); // 세로
        int m = storage.length; // 가로
        deleted = new boolean [m][n];
      
        for(String request : requests){
            if(request.length() == 1){
                oneAlphabet(storage, n, m, request);
            }
            else{
                twoAlphabet(storage, n, m, request);
            }
        }
        
        int answer = restNum(n, m);
        return answer;
    }
    
        static void oneAlphabet(String[] storage, int n, int m, String request){
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        char target = request.charAt(0);

        // 바깥 한 겹을 추가한 공간
        boolean[][] visited = new boolean[m + 2][n + 2];
        boolean[][] remove = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int k = 0; k < 4; k++){
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if(nx < 0 || nx >= m + 2 || ny < 0 || ny >= n + 2) continue;
                if(visited[nx][ny]) continue;

                // 패딩 영역(창고 바깥)
                if(nx == 0 || nx == m + 1 || ny == 0 || ny == n + 1){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
                else{
                    // 실제 storage 좌표로 변환
                    int sx = nx - 1;
                    int sy = ny - 1;

                    // 이미 삭제된 칸이면 빈 공간이므로 이동 가능
                    if(deleted[sx][sy]){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                    // 아직 안 지워진 컨테이너인데 target이면 삭제 후보
                    else if(storage[sx].charAt(sy) == target){
                        visited[nx][ny] = true;
                        remove[sx][sy] = true;
                    }
                }
            }
        }

        // 이번 요청에서 제거할 것들 한 번에 삭제
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(remove[i][j]){
                    deleted[i][j] = true;
                }
            }
        }
    }
 
    
    static void twoAlphabet(String[] storage, int n, int m, String request){
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(deleted[i][j] == true) continue;
                
                String str = storage[i];
                // 알파벳이 같다면 해당 deleted 부분 true
                if(str.charAt(j) == request.charAt(0)){
                    deleted[i][j] = true;
                }
            }
        }
    }
    
    
    static int restNum (int n, int m){
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!deleted[i][j]){
                    ans++;
                }
            }
        }
        
        return ans;
    }
}