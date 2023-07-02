import java.util.*;
import java.io.*;

public class Main {

    /*
        게임에 총 N 개의 레벨
        레벨 클리어 할 때마다 점수 주어짐
        레벨을 클리어 하면서 얻은 점수의 합으로 순위 매김
        레벨은 난이도 순으로 배치
        각 레벨 클리엏라 때 점수가 주어졌을 때 몇 번 감소시키면되는지

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N;

        N = Integer.parseInt(br.readLine());

        int [] score = new int[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            score[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        // 뒤에서 끝에 두번째 부터
        for(int i = N - 2; i >= 0; i--) {
            // 자기 뒤에 오는 값 보다 자기 값이 이상일 경우
            if (score[i] >= score[i + 1]) {
                // 다음 값 + 1 한 값을 현재 값에서 뺀 차를 구한다.
                // 그 차를 cnt에 누적 합하고 현재 값은 diff 값을 빼준 만큼 넣어준다.
                int diff = score[i] - score[i + 1] + 1;
                cnt += diff;
                score[i] -= diff;
            }
        }
        System.out.println(cnt);
    }
}
