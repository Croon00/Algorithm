import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N; // 1 ~ 10만
    static int K; // 1 ~ N

    static int [] num;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        num = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }


        // 주어진 수는 -100 ~ 100 이고 N은 2 이상 10만 이하임으로 최소 값이 -1000만 임으로 -10000001로 둔다.
        int ans = -10000001;

        // 두 포인터 이용
        for(int L = 0; L < N; L++){
            
            // 0부터 시작
            int sum = 0;
            // 날짜 세기
            int cnt = 0;
            // R은 L부터
            int R = L;

            // R 의 값이 범위를 넘지 않으면서 K번 날짜 이하 세었을 때는 계속 더하기
            while (cnt < K && R < N){
                sum += num[R++];
                cnt++;
            }

            // K번 까지 날자를 세었을 때만
            if(cnt == K) ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }
}
