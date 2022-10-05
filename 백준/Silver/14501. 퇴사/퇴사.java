

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, maxProfit;
    static int [][] consulting;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        consulting = new int[N + 1][2];
        // 최대 수익
        maxProfit = 0;

        // 상담에 걸리는 일 [0], 받을 수 있는 금액 [1]
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int Ti = Integer.parseInt(st.nextToken());
            int Pi = Integer.parseInt(st.nextToken());
            // (해당 날 짜 + 상담에 걸리는 일)이 퇴사날 이상이면 건너 띄기
            consulting[i][0] = Ti;
            consulting[i][1] = Pi;
        }

        // 1일 부터
        dfs(1,0);
        System.out.println(maxProfit);

    }


    static void dfs(int day, int benefit){

        // 날짜가 끝나는 날 이상이면 최대 이득을 갱신해보기
        if(day > N){
            maxProfit = Integer.max(maxProfit, benefit);
            return;
        }
        // 해당 day 부터 시작 해서
        for(int i = day; i <= N; i++){
            int d = consulting[i][0];
            int p = consulting[i][1];

            if(d == 0) continue;

            // 날짜가 퇴사날 이상이면 이득을 더하지 않고 넘긴다.
            if(i + d > N + 1){
                dfs(i + d, benefit);
                continue;
            }
            // 날짜가 아직 퇴사날 전이면 날짜 + d 하고, 이득을 더 하고 dfs()
            dfs(i + d, benefit + p);
        }

    }
}