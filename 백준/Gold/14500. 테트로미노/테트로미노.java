
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int [][] map;
    static int [][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static boolean [][] visited;
    static int ans;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        ans = 0;
        visited = new boolean[N][M];


        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0 ; j < M; j++){
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.println(ans);



    }

    static void dfs(int r, int c, int cnt, int num){

        if(cnt ==  4){
            ans = Math.max(ans, num);
            return;
        }

        // 4개의 테트로미노를 해보면 결국 4방향으로 dfs하며 더한 값이 나온다.
        for(int i = 0; i < 4; i++){
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            // 범위 넘거나 방문 했으면 건너띄기
            if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]){
                continue;
            }

            // 5번째 보라색 테트로미노(ㅜ)는 가는 도중에 한번 내려갔따가 다시 올라감으로 이것을 설정해주어야 한다.
            if(cnt == 2){
                visited[nr][nc] = true;
                dfs(r, c, cnt + 1, num + map[nr][nc]);
                visited[nr][nc] = false;
            }


            visited[nr][nc] = true;
            dfs(nr, nc, cnt + 1, num + map[nr][nc]);
            visited[nr][nc] = false;
        }

    }

}