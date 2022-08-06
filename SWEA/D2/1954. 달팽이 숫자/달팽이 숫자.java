import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc + "\n");
			int N = sc.nextInt();

			int nr = 0;
			int nc = 0;
			int[][] arr = new int[N][N];

			int dir = 0;

			int num = 1;
			while (num <= (N * N)) {
				arr[nr][nc] = num++;
				nc += dr[dir];
				nr += dc[dir];
				if (nr < 0 || nr > N - 1 || nc < 0 || nc > N - 1 || arr[nr][nc] != 0) {
					nc -= dr[dir];
					nr -= dc[dir];
					dir = (dir + 1) % 4;
					nc += dr[dir];
					nr += dc[dir];

				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(arr[i][j] + " ");
				}
				sb.append("\n");
			}
			
			System.out.print(sb.toString());

		}

	}
}