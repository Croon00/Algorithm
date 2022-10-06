import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int [][] map;

    static int [][] memo;


    static int [][] dir = {{-1,0}, {1,0}, {0,-1},{0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        memo = new int[M][N];


        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                memo[i][j] = -1;
            }
        }
        // 끝 부분 부터 시작하여서
        int ans = dfs(M - 1, N - 1);
        System.out.println(ans);
    }



    static int dfs(int row, int col){
        // 탑 다운 방식으로
        // 0,0에 도착하면

        if(row == 0 && col == 0){
            return 1;
        }

        // 메모이제이션
        if(memo[row][col] != -1){
            return memo[row][col];
        }

        // 해당 좌표로 가는 경로 값
        int result = 0;
        
        for(int k = 0; k < 4; k++){
            int nr = row + dir[k][0];
            int nc = col + dir[k][1];
            // 범위 안에 있으면서
            if(nr >= 0 && nr < M && nc >= 0 && nc < N){
                // 낮은 곳에서 높은 곳으로 만
                if(map[row][col] < map[nr][nc]){
                    // 탑 --> 바텀
                   result = result + dfs(nr, nc);
                }
            }
        }
        memo[row][col] = result;
        return result;
    }
}
