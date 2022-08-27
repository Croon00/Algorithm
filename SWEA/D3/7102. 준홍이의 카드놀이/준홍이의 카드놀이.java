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
            StringBuilder sb = new StringBuilder();
            sb.append("#" + tc + " ");
            st = new StringTokenizer(br.readLine());
            // N 카드와 M 카드 받기
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            // 4 <= N, M <= 20임으로 제일 큰 수가 40
            int [] sum = new int[41];
            int maxPercentage = 0;
            // 반복문을 돌면서 각각 1~20 전부를 더한 후 해당 숫자를 ++
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= M; j++){
                    sum[i+j]++;
                }
            }
            // 최소 2부터 40까지 가장 많이 나올 빈도를 찾는다.
            for(int i = 2; i < 41; i++){
                maxPercentage = Math.max(maxPercentage, sum[i]);
            }
            // 해당 빈도를 가진 값의 i를 append
            for(int i = 2; i < 41; i++){
                if(sum[i] == maxPercentage){
                    sb.append(i + " ");
                }
            }
            System.out.println(sb);
        }
    }
}
