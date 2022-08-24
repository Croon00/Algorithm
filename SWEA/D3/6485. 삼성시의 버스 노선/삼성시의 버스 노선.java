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
            int N = Integer.parseInt(br.readLine());
            int [] station = new int[5001];
            for(int i = 1; i < N + 1; i++){
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                for(int j = A; j <= B; j++){
                    station[j]++;
                }
            }
            int P = Integer.parseInt(br.readLine());
            for(int i = 0; i < P; i++){
                int C = Integer.parseInt(br.readLine());
                sb.append(station[C] + " ");
            }

            System.out.println(sb);
        }
    }
}
