import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N; // 1 ~ 1만
    static int M; // 1 ~ 3억

    static int [] num;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        int R = 0;
        int sum = 0;
        int ans = 0;

        // 두 포인터 이용
        for(int L = 0; L < N; L++){
            // sum 에서 그 전 범위 빼기(
            if(L != 0) sum -= num[L - 1];


            // R + 1의 값이 범위를 넘지 않으면서 M보다 작을 때
            while (R < N && sum < M){
                sum += num[R++];
            }

            // M과 같으면 갯수 늘리기
            if(sum == M) ans++;
        }
        System.out.println(ans);
    }
}
