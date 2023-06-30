import java.util.*;
import java.io.*;

public class Main {
    /*
    알고스팟 운영진 모두 N * M 크기의 미로에 갇힘
    미로는 빈 방 또는 벽으로 이루어져있다.
    빈 방은 자유롭게 다닐 수 있지만, 벽은 부수지 않으면 이동할 수 없다.

    한 방에 모두 있어야 한다.

    이동할 수 있는 방은 상하좌우 인접한 빈 방

    현재 (1,1)에서 (N, M)으로 이동하려면 벽을 최소 몇 개 부수어야 하는지지

    최단 거리가 아닌 최소의 벽을 부순 것을 확인해야 함으로 우선순위 큐를 사용
    */
    static class Point implements Comparable<Point> {
        int r;
        int c;
        int breakWallCnt;

        public Point(int r, int c, int breakWallCnt){
            this.r = r;
            this.c = c;
            this.breakWallCnt = breakWallCnt;
        }

        public int compareTo(Point o){
            return this.breakWallCnt - o.breakWallCnt;
        }

    }

    // 이동 하는 곳
    static int [][] dir = {{-1,0}, {0, -1}, {0, 1}, {1, 0}};
    static int [][] miro;
    static int N, M;
    static int [][] cnt;
    static boolean [][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        miro = new int[M + 1][N + 1];
        cnt = new int[M + 1][N + 1];
        visited = new boolean[M + 1][N + 1];

        for(int i = 0; i < M; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                miro[i + 1][j + 1] = str.charAt(j) - '0';
            }
        }
        bfs();
        System.out.println(cnt[M][N]);
    }
    // bfs로 찾으면서 최소로 벽을 부수고 도착 한 경우 찾기
    static void bfs(){
        // 1,1에서 시작
        int row = 1;
        int col = 1;

        // 방문 체크 후 pq에 추가
        visited[1][1] = true;
        PriorityQueue<Point> pq = new PriorityQueue<>();

        pq.add(new Point(row, col, 0));

        while (!pq.isEmpty()){
            Point p = pq.poll();

            for(int i = 0; i < 4; i++){
                int nr = p.r + dir[i][0];
                int nc = p.c + dir[i][1];

                if(nr < 1 || nc < 1 || nr >= M + 1 || nc >= N + 1) continue;
                if(visited[nr][nc]) continue;

                visited[nr][nc] = true;

                // 벽인 경우
                if(miro[nr][nc] == 1){
                    pq.add(new Point(nr, nc, p.breakWallCnt + 1));
                    cnt[nr][nc] = p.breakWallCnt + 1;
                }
                // 벽이 아닌 경우에는 안 부서도 되니 그대로
                else{
                    pq.add(new Point(nr, nc, p.breakWallCnt));
                    cnt[nr][nc] = p.breakWallCnt;
                }
            }
        }
    }
}
