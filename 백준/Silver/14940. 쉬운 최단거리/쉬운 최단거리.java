import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // N 행 , M 열, 시간 T, 거리
    static int N, M;

    static int[][] map;

    static int [][] ans;

    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    // 기본 방문 여부
    static boolean[][] visited;
    // 그람 소유 여부


    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2를 찾았을 경우
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 2){
                    if(!visited[i][j]){
                        bfs(i, j, 0);
                    }
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                   sb.append(-1 + " ");
                }
                else{
                    sb.append(map[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    // bfs
    static void bfs(int x, int y, int dis) {
        // x, y, 거리 넣기
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        queue.add(dis);
        map[x][y] = 0;
        visited[x][y] = true;


        while (!queue.isEmpty()){
            int r = queue.poll();
            int c = queue.poll();
            int d = queue.poll();
            for (int k = 0; k < 4; k++){
                int nr = r + dir[k][0];
                int nc = c + dir[k][1];

                // 거리 추가
                if(nr >= 0 && nr < N && nc >= 0 && nc < M){
                    if(!visited[nr][nc] && map[nr][nc] != 0){
                        visited[nr][nc] = true;
                        map[nr][nc] = (d+1);
                        queue.add(nr);
                        queue.add(nc);
                        queue.add(d+1);
                        
                    }
                }
            }
        }
    }
}