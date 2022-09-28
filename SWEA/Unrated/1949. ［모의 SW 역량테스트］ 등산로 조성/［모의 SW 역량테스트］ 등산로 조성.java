
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder sb = new StringBuilder();
    static int N, K, ans;
    static int maxPeak;
    static int [][] map;
    static int [][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static boolean [][] visited;
    static Queue<Integer> high = new LinkedList<>();



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            sb.append("#" + tc + " ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            visited = new boolean[N][N];
            maxPeak = 0;
            ans = 0;
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxPeak = Math.max(maxPeak, map[i][j]);
                }
            }

            // 최고봉 인 것들 큐에 넣기
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(map[i][j] == maxPeak){
                        visited[i][j] = true;
                        dfs(i, j, maxPeak,1, 0);
                        visited[i][j] = false;
                    }
                }
            }


            sb.append(ans).append("\n");

        }
        System.out.println(sb);

    }

    // down == 0 이면 공사 안 한거, 1이면 공사 기회 쓴거
    static void dfs(int x, int y, int height, int cnt, int down){

        ans = Math.max(cnt, ans);

        for(int k = 0; k < 4; k++){
            int nr = x + dir[k][0];
            int nc = y + dir[k][1];
            // 범위 안에 있으면서 방문 체크 안 했을 경우
            if(nr >= 0 && nr < N && nc >= 0 && nc < N){
                if(!visited[nr][nc]) {
                    // 경사가 낮은 고싱면
                    if (height > map[nr][nc]) {
                        visited[nr][nc] = true;
                        dfs(nr, nc, map[nr][nc],cnt + 1, down);
                        visited[nr][nc] = false;

                    }
                    // 경사가 더 높거나 같은 곳이면
                    else {
                        // 아직 공사 기회 안 썼을 때
                        if (down == 0) {
                            // 현재 높이가 이동하려는 높이 보다 높아졌을 대
                            if (height > map[nr][nc] - K) {
                                visited[nr][nc] = true;
                                dfs(nr, nc, height-1, cnt + 1, down + 1);
                                visited[nr][nc] = false;
                            }
                        }
                    }
                }
            }
        }
    }

}
