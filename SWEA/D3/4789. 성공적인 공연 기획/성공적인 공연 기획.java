import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        // 테케
        for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#" + tc + " ");
            String clap = br.readLine();
            // 사람 누적해서 더하기
            int human = 0;
            // 전체 기립박수 하는데 필요한 사람
            int need_human = 0;
            // clap 크기 만큼
            for(int i = 0; i < clap.length(); i++){
                // i 번째에 있는 사람은 박수를 치려면 i만큼 사람이 있어야 함으로
                // 현재 누적된 사람 - i 가 0보다 적으면
                if(human - i < 0){
                    // 필요한 사람은 현재 누적된 사람 - i 만큼 필요
                    need_human += i - human;
                    // 누적 휴먼에도 해당 필요한 사람을 더해준다. (뒤에서 필요한 사람을 구하기 위해)
                    human += i - human;
                }
                // 현재 사람들은 이제 박수를 칠 수 있음으로 누적해서 더한다.
                human += Character.getNumericValue(clap.charAt(i));
            }
            sb.append(need_human);
            System.out.println(sb);
        }
    }
}
