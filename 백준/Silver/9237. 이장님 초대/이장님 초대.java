import java.util.*;
import java.io.*;

public class Main {

    /*
        묘목 하나를 심는데 걸리는 시간은 1일
        마지막 나무가 다 자란 다음날 이장님을 초대
        나무를 심는 순서를 신중하게 골라 이장님을 최대한 빨리 초대

        며칠에 초대 가능?
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N;


        N = Integer.parseInt(br.readLine()); // 묘목의 수 1 ~ 100,000

        int [] tree = new int[N];
        st = new StringTokenizer(br.readLine());

        // 각 묘목이 다 자라는데 걸리는 시간
        for(int i = 0; i < N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }
        
        // 가장 오래 걸리는 묘목 부터 심자
        Arrays.sort(tree);
        // 심는 첫날, 다 자라는 마지막날 --> 2로 시작
        int cnt = 2;
        int grow = 0;
        for(int i = N - 1; i >= 0; i--){
            // 현재 나무들이 다 자라는데 필요한 날 / 현재 날 + 지금 나무가 다 자라는데 필요한 날
            // 둘을 비교해서 더 큰 값을 현재 나무들이 다 자라는데 필요한 날로 넣기
            grow = Math.max(grow, cnt + tree[i]);
            // 하루 지나기
            cnt++;
        }

        System.out.println(grow);

    }
}
