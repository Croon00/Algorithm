import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
        마당에서 탈출 할 수 있으면 탈출 하고
        양의 수가 늑대 이하면 양은 다 잡혀먹힘
        BFS로 돌려서 양의 갯수와 늑대의 갯수를 센후
        수에 따라서 죽이고 살리기
     */
    static int R;
    static int C;

    static Character [][] map;
    static boolean [][] visited;
    static int [][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int totalSheep;
    static int totalWolf;




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new Character[R][C];

        for(int i = 0; i < R; i++){
            String str = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = str.charAt(j);
            }
        }

        visited = new boolean[R][C];
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                // 아직 방문하지 않았으면서 벽인 곳 빼고 bfs 돌리기
                if(!visited[i][j] && map[i][j] != '#'){
                    bfs(i, j);
                }
            }
        }
        System.out.println(totalSheep + " " + totalWolf);

    }

    static void bfs(int x, int y){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        int sheepCnt = 0;
        int wolfCnt = 0;

        if(map[x][y] == 'v') wolfCnt++;
        if(map[x][y] == 'o') sheepCnt++;
        visited[x][y] = true;

        while (!queue.isEmpty()){
            int r = queue.poll();
            int c = queue.poll();



            for(int i = 0; i < 4; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                // 맵 밖으로 나가거나 벽일 경우, 방문 했던 곳인 경우
                if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == '#') continue;
                if(visited[nr][nc]) continue;

                visited[nr][nc] = true;


                // v일 경우 늑대 추가, o일 경우 양 추가 후 queue 추가
                if(map[nr][nc] == 'v') wolfCnt++;
                if(map[nr][nc] == 'o') sheepCnt++;
                queue.add(nr);
                queue.add(nc);
            }
        }

        // 양의 수가 늑대 수 이상일 때는 양의 수 더하기
        if(sheepCnt > wolfCnt){
            totalSheep += sheepCnt;
        }
        // 늑대 수와 같거나 작을 때는 늑대 수 더하기
        else{
            totalWolf += wolfCnt;
        }

    }


}
