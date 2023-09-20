import java.util.*;
class Solution {
    static boolean [][] visited;
    static int [][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        // 서로다른 직사각형이 꼭지점에서 만나거나 겹치는 경우 없다
        // 2개 이상으로 분리되거나 완전히 포함되는 경우도 없다.
        
        // 이렇게 만들어진 겉에 변으로만 캐릭터가 이동을 할 수 있다.
        
        // 캐릭터 좌표와 item 좌표가 있을 때 캐릭터가 아이템을 줍기 위해 이동해야 하는 가장 짧은 거리
        
        // 큰 좌표에서 직사각형 안쪽을 번호를 채워 놓고 이것을 만나면 못가게 하면 되자나
        
        // 모든 좌표 값은 1 이상 50이하
        
        // 사이에 비어있는 모눈종이 값을 못 넣음으로 좌표를 * 2 해서 넣어준다.
        int [][] map = new int[102][102];
        visited = new boolean[102][102];
        for(int i = 0; i < rectangle.length; i++){
            int x = rectangle[i][0] * 2;
            int y = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;
            // 사각형 가로 2개
            for(int j = x; j <= x2; j++){
                // 아직 비어있는 곳이면 길 만들기
                if(map[y][j] == 0){
                    map[y][j] = 1;
                }
                if(map[y2][j] == 0){
                    map[y2][j] = 1;
                }
            }
            
            // 사각형 세로 2개
            for(int j = y; j <= y2; j++){
                if(map[j][x] == 0){
                    map[j][x] = 1;
                }
                if(map[j][x2] == 0){
                    map[j][x2] = 1;
                }
            }
            
            // 안쪽 사각형 넓이는 - 1로 채우기
            for(int j = x + 1; j < x2; j++){
                for(int k = y + 1; k < y2; k++){
                    map[k][j] = -1;
                }
            }
        }
        
        // for(int i = 0; i < 51; i++){
        //     for(int j = 0; j < 51; j++){
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        answer = bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2, map);
        
         
        
        
        return answer;
    }

    static int bfs(int characterX, int characterY, int itemX, int itemY, int[][] map){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(characterY);
        queue.offer(characterX);
        queue.offer(0);
        visited[characterY][characterX] = true;
        
        // bfs
        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();
            int cnt = queue.poll();
            // item 있는 좌표이면 cnt 리턴
            if(x == itemY && y == itemX){
                return cnt / 2;
            }
            
            for(int i = 0; i < 4; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                
                // 범위 넘어가거나 1이 아닌 구역이거나 방문 했던 곳이면 건너띄기
                if(nx < 0 || nx >= 102 || ny < 0 || ny >= 102) continue;
                if(map[nx][ny] != 1) continue;
                if(visited[nx][ny]) continue;
                
                // 방문 체크하고 다음 큐에 넣어주기
                visited[nx][ny] = true;
                queue.offer(nx);
                queue.offer(ny);
                queue.offer(cnt + 1);
            }
        }
        
        return 0;
    }
    
}