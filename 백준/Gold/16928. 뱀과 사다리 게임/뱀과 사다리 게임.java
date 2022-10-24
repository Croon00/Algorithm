
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int N, M;
    static int [] board;
    static boolean [] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        visited = new boolean[101];
        board = new int[101];
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 사다리 위치
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int ladderX = Integer.parseInt(st.nextToken());
            int ladderY = Integer.parseInt(st.nextToken());

            board[ladderX] = ladderY;

        }

        // 뱀 위치치
        for(int i  = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int snakeX = Integer.parseInt(st.nextToken());
            int snakeY = Integer.parseInt(st.nextToken());

            board[snakeX] = snakeY;

        }
        bfs(1, 0);

    }

    static void bfs(int x, int cnt){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(cnt);

        while (!queue.isEmpty()){
            int point = queue.poll();
            int count = queue.poll();

            if(point == 100){
                System.out.println(count);
                return;
            }

            // 주사위 1부터 6
            for(int i = 1; i <= 6; i++){
                int nextPoint = point + i;

                // 범위 넘어가거나 방문 한 곳이면
                if(nextPoint > 100 || visited[nextPoint]) continue;
                visited[nextPoint] = true;

                // 해당 좌표가 사다리나 뱀인 경우
                if(board[nextPoint] != 0){
                    queue.add(board[nextPoint]);
                    queue.add(count + 1);
                }

                else{
                    queue.add(nextPoint);
                    queue.add(count + 1);
                }

            }
        }
    }
}