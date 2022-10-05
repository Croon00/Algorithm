

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

        dfs(0,0,1,0);
        System.out.println(ans);
    }

    // 부분 수열로 구해야 한다.
    static void dfs(int idx, int cnt, int s, int b){

        // 재료가 N개 이상일 때
        if(cnt > N){
            return;
        }

        // 재료가 적어도 1개 이상일 때
        if(cnt > 0){

            ans = Math.min(ans, Math.abs(s - b));

        }

        for(int i = idx; i < N; i++){
            int ss = s * taste[i][0];
            int bb = b + taste[i][1];
            dfs(i + 1, cnt + 1, ss, bb);
            ss = 1;
            bb = 0;

        }

    }

}