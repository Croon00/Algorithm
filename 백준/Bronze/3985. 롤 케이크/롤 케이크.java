import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int [] cake = new int[L+1];
        // 가장 많은 예상 피스
        int predict_max = 0;
        // 가장 많은 피스를 가져가는 사람 예상
        int predict_human = 0;
        int max_human = 1;
        int max_cake = 0;
        // 번호

        // 사람 수 만큼
        for(int i = 1; i < N + 1; i++){
            int cnt = 0;
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // 가장 많은 조각을 가져갈 사람의 예상
            if(predict_max < K - P){
                predict_max = K - P;
                predict_human = i;
            }

            // P부분 부터 K 조각 까지 그 사람 번호 넣기
            for(int j = P; j <= K; j++) {
                // 0으로 번호가 안 붙여진 케이크만 붙임
                if(cake[j] == 0){
                    cake[j] = i;
                    cnt++;
                }
            }
            // 카운트가 더 큰 경우 max_cake 는 cnt
            if(max_cake < cnt){
                max_cake = cnt;
                max_human = i;
            }
        }

        sb.append(predict_human).append("\n");
        sb.append(max_human);
        System.out.println(sb);
    }
}
