import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] shifts = new long[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long A = Long.parseLong(st.nextToken()); // 약속 시간
            long B = Long.parseLong(st.nextToken()); // 도착 시간
            shifts[i] = B - A; // 이 마법사의 대기 시간이 0이 되는 T
        }

        Arrays.sort(shifts);

        long left = shifts[(N - 1) / 2];
        long right = shifts[N / 2];
        System.out.println(right - left + 1);
    }
}