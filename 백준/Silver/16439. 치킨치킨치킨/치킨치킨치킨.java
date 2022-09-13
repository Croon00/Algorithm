import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // N의 사람, M 개의 치킨, 가장 높은 만족도
    static int N, M, maxSatisfaction;
    // 치킨 만족도
    static int[][] chickenTaste;
    // 재귀에서 방문 했는지 체크
    static boolean [] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maxSatisfaction = 0;
        // 치킨만족을 2차원 배열로, 사람 마다 치킨 만족도 받기
        chickenTaste = new int[N][M];
        // 이미 방문한 치킨 만족도를 구하기 위한 만족도 M
        visited = new boolean[M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                chickenTaste[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rec(0, 0);
        System.out.println(maxSatisfaction);
    }

    static void rec(int cnt, int idx){
        // 3개의 맛을 골랐을 경우
        if(cnt == 3){
            // n명의 가장 큰 만족감을 골랐을 경우 값 sum
            int sum = 0;
            for(int i = 0; i < N; i++){
                // 해당 사람의 visited인 치킨 만족도 중 가장 맛있는 만족도를 담을 satisfaction
                int satisfaction = 0;
                for(int j = 0; j < M; j++){
                    // 방문 된 만족도 값인 경우에만 max로 비교해서 넣기
                    if(visited[j]){
                        satisfaction = Math.max(chickenTaste[i][j], satisfaction);
                    }
                }
                // sum에 누적으로 만족도 더하기
                sum += satisfaction;
            }
            // 최종 만족도는 sum과 비교해서 max 값 넣기
            maxSatisfaction = Math.max(maxSatisfaction, sum);
            return;
        }
        else{
            // 치킨 갯수만큼 재귀로 반복문
            for(int i = idx; i < M; i++){
                // 해당 i가 방문하지 않았을 때만 재귀로 
                if(!visited[i]){
                    visited[i] = true;
                    rec(idx + 1, cnt + 1);
                    visited[i] = false;
                }
            }
        }
    }
}

