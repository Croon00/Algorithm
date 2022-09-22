import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // N 행 , M 열
    static int W, H, meter;
    // 방향 보기
    // 자신이 짝수 일때 방향보기
    static int [][] evenDir = {{-1,-1,}, {-1,0}, {0,-1},{0,1},{1,-1},{1,0}};
    // 자신이 홀수 일때 방향보기
    static int [][] oddDir = {{-1,0},{-1,1},{0,-1},{0,1},{1,0},{1,1}};
    // 맵
    static int [][] map;
    // 방문 여부
    static boolean [][] visited;
    


    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        meter = 0;
        // 겉에 하나 더 싼 map
        map = new int[H + 2][W + 2];
        // 방문 여부
        visited = new boolean[H + 2][W + 2];
        // 1 부터 H, W 까지만 채우기
        for(int i = 1; i <= H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 0,0 부터 bfs 시작
        bfs(0,0);
        System.out.println(meter);

    }

    // bfs
    static void bfs(int i, int j){
        Queue<Integer> queue = new LinkedList<>();
        // 0, 0 부터 시작 하면서 방문 체크
        queue.add(i);
        queue.add(j);
        visited[i][j] = true;

        // 큐가 빌때 까지
        while (!queue.isEmpty()){
            // x, y
            int r = queue.poll();
            int c = queue.poll();


            // 6방향 탐색
            for(int k = 0; k < 6; k++){
                int nr, nc;
                // 현재 행이 짝수일 경우
                if(r % 2 == 0){
                    nr = r + evenDir[k][0];
                    nc = c + evenDir[k][1];
                }
                // 현재 행이 홀수일 경우
                else{
                    nr = r + oddDir[k][0];
                    nc = c + oddDir[k][1];
                }

                // 범위 안에 있을 때
                if(nr >= 0 && nr < H + 2 && nc >= 0 && nc < W + 2){
                    // 방문 안 했으면
                    if(!visited[nr][nc]){
                        if(map[nr][nc] == 0){
                            visited[nr][nc] = true;
                            queue.add(nr);
                            queue.add(nc);
                        }
                        else{
                            meter++;
                        }
                    }
                }
            }
        }
    }
}