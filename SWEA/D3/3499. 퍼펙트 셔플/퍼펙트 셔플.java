import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringBuilder sb = new StringBuilder();
            sb.append("#" + tc + " ");
            int N = Integer.parseInt(br.readLine());
            String [] card = new String[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                card[i] = st.nextToken();
            }
            // 전에 카드를 넣어줄 index
            int pre = 0;
            // 짝수인 경우
            if(N % 2 == 0){
                pre = N/2;
            }
            // 홀수인 경우
            else{
                pre = N/2 +1;
            }
            // 전 카드와 후 카드 배열
            String [] preCard = new String[pre];
            String [] afterCard = new String[N - pre];
            for(int i = 0; i < pre; i++){
                preCard[i] = card[i];
            }
            // 후 카드 인덱스
            int cnt = pre;
            for(int i = 0; i < N-pre; i++){
                afterCard[i] = card[cnt++];
            }
            // 후 카드 인덱스 만큼 추가
            for(int i = 0; i < N - pre; i++){
                sb.append(preCard[i] + " ");
                sb.append(afterCard[i] + " ");
            }
            // 카드 수가 홀수 인경우 전카드의 마지막 카드 추가
            if(N % 2 !=0){
                sb.append(preCard[preCard.length-1]);
            }
            System.out.println(sb);
        }
    }
}