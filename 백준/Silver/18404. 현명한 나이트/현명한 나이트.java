import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N, M;
    static int x1, y1;
    static int x2, y2;
    static int [][] board;
    static boolean [][] visited;
    static int [][] dir = {{-1,-2}, {-2,-1},{-2,1},{-1,2},{1,-2},{2,-1},{2,1},{1,2}};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        bfs(x1, y1, 0);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            sb.append(board[x2][y2] + " ");

        }
        System.out.println(sb);

    }
    static void bfs(int x, int y, int count){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        queue.add(count);
        // 시작 좌표를 방문 체크
        visited[x][y] = true;

        // 큐 끝날때 까지 좌표, cnt 꺼내기
        while (!queue.isEmpty()){
            int r = queue.poll();
            int c = queue.poll();
            int cnt = queue.poll();

            // 8방향으로
            for(int k = 0; k < 8; k++){
                int nr = r + dir[k][0];
                int nc = c + dir[k][1];

                // 방문하지 않은 곳이면 방문 하게
                if(nr >= 0 && nr <= N && nc >= 0 && nc <= N){
                    if(!visited[nr][nc]){
                        visited[nr][nc] = true;
                        // 좌표 넣기, cnt + 1 한 값 넣기
                        queue.add(nr);
                        queue.add(nc);
                        board[nr][nc] = cnt + 1;
                        queue.add(cnt + 1);
                    }
                }
            }
        }
    }
}
