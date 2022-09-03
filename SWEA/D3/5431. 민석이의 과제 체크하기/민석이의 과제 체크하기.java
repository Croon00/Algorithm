import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append("#" + tc + " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            boolean [] ans = new boolean[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < K; i++){
                ans[Integer.parseInt(st.nextToken()) - 1] = true;
            }
            for(int i = 0; i < N; i++){
                if(!ans[i]){
                    sb.append(i + 1 + " ");
                }
            }
            System.out.println(sb);
        }
    }
}
