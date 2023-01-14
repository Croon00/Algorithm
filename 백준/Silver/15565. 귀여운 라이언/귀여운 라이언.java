import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
        고정된 수열에서 라이언 갯수 세서
        K개 이상의 라이언 을 가진 수열의 길이 출력하기
     */
    static int N; // 1 ~ 100만
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
        // 최대 라이언 갯수는 100만개 임으로 100만1
        int ans = 1000001;
        // 라이언 인형 갯수 세기
        int rionCnt = 0;

        // N에서 K + 1을 뺀 만큼만 가능
        for(int L = 0; L < N; L++){
            // 0이 아닌 경우에 전에 거 빼기
           if(L != 0) {
               sum--;
               // 전에 것이 라이언 인형이 었을 경우
               if(num[L - 1] == 1){
                   rionCnt--;
               }
           }

           // R이 범위를 넘지 않으면서 K 미만의 라이언 인형일 경우 계속 R++하면서 이동
           while (R < N && rionCnt < K){
               // 라이언 인형일 경우 세기
               if(num[R++] == 1) rionCnt++;
               sum++;
           }

           // k개 이상의 라이언 인형을 포함하는 가장 작은 연속된 인형들의 집합 크기
            if(rionCnt == K){
                ans = Math.min(ans, sum);
            }
        }

        // 한 번이라도 갱신 되었으면 그 값 
        if(ans != 1000001) System.out.println(ans);
        // 라이언 인형이 K 개 이상 없을 경우 -1 출력
        else System.out.println(-1);
    }
}
