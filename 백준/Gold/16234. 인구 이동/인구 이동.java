import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // N 행 , M 열
    static int N, L, R;
    // 방향 보기
    // 자신이 짝수 일때 방향보기
    static int[][] country;
    // 자신이 홀수 일때 방향보기
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    // 방문 여부
    static boolean[][] visited;
    // 열린 국가들
    static boolean[][] open;

    static int people, cnt, ans;

    static boolean flag = false;


    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        country = new int[N][N];
        ans = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                country[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true) {
            // 방문 체크, flag 초기화
            visited = new boolean[N][N];
            flag = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j]){
                        bfs(i,j);
                    }
                }
            }
            // 인구 이동이 한 번도 안 일어났으면 break;
            if (!flag) {
                break;
            }
            // 인구 이동이 일어났으면 정답++
            else{
                ans++;
            }
        }

        System.out.println(ans);
    }

    static void bfs(int x, int y) {
        // 열린 국경 초기화
        open = new boolean[N][N];

        // 인구수 초기화 해주고, 방문 체크 해준 후, 인구이동 횟수를 셀 cnt =1로 초기화(나누기 해주기 위해)
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        people = country[x][y];
        visited[x][y] = true;
        cnt = 1;

        while (!queue.isEmpty()) {
            int r = queue.poll();
            int c = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nr = r + dir[k][0];
                int nc = c + dir[k][1];
                // 범위 안에 있으면서
                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    // 각 좌표에 있는 인구 차의 절대 값이 L 이상이면서 R 이하인 경우
                    if (Math.abs(country[r][c] - country[nr][nc]) >= L && Math.abs(country[r][c] - country[nr][nc]) <= R) {
                        // 방문하지 않았으면서 열리지 국경만
                        if (!visited[nr][nc] && !open[nr][nc]) {
                            // 해당 좌표 인구를 누적해서 더하기, 열린 국경만큼 cnt++
                            people += country[nr][nc];
                            cnt++;
                            // 해당 좌표의 국경을 방문체크 해주고, 큐에 좌표 추가
                            open[r][c] = true;
                            open[nr][nc] = true;
                            queue.add(nr);
                            queue.add(nc);
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
        }
        // 국경이 한 번이라도 열렸으면 flag = true
        if (cnt > 1) {
            flag = true;
            // 인구 분배
            people = people / cnt;
            // 열린 국경 인구 분배하기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (open[i][j]) {
                        country[i][j] = people;
                    }
                }
            }
        }
    }
}

