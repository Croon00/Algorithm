import java.util.*;
class Solution {
    static boolean [][] visited;
    static int [][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int solution(int[][] maps) {
        
        // ROR 게임은 두 팀으로 나누어서 진행하며, 상대 팀 진영을 먼저 파괴하면 이기는 게임
        // 각 팀은 상대 팀 진영에 최대한 빨리 도착하는 것이 유리
        
        visited = new boolean[maps.length][maps[0].length];
        
        int answer = bfs(0, 0, maps);
        return answer;
    }
    
    static int bfs(int x, int y, int [][] maps){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        queue.offer(y);
        queue.offer(1);
        
        while(!queue.isEmpty()){
            int r = queue.poll();
            int c = queue.poll();
            int cnt = queue.poll();
            
            if(r == maps.length - 1 && c == maps[0].length - 1){
                return cnt;
            }
            for(int i = 0; i < 4; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                
                // 범위 넘어가면 건너띄기
                if(nr < 0 || nc < 0 || nr >= maps.length  || nc >= maps[0].length) continue;
                // 이미 왔던 곳이면 건너띄기
                if(visited[nr][nc]) continue; 
                // 벽인 곳은 건너띄기
                if(maps[nr][nc] == 0) continue; 
                
                // 방문 체크하고 다음 이동
                visited[nr][nc] = true;
                queue.offer(nr);
                queue.offer(nc);
                queue.offer(cnt + 1);
            }
        }
        return -1;
    }
}