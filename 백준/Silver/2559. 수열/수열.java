import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] days = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			days[i] = Integer.parseInt(st.nextToken());
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N + 1 - K; i++) {	// K 개씩 묶어서 모두 더한 뒤 최댓값 구하기
			int sum = 0;
			for (int j = i; j < i + K; j++) {
				sum += days[j];
			}
			if (max < sum) {
				max = sum;
			}
		}

		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
		br.close();
	}
}