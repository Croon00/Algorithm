import java.io.*;
import java.util.*;

public class Main {
	static int H, W, N;
	static int[][] sticker;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		
		sticker = new int[N][2];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			sticker[i][0] = Integer.parseInt(st.nextToken());
			sticker[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for (int i=0; i<N-1; i++) {
			int a1 = sticker[i][0];
			int b1 = sticker[i][1];
			for (int j=i+1; j<N; j++) {
				int a2 = sticker[j][0];
				int b2 = sticker[j][1];
				if (a1 + a2 <= H && Math.max(b1, b2) <= W) max = Math.max(max, a1 * b1 + (a2 * b2));
				else if (a1 + b2 <= H && Math.max(a2, b1) <= W) max = Math.max(max, a1 * b1 + (a2 * b2));
				else if (b1 + a2 <= H && Math.max(a1, b2) <= W) max = Math.max(max, a1 * b1 + (a2 * b2));
				else if (b1 + b2 <= H && Math.max(a1, a2) <= W) max = Math.max(max, a1 * b1 + (a2 * b2));
				else if (a1 + a2 <= W && Math.max(b1, b2) <= H) max = Math.max(max, a1 * b1 + (a2 * b2));
				else if (a1 + b2 <= W && Math.max(a2, b1) <= H) max = Math.max(max, a1 * b1 + (a2 * b2));
				else if (b1 + a2 <= W && Math.max(a1, b2) <= H) max = Math.max(max, a1 * b1 + (a2 * b2));
				else if (b1 + b2 <= W && Math.max(a1, a2) <= H) max = Math.max(max, a1 * b1 + (a2 * b2));
			}
		}
		
		System.out.println(max);
	}
}