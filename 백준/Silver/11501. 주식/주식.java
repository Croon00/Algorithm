import java.util.*;
import java.io.*;

public class Main {

    // 주식
    // 주식을 하나 산다
    // 원하는 만큼 가지고 있는 주식을 판다.
    // 아무것도 안한다
    // 위에 세 가지 중 한 행동을 한다.

    //날 별로 주식의 가격을 알려주었을 때, 최대 이익이 얼마나 되는지 계산

    // 나는 미래를 다 알음으로 뒤에서 부터 자신 보다 낮은 것들은 다 사고 높으면 안 사기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 0; tc < T; tc++){
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            // 날별 주가
            int [] stock = new int[N]; // 100만 까지
            for(int i = 0; i < N; i++){
                stock[i] = Integer.parseInt(st.nextToken());


            }

            long ans = 0;

            int maxStock = stock[N - 1];
            for(int i = N - 2; i >= 0; i--){
                // 자신 보다 낮은 가격의 주식이면 사기
                if(maxStock > stock[i]) ans += maxStock - stock[i];
                // 자신 보다 높으면 maxStock값을 바꾸고 다음으로
                else{
                    maxStock = stock[i];
                }
            }
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}



