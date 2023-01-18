import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
        고슴도치가 한 마리 살고 있는데 비버 굴로 도망가야 한다.

        비어있는 곳 : .
        물이 차 있는 지역 : '*'
        돌 : 'X'
        굴 : 'D'
        고슴도치 : 'S'
     */
    static int R;
    static int C;
    static Character [][] map;
    static int [][] dir = {{-1,0}, {1,0},{0,-1},{0,1}};
    static boolean [][] visited;
    static int ans;
    static boolean flag = false;
    static int [][] time;
    static Queue<Integer> waterQ = new LinkedList();



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        time = new int[R][C];
        // 각 지역마다 물이 차는 시간
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                time[i][j] = Integer.MAX_VALUE;
            }
        }

        map = new Character[R][C];
        visited = new boolean[R][C];

        int gx = 0;
        int gy = 0;

        int cnt = 0;
        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j = 0; j < C; j++){
                map[i][j] = str.charAt(j);
                // 물 위치
                if(map[i][j] == '*'){
                    waterQ.add(i);
                    waterQ.add(j);
                    waterQ.add(0);
                    cnt++;
                }
                // 고슫모치 위치
                if(map[i][j] == 'S'){
                    gx = i;
                    gy = j;
                }
            }
        }
        // 물 먼저 다
        for(int i = 0; i < cnt; i++){
            int x = waterQ.poll();
            int y = waterQ.poll();
            int time = waterQ.poll();
            waterBfs(x, y, time);
        }
        bfs(gx, gy);
        if(flag) System.out.println(ans);
        else System.out.println("KAKTUS");

    }
    static void waterBfs(int xx, int yy, int times){
        boolean [][] waterVisited = new boolean[R][C];
        Queue<Integer> qq = new LinkedList<>();
        qq.add(xx);
        qq.add(yy);
        qq.add(times);

        while (!qq.isEmpty()){
            int x = qq.poll();
            int y = qq.poll();
            int cnt = qq.poll();
            // 처음 넣을 때는 다 넣기
            if(time[x][y] == Integer.MAX_VALUE){
                time[x][y] = cnt;
            }
            // 두 번째 물 찾았을 때는 더 짧은 시간에 되면 갱신하기
            else{
                if(time[x][y] > cnt){
                    
                    time[x][y] = cnt;
                }
            }

            for(int i = 0; i < 4; i++){

                int nr = x + dir[i][0];
                int nc = y + dir[i][1];

                // 범위 넘어가면 건너띄기
                if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                // 이미 물이거나 동굴이거나 돌이 있으면 건너띄기
                if(map[nr][nc] == '*' || map[nr][nc] == 'D' || map[nr][nc] == 'X') continue;

                if(waterVisited[nr][nc]) continue;

                waterVisited[nr][nc] = true;
                // 큐 더 넣기
                qq.add(nr);
                qq.add(nc);
                qq.add(cnt + 1);
            }
        }

    }

    static void bfs(int gx, int gy){

        Queue<Integer> gQ = new LinkedList<>();

        gQ.add(gx);
        gQ.add(gy);
        gQ.add(1);

        while (!gQ.isEmpty()){
            int x = gQ.poll();
            int y = gQ.poll();
            int cnt = gQ.poll();
            visited[x][y] = true;

            for(int i = 0; i < 4; i++){
                int nr = x + dir[i][0];
                int nc = y + dir[i][1];

                // 범위 넘어가면 건너띄기
                if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                // 이미 방문 한 곳은 안감
                if (visited[nr][nc]) continue;

                visited[nr][nc] = true;
                // 돌이 있는 곳은 못감
                if(map[nr][nc] == 'X') continue;
                // 이미 물이 찬 곳은 못 감

                if(cnt >= time[nr][nc]) continue;

                if(map[nr][nc] == 'D') {
                    ans = cnt;
                    flag = true;
                    break;
                }
                gQ.add(nr);
                gQ.add(nc);
                gQ.add(cnt + 1);
            }
        }
    }
}
