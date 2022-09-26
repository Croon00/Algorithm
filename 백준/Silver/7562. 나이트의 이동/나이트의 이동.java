import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int L, ans;
    static int [][] board;
    static boolean [][] visited;
    static int [][] dir = {{-1,-2}, {-2,-1},{-2,1},{-1,2},{1,-2},{2,-1},{2,1},{1,2}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            L = Integer.parseInt(br.readLine());
            // L 길이의 행과 열, 방문 체크 초기화
            board = new int[L][L];
            visited = new boolean[L][L];
            // 정답 초기화
            ans = 0;
            // 나이트가 있는 곳을 1로
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = 1;

            // 가야할 곳을 2로
            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            board[x2][y2] = 2;

            // 나이트가 있는 좌표에서 0카운트로 시작
            bfs(x, y, 0);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
    static void bfs(int x, int y, int count){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        queue.add(count);
        // 시작 좌표를 방문 체크
        visited[x][y] = true;

        while (!queue.isEmpty()){
            int r = queue.poll();
            int c = queue.poll();
            int cnt = queue.poll();

            // 8방향으로
            for(int k = 0; k < 8; k++){
                int nr = r + dir[k][0];
                int nc = c + dir[k][1];

                // 방문하지 않은 곳이면 방문 하게
                if(nr >= 0 && nr < L && nc >= 0 && nc < L){
                    if(!visited[nr][nc]){
                        visited[nr][nc] = true;
                        // 0인 경우 계속 이동
                        if(board[nr][nc] == 0){
                            queue.add(nr);
                            queue.add(nc);
                            queue.add(cnt + 1);
                        }
                        // 2인 경우 가야할 곳 도착 했음으로 ans 바꾸어서서
                       else if(board[nr][nc] == 2){
                            ans = cnt + 1;
                            return;
                        }
                    }
                }
            }
        }
    }
}
