import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [][] noMix = new int[N + 1][N + 1];
        int ans = 0;
        // 해당 두 숫자 2차원 배열에 구하기
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int iceCream = Integer.parseInt(st.nextToken());
            int iceCream2 = Integer.parseInt(st.nextToken());
            // 반대로도 안되기 때문에 반대도 -1 넣기!!
            noMix[iceCream][iceCream2] = -1;
            noMix[iceCream2][iceCream] = -1;
        }
        // 3개 조합을 -1 인 경우에는 건너 띄우고 카운트 하기
        for(int i = 1; i <= N - 2; i++){
            for(int j = i + 1; j <= N - 1; j++){
                for(int k = j + 1; k <= N; k++){
                    if(noMix[i][j] == - 1 || noMix[i][k] == -1 || noMix[j][k] == -1 ){
                        continue;
                    }
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
