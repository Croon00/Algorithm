import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
        영역 색칠부터 한 후
        빈 곳에 대해서 bfs를 하면서 영역 갯수 세고, List에 영역 칸 수 세기
     */
    static int N;
    static int M;
    static int K;
    static int [] x1;
    static int [] y1;
    static int [] x2;
    static int [] y2;
    static boolean [][] visited;
    static int dir [][] = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static List<Integer> area = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        x1 = new int[K];
        y1 = new int[K];
        x2 = new int[K];
        y2 = new int[K];

        visited = new boolean[M][N];

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            x1[i] = Integer.parseInt(st.nextToken());
            y1[i] = Integer.parseInt(st.nextToken());
            x2[i] = Integer.parseInt(st.nextToken());
            y2[i] = Integer.parseInt(st.nextToken());
        }

        // 색칠된 부분
        for(int i = 0; i < K; i++){
            for(int j = x1[i]; j < x2[i]; j++){
                for(int k = y1[i]; k < y2[i]; k++){
                    visited[j][k] = true;
                }
            }
        }

        // 맵 보면서 bfs하기
        for(int i = 0; i < M; i++){
            for(int j = N - 1; j >= 0; j--){
                // 색칠 안된 곳만
                if(!visited[i][j]){
                    bfs(i, j);
                }
            }
        }

        // 출력
        System.out.println(area.size());
        StringBuilder sb = new StringBuilder();
        // 오름 차순으로 정렬
        Collections.sort(area);
        for(int i = 0; i < area.size(); i++){
            sb.append(area.get(i)).append(" ");
        }
        System.out.println(sb);
    }

    // bfs
    static void bfs(int x, int y){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        // 자기 색깔 칠하기
        visited[x][y] = true;
        // 자기 자신 +1 부터 시작
        int cnt = 1;

        while(!queue.isEmpty()){
            int row = queue.poll();
            int col = queue.poll();

            for(int i = 0; i < 4; i++){


                int r = row + dir[i][0];
                int c = col + dir[i][1];

                // 범위 넘어가거나 이미 색칠된 영역이면 건너띄기
                if(r < 0 || r >= M || c < 0 || c >= N || visited[r][c]) continue;

                // 영역 색칠한 후 지역 추가, 영역 칸 갯수++
                visited[r][c] = true;
                queue.add(r);
                queue.add(c);
                cnt++;
            }
        }
        area.add(cnt);
    }
}
