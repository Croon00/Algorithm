import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N, M, K, ans;

    static int [][] map;
    static boolean [][] visited;
    static int [][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            // 가로길이, 세로길이, 배추 심어진 갯수
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            ans = 0;
            map = new int[N][M];
            visited = new boolean[N][M];
            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                map[Y][X] = 1;
            }
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(map[i][j] == 1 && !visited[i][j]){
                        bfs(i,j);
                        ans++;
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);

    }
    static void bfs(int x, int y){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        // 시작 좌표를 방문 체크
        visited[x][y] = true;

        // 큐 끝날때 까지 좌표, cnt 꺼내기
        while (!queue.isEmpty()){
            int r = queue.poll();
            int c = queue.poll();

            // 8방향으로
            for(int k = 0; k < 4; k++){
                int nr = r + dir[k][0];
                int nc = c + dir[k][1];

                // 방문하지 않은 곳이면 방문 하게
                if(nr >= 0 && nr < N && nc >= 0 && nc < M){
                    if(!visited[nr][nc] && map[nr][nc] == 1){
                        visited[nr][nc] = true;
                        // 좌표 넣기, cnt + 1 한 값 넣기
                        queue.add(nr);
                        queue.add(nc);
                    }
                }
            }
        }
    }
}