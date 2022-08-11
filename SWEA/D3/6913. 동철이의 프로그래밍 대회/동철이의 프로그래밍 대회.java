import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#" + tc + " ");
            st = new StringTokenizer(br.readLine());
            // N명, M개 문제
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 제일 많이 풀은 문제 수
            int max_ans = -1;
            // 1등 한 사람의 수
            int max_idx = 1;
            // 사람 수 만큼
            for(int i = 0; i < N; i++){
                int sum = 0;
                st = new StringTokenizer(br.readLine());

                // 문제 수 만큼 푼 문제의 수 더하기
                for(int j = 0; j < M; j++){
                    int ans = Integer.parseInt(st.nextToken());
                    sum += ans;
                }

                if(max_ans == sum){
                    max_idx++;
                }

                // 최고로 푼 문제 수와 비교하여 넣고, 해당 사람의 번호 넣기
                if(max_ans < sum){
                    max_ans = sum;
                    max_idx = 1;
                }
            }
            sb.append(max_idx + " " + max_ans);
            System.out.println(sb);
        }
    }
}