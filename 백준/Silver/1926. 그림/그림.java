import java.util.*;
import java.io.*;

public class Main {
    // 도화지 세로 크기 1 ~ 500
    // 가로 크기 1 ~ 500
    // 그림의 정보 0과 1이 공백을 두고 주어짐
    // 0은 색칠 안된 부분, 1은 색칠 된 부분
    // 가장 넓은 그림의 넓이 출력

    static class Point{
        int x, y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int [][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = 0;
        int m = 0;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 도화지
        int [][] board = new int[N][M];
        boolean [][] visited = new boolean[N][M];

        // 도화지 채우기
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        int cnt = 0;
        // 1을 발견 했을 때 bfs 돌려서 넓이 구하기
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i][j] == 1 && !visited[i][j]){
                    cnt++;
                    ans = Math.max(ans, bfs(board, i, j, visited));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n").append(ans);
        System.out.println(sb);

    }

    static int bfs(int [][] board, int r, int c, boolean[][] visited){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(r, c));
        visited[r][c] = true;
        int cnt = 1;

        while(!queue.isEmpty()){
            Point p = queue.poll();


            for(int i = 0; i < 4; i++){
                int nr = p.x + dir[i][0];
                int nc = p.y + dir[i][1];

                // 영역을 넘어가거나 이미 방문한 곳은 건너띄기
                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if(visited[nr][nc]) continue;

                // 1인 그림칠해진 경우
                if(board[nr][nc] == 1){
                    Point point = new Point(nr, nc);
                    queue.add(point);
                    visited[nr][nc] = true;
                    cnt++;

                }
            }
        }

        return cnt;
    }
}



