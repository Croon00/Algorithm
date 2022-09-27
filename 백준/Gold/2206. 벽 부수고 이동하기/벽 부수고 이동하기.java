import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int [][] map;
    static int [][] distance;
    static boolean [][][] visited;


    static int [][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        distance = new int[N][M];
        visited = new boolean[N][M][2];


        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }
        // 0,0 좌표부터 1로 측정한다.
        distance[0][0] = 1;

        bfs(0,0,1,0);

        // 0인 경우 도달 못함
        if(distance[N-1][M-1] == 0){
            System.out.println(-1);
        }
        // 이외에 거리 보여주기
        else{
            System.out.println(distance[N - 1][M - 1]);
        }
    }

    // wallBreak == 0 이면 벽 부수기 안 쓴거, 1이면 벽 부수기 쓴거
    static void bfs(int x, int y, int d, int wallBreak){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        queue.add(d);
        queue.add(wallBreak);

        // 0,0 좌표는 방문함
        visited[x][y][0] = true;
        visited[x][y][1] = true;

        while (!queue.isEmpty()){
            int r = queue.poll();
            int c = queue.poll();
            int dis = queue.poll();
            int wb = queue.poll();
            for(int k = 0; k < 4; k++){
                int nr = r + dir[k][0];
                int nc = c + dir[k][1];
                // 맵 안에 있을 때만
                if(nr >= 0 && nr < N && nc >= 0 && nc < M){
                    // 벽 부수기 썼을 때
                    if(wb == 0){
                        // 방문 안 했을 때만
                        if(!visited[nr][nc][0]){
                            // 방문 체크
                            visited[nr][nc][0] = true;
                            // 이동할 수 있는 곳이면 걍 이동
                            if(map[nr][nc] == 0){
                                queue.add(nr);
                                queue.add(nc);
                                queue.add(dis + 1);
                                // 이미 들른 곳이면 최소 값 넣기
                                if(distance[nr][nc] != 0){
                                    distance[nr][nc] = Math.min(distance[nr][nc], dis+1);
                                }
                                // 아직 안 간 곳이면 dis + 1
                                else{
                                    distance[nr][nc] = dis + 1;
                                }
                                queue.add(0);

                            }
                            // 벽이면 벽 부수기 하고 이동
                            else{
                                queue.add(nr);
                                queue.add(nc);
                                queue.add(dis + 1);
                                // 이미 들른 곳이면 최소 값 넣기
                                if(distance[nr][nc] != 0){
                                    distance[nr][nc] = Math.min(distance[nr][nc], dis+1);
                                }
                                // 아직 안 간 곳이면 dis + 1
                                else{
                                    distance[nr][nc] = dis + 1;
                                }
                                queue.add(1);

                            }

                        }
                    }
                    else{
                        if(!visited[nr][nc][1] && map[nr][nc] == 0){
                            visited[nr][nc][1] = true;
                            queue.add(nr);
                            queue.add(nc);
                            queue.add(dis + 1);
                            // 이미 들른 곳이면 최소 값 넣기
                            if(distance[nr][nc] != 0){
                                distance[nr][nc] = Math.min(distance[nr][nc], dis+1);
                            }
                            // 아직 안 간 곳이면 dis + 1
                            else{
                                distance[nr][nc] = dis + 1;
                            }
                            queue.add(1);
                        }
                    }
                }
            }
        }
    }

}
