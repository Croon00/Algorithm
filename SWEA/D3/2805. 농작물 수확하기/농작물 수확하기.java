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
            int [][] farm = new int[N][N];
            int sum = 0;

            // for문으로 농작물 가치 받기
            for(int i = 0; i < N; i++){
                String worth = br.readLine();
                for(int j = 0; j < N; j++){
                    farm[i][j] = worth.charAt(j) -'0';
                }
            }
            // 위쪽 삼각형 받기
            for(int i = 0; i < N / 2; i++){
                // 시작 부분은 가운데에서 -i 한 부분, 끝 부분은 가운데에서 +i 한 부분
                for(int j = N/2-i; j <= (N/2+i); j++){
                    sum += farm[i][j];
                }
            }

            // 아래쪽 삼각형 받기
            for(int i = N / 2; i >= 0; i--){
                for(int j = N/2 -i; j <= N/2 +i; j++){
                    sum += farm[N -i - 1][j];
                }
            }
            sb.append(sum);
            System.out.println(sb);
        }
    }
}