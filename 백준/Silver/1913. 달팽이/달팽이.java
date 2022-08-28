import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());
        // 해당 숫자의 좌표 값
        int row = 0, col = 0;
        // 달팽이 모양 n * n
        int[][] ans = new int[N][N];
        // 달팽이 모양으로 이동
        int [] dr = {1, 0, -1, 0};
        int [] dc = {0, 1, 0, -1};
        // 0부터 넣기
        int nr = 0, nc = 0;
        // n * n 값부터 시작
        int value = N * N;
        // 방향 전환
        int dir = 0;

        // 0까지 넣기
        while (value >= 1){
            // 해당 번호 -1
            ans[nr][nc] = value--;
            // nr nc 방향으로 이동
            nr += dr[dir];
            nc += dc[dir];

            // 만약 해당 범위가 달팽이 모양을 넘어가거나 이미 값이 넣어진 곳이면
            // 다시 뒤로 한 번가고 방향을 바꾸어서 나간다.
            if(nr < 0 || nr > N - 1 || nc < 0 || nc > N - 1 || ans[nr][nc] != 0){
                nr -= dr[dir];
                nc -= dc[dir];
                dir = (dir+1) % 4;
                nr += dr[dir];
                nc += dc[dir];
            }
        }

        // 달팽이 보여주고 해당 숫자가 들은 좌표 보여주기
        for(int i = 0; i < N; i ++){
            for(int j = 0; j < N; j++){
                sb.append(ans[i][j] + " ");
                if(ans[i][j] == num){
                    row = i + 1;
                    col = j + 1;
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
        System.out.println(row +" " + col);
    }
}