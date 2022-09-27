import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, ans, cnt;
    static int H, W, Sr, Sc, Fr, Fc;
    static int [][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static boolean [][] visited;

    static int [][] map;

    static boolean check;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 2][M + 2];
        ans = 0;
        cnt = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true){
            boolean flag = false;
            loop:
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= M; j++){
                    if(map[i][j] == 1){
                        bfs(0,0);
                        flag = true;
                        ans++;
                        break loop;
                    }
                }
            }
            if(!flag){
                break;
            }
        }
        System.out.println(ans);
        System.out.println(cnt);

    }
    static void bfs(int x, int y){
        visited = new boolean[N + 2][M + 2];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        visited[x][y] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int r = queue.poll();
            int c = queue.poll();

            for(int k = 0; k < 4; k++){
                int nr = r + dir[k][0];
                int nc = c + dir[k][1];

                if(nr >= 0 && nr < N + 2 && nc >= 0 && nc < M + 2){
                    // 방문하지 않은 곳 중에
                    if(!visited[nr][nc]){
                        visited[nr][nc] = true;
                        if(map[nr][nc] == 1){
                            count++;
                            map[nr][nc] = 0;
                        }
                        else{
                            queue.add(nr);
                            queue.add(nc);
                        }
                    }
                }
            }
        }
        cnt = Math.min(cnt, count);
    }
}
