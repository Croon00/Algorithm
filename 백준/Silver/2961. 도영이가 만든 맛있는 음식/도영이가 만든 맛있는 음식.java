

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] taste;
    static int [] cooked;
    static boolean [] visited;
    static int ans;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        // [0]에 신맛, [1]에 쓴맛
        taste = new int[N][2];

        visited = new boolean[N];
        cooked = new int[2];
        ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sour = Integer.parseInt(st.nextToken());
            int bitter = Integer.parseInt(st.nextToken());
            taste[i][0] = sour;
            taste[i][1] = bitter;
        }

        dfs(0);
        System.out.println(ans);
    }

    // 부분 수열로 구해야 한다.
    static void dfs(int cnt){
        // 전부 골랐을 때
        if(cnt == N){
            int s = 1;
            int b = 0;
            int temp = 0;
            for(int i = 0; i < N; i++){
                // 체크 된 재료들만
                if(visited[i]){
                    temp++;
                    s *= taste[i][0];
                    b += taste[i][1];
                }
            }
            // 재료가 1개 이상이라도 사용 되어야 함.
            if(temp >= 1){
                ans = Math.min(ans, Math.abs(s - b));
            }
            return;
        }

        // 해당 원소를 가져가냐 안 가져가냐
        visited[cnt] = true;
        dfs(cnt + 1);
        visited[cnt] = false;
        dfs(cnt + 1);

    }

}