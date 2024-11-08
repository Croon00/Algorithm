import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] line = new int[N];
        int[] answer = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            line[i] = Integer.parseInt(st.nextToken());
        }

        // 키가 작은 사람부터 위치를 정해야 하므로 1부터 N까지 순차적으로 처리
        for (int i = 0; i < N; i++) {
            int cnt = line[i]; // 자신보다 큰 사람이 왼쪽에 cnt명 있어야 함
            for (int j = 0; j < N; j++) {
                // 빈 자리 발견할 때마다 cnt를 줄여서 해당 자리에 자신을 배치
                if (answer[j] == 0) {
                    if (cnt == 0) {
                        answer[j] = i + 1; // 사람 번호는 키 순서대로 i + 1
                        break;
                    }
                    cnt--;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
