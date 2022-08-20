import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            StringBuilder sb = new StringBuilder();
            // a카드 와 b카드의 1~4의 갯수를 세기 위한 배열
            int [] a_card = new int[5];
            int [] b_card = new int[5];
            String winner = null;
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            // 카드 a 갯수만큼
            for(int j = 0; j < a; j++){
                a_card[Integer.parseInt(st.nextToken())]++;
            }

            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());

            // 카드 b 갯수만큼 받기
            for(int j = 0; j < b; j++){
                b_card[Integer.parseInt(st.nextToken())]++;
            }
            // 거꾸로 별인 4부터 갯수를 세서 더 큰 수가 있는 쪽에 넣고 값이 같을 경운 continue
            for(int j = 4; j > 0; j--){
                if(a_card[j] > b_card[j]){
                    winner = "A";
                    break;
                }
                else if(a_card[j] < b_card[j]){
                    winner = "B";
                    break;
                }
                else {
                    continue;
                }
            }
            // 아무것도 들어오지 않았으면 비긴것으로 D 추가
            if(winner == null){
                winner = "D";
            }

            System.out.println(winner);
        }
    }
}