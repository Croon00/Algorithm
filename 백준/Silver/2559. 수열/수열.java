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


        int R = 0;
        int sum = 0;
        // 주어진 수는 -100 ~ 100 이고 N은 2 이상 10만 이하임으로 최소 값이 -1000만 임으로 -10000001로 둔다.
        int ans = -10000001;

        // N에서 K + 1을 뺀 만큼만 가능
        for(int L = 0; L < N - K + 1; L++){
            // 0이 아닌 경우에 전에 거 빼기
           if(L != 0) sum -= num[L - 1];

           // R의 값 부터 해당 날짜 더한 값까지
           while (R < L + K){
               sum += num[R++];
           }

           // 최대 값으로 변경
           ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }
}
