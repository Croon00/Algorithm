import java.util.*;
import java.io.*;

public class Main {
    /*
        동규의 기억력(하루동안 본 정수를 모두 기억 가능)
        수첩1에 하루 동안 본 정수를 모두 적는다.
        동규는 연종이에게 M개의 질문을 던진다.
        X라는 정수를 오늘 본 적 있는가?
        봤다고 주장하는 수 들을 수첩2에 적기
        수첩 2에 적혀있는 순서대로 각각의 수에 대하여 수첩 1에 있으면 1을, 없으면 0을 출력하는 프로그램
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트케이스
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine()); // 수첩 1에 적어 놓은 정수 개수 N 1 ~ 1,000,000
            st = new StringTokenizer(br.readLine());

            int[] note1 = new int[N];
            for (int i = 0; i < N; i++) {
                note1[i] = Integer.parseInt(st.nextToken());
            }

            // 이분탐색으로 하기 위해 정렬
            Arrays.sort(note1);

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            
            // 숫자 하나씩 이분탐색으로 체크
            for (int i = 0; i < M; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (search(note1, num)) sb.append(1);
                else sb.append(0);
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    static boolean search(int[] note1, int num) {
        int L = 0;
        int R = note1.length - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (note1[mid] == num) {
                return true;
            }
            // 찾으려는 값이 가운데 인덱스보다 작을 때
            else if (note1[mid] > num) {
                R = mid - 1;
            }
            // 찾으려는 값이 가운데 인덱스 보다 클 때
            else if (note1[mid] < num) {
                L = mid + 1;
            }
        }
        return false;
    }
}



