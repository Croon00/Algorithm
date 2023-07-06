import java.util.*;
import java.io.*;

public class Main {

    /*
        정육면체 모양의 상자가 일렬로 늘어섬
        상자마다 크기 주어짐
        앞에 있는 상자의 크기가 뒤에 있는 상자의 크기보다 작으면, 앞에 있는 상자를 뒤에 있는 상자 안에 넣을 수 있다.
        (1, 5, 2, 3, 7)인 5개의, 상자 --> 1인 상자를 5인 상자에 넣고 그 다음 7에 넣을 수 있다.
        이 중에서 1, 2, 3, 7 상자를 고르면 총 4개의 상자가 한 개의 상자에 들어가게 된다.

        상자의 크기가 주어질 때 한 번에 넣을 수 있는 최대의 상자 개수를 출력하는 프로그램
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 1 ~ 1000
        int [] box = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            box[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 1;
        // 각 인덱스에서 그 전까지를 확인하면서 상자를 넣을 수 있는 개수를 세자
        int [] dp = new int[n + 1];
        // 자기 자신의 상자는 1개로 취급
        Arrays.fill(dp, 1);
        // 2번째 상자 부터
        for(int i = 2; i <= n; i++){
            for(int j = 1; j < i; j++){
                // 현재 인덱스에 박스 크기가 전에 있던 박스 보다 큰 경우
                if(box[i] > box[j]){
                    // dp[i] 값이 이전 박스 까지 쌓인 갯수인 dp[j] + 1 보다 작은 경우
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}
