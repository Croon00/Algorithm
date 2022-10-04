

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int [][] map;
    static int [][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static boolean [][] visited;

    static int minCost = Integer.MAX_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        // N개의 줄에 N개씩 화단의 지점당 가격 (0 ~ 200)
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 0, 0 부터 0번째 꽃 부터, 0비용을 가지고 시작
        dfs(0,0);
        System.out.println(minCost);
    }

    // 조합으로 꽃이 필 곳 3개를 골라야 한다.
    // x, y좌표와 cnt
    static void dfs(int cnt, int cost){

        // 이미 정해진 비용보다 더 높을 경우는 넘어감
        if(minCost <= cost){
            return;
        }


        // 꽃 3개를 모두 심었을 경우
        if(cnt == 3) {
            minCost = Math.min(minCost, cost);
            return;
        }

        // 첫 번째 행이랑 끝 행과 첫 번째 열과 끝 열에는 꽃을 못 핌
        for(int i = 1; i < N - 1; i++){
            for(int j = 1; j < N - 1; j++){
                boolean flag = false;

                // 현재 있는 격자가 이미 방문한 곳이면 건너띄기
                if(visited[i][j]) continue;

                // 주위 4 방향을 보면서 이미 방문 한 곳이면 건너 띄기
                for(int k = 0; k < 4; k++){
                    int nr = i + dir[k][0];
                    int nc = j + dir[k][1];
                    if(visited[nr][nc]) {
                        flag = true;
                        break;
                    }
                }
                if(flag) continue;

                // 자신을 포함한 4방향의 비용을 더한 값
                int tempCost = map[i][j];

                // 현재 격자 방문 체크 해주고
                visited[i][j] = true;
                // 4방향을 보면서
                for(int k = 0; k < 4; k++){
                    int nr = i + dir[k][0];
                    int nc = j + dir[k][1];
                    // 해당 방향을 방문 체크 해주고
                    // 해당 방향 코스트를 누적해서 더 해준다.
                    visited[nr][nc] = true;
                    tempCost += map[nr][nc];
                }

                // cnt를 1 늘리고, 비용을 누적해서 더해준 값을 dfs 로 돌린다.
                dfs(cnt + 1, cost + tempCost);

                // 다음 얘들 부터는 다시 false 해주어서 계산 한다.
                visited[i][j] = false;
                for(int k = 0; k < 4; k++){
                    int nr = i + dir[k][0];
                    int nc = j + dir[k][1];
                    visited[nr][nc] = false;
                }
            }
        }
    }
}