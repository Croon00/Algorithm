import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader fr = new FastReader();
    static int N, M, wall, ans;
    static int [][] lab, blank;
    static boolean visit[][];
    static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    static void input(){
        N = fr.nextInt();
        M = fr.nextInt();
        lab = new int[N + 1][M + 1];
        blank = new int[N * M + 1][2];
        visit = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= M; j++){
                lab[i][j] = fr.nextInt();
            }
        }

    }

    // 바이러스를 퍼뜨림
    static void bfs () {
        Queue<Integer> Q = new LinkedList<>();

        // 모든 바이러스가 시작점으로 가능하니 전부 큐에 넣어준다.
        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= M; j++){
                visit[i][j] = false;
                // lab의 위치가 바이러스인 경우
                if (lab[i][j] == 2){
                    Q.add(i);
                    Q.add(j);
                    visit[i][j] = true;
                }
            }
        }
        while (!Q.isEmpty()){
            // 행렬 형태 일때 행부터 뽑고 열부터 뽑으면 순서대로 계속 행/열 순서로 뽑는다.
            int x = Q.poll(), y = Q.poll();

            // 상하좌우 네 방향으로 바이러스 퍼지는 것을 확인
            for (int k = 0; k < 4; k++){
                int nx = x + dir[k][0], ny = y + dir[k][1];
                // 상하좌우의 값들이 적절하지 않은경우 건너띄기
                if(nx < 1 || ny < 1 || nx > N || ny > M){
                    continue;
                }
                // 빈 공간이 아닌 경우 건너띄기
                if(lab[nx][ny] != 0){
                    continue;
                }
                // 방문 했던 곳이면 건너띄기
                if(visit[nx][ny]){
                    continue;
                }
                visit[nx][ny] = true;
                Q.add(nx);
                Q.add(ny);

            }
        }
        // 탐색이 종료된 후 안전 영역의 넓이를 계산하고 정답을 갱신한다.
        int count = 0;
        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= M; j++){
                // 0이면서 방문하지 않은 곳은 바이러스가 들지 않는다.
                if(lab[i][j] == 0 && !visit[i][j]){
                    count++;
                }
            }
        }
        ans = Math.max(ans, count);
    }

    // idx 번째 빈 칸에 벽을 세울 것인지 결정해야 하고, 이전 까지 selected_count 개의 벽을 세웠다.
    static void dfs(int idx, int selected_count){
        if (selected_count == 3){ // 3 개의 벽을 모두 세운 상태
            bfs();
            return;
        }

        if (idx > wall){ // 더 이상 세울 수 있는 벽이 없는 상태
            return;
        }
        // 3개 보다 덜 고른 상태에서 idx 번지에 벽을 세울것인가 말것인가

        // lab에 빈칸을 가리키게 하고 1로 초기화 해준다.(벽 추가) 벽을 추가 했으니 selected_count 추가
        lab[blank[idx][0]][blank[idx][1]] = 1;
        dfs(idx + 1, selected_count + 1);

        // 이 위치에서 또한 안 세웠을 때의 경우도 확인 해준다.
        lab[blank[idx][0]][blank[idx][1]] = 0;
        dfs(idx + 1, selected_count);

    }


    static void pro() {
        // 벽을 놓을 수 있는 곳을 완전탐색을 하기 위한 벽을 모아놓기
        for (int i = 1; i <= N; i++){
            for ( int j = 1; j <= M; j++){

                // 빈 공간인 경우 벽 세우기
                if (lab[i][j] == 0){
                    wall++;
                    // 벽의 위치(i, j) 기억
                    blank[wall][0] = i;
                    blank[wall][1] = j;
                }
            }
        }
        // 벽을 3개 세우는 모든 방법 확인
        // (1번 빈집에부터 세울지 말지 결정하고, 아직 고른 상태 아님으로 0으로)
        dfs(1, 0);
        System.out.println(ans);
    }

    public static void main(String[] args) {
       input();
       pro();
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));

        }
        // 구분자를 가지고 받을 때, 기본 구분자 --> 공백
        String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        long nextLong(){
            return Long.parseLong(next());
        }

        // 구분자 없이 한 줄로 받을 때
        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}