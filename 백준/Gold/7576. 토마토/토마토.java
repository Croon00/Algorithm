import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // N 행 , M 열
    static int N, M, maxDay;
    // 방향 보기
    static int [][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    // 토마토
    static int [][] tomato;
    // 안익은 토마토 남았는지
    static boolean check = true;

    // bfs에서 쓰일 queue
    static Queue<Integer> queue = new LinkedList<>();


    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomato = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                tomato[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();

        // 0이 없는지 확인
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(tomato[i][j] == 0){
                    check = false;
                    break;
                }
            }
        }
        // 0이 없을 경우
        if(check){
            System.out.println(maxDay);
        }
        // 0이 있을 경우
        else{
            System.out.println(-1);
        }

    }

    static void bfs(){
        // 큐가 빌때 까지

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(tomato[i][j] == 1){
                    // x좌표, y좌표, 지난 날 추가
                    queue.add(i);
                    queue.add(j);
                    queue.add(0);
                }
            }
        }

        while (!queue.isEmpty()){
            // x, y, 날짜 꺼내기
            int r = queue.poll();
            int c = queue.poll();
            int day = queue.poll();

            // 4방향을 탐색하여
            for(int k = 0; k < 4; k++){
                int nr = r + dir[k][0];
                int nc = c + dir[k][1];

                // 범위 안에 있을 때
                if(nr >= 0 && nr < N && nc >= 0 && nc < M){
                    // 익지 않은 토마토 가 있을때 익게 하고, 다음 좌표, 날짜 받기
                    if(tomato[nr][nc] == 0){
                        tomato[nr][nc] = 1;
                        queue.add(nr);
                        queue.add(nc);
                        queue.add(day + 1);
                    }
                }
            }
            // 최고 지난 날짜 max로 계속해서 받기
            maxDay = Math.max(maxDay, day);
        }
    }
}
