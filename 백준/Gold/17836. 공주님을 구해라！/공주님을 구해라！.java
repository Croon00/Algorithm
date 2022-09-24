
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // N 행 , M 열, 시간 T, 거리
    static int N, M, T,distance;
    static int minTime;
    static int[][] map;
    // 각 배열에 거리
    static int [][] dis;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    // 기본 방문 여부
    static boolean[][][] visited;
    // 그람 소유 여부
    static boolean gram = false;


    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dis = new int[N][M];
        visited = new boolean[N][M][2];
        distance = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 0,0 부터 bfs
        int ans = bfs(0,0, 0, 0);

        if(ans == -1){
            System.out.println("Fail");
        }
        else{
            System.out.println(ans);
        }


    }

    static int bfs(int x, int y, int time, int gram) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        queue.add(time);
        queue.add(gram);
        visited[x][y][0] = true;

        while (!queue.isEmpty()) {
            int r = queue.poll();
            int c = queue.poll();
            int t = queue.poll();
            int g = queue.poll();
            if(t > T){
                break;
            }

            if(r == N - 1 && c == M - 1){
                return t;
            }


            for (int k = 0; k < 4; k++) {
                int nr = r + dir[k][0];
                int nc = c + dir[k][1];
                // 범위 안에 있으면서
                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    // 그람 없을 때
                    if(g == 0){
                        if(!visited[nr][nc][0] && map[nr][nc] == 0){
                            queue.add(nr);
                            queue.add(nc);
                            queue.add(t + 1);
                            queue.add(0);
                        }
                        else if(!visited[nr][nc][0] && map[nr][nc] == 2){
                            queue.add(nr);
                            queue.add(nc);
                            queue.add(t + 1);
                            queue.add(1);
                        }
                        visited[nr][nc][0] = true;

                    }
                    // 그람 있을 때
                    else if(g == 1){
                        if(!visited[nr][nc][1]){
                            queue.add(nr);
                            queue.add(nc);
                            queue.add(t + 1);
                            queue.add(1);
                            visited[nr][nc][1] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}


