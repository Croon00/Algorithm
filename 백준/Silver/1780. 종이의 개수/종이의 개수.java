

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    /*
        n * n 맵이 같지 않을 경우 9등분 해서 다시 확인 --> dfs


     */

    static int N, ans1, ans2, ans3;
    static int [][] board;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 0, 0 부터 N 개의 정수
        dfs(0, 0, N);
        sb.append(ans1).append("\n").append(ans2).append("\n").append(ans3);
        System.out.println(sb);

    }

    static void dfs(int r, int c, int size){
        boolean flag = true;

        // 받은 r,c 부터 r + size, c + size 부분을 보기
        for(int i = r; i < r + size; i++){
            for(int j = c; j < c + size; j++){
                // 맨 처음 [r][c]의 위치에 있는 값과 같지 않을 경우 flag = false;
                if(board[r][c] != board[i][j]){
                    flag =false;
                }
            }
        }

        // flag가 true일 때만 -1, 0, 1 을 구분해서 세기
        if(flag){
            if(board[r][c] == -1){
                ans1++;
            }
            else if(board[r][c] == 0){
                ans2++;
            }
            else{
                ans3++;
            }
            return;
        }

        // size는 3으로 나눈 값
        size = size / 3;

        // 9등분 한 곳으로 dfs 돌리기
        dfs(r, c, size);
        dfs(r, c + size, size);
        dfs(r, c + size * 2, size);

        dfs(r + size, c, size);
        dfs(r + size, c + size, size);
        dfs(r + size, c + size * 2, size);

        dfs(r + size * 2, c, size);
        dfs(r + size * 2, c + size, size);
        dfs(r + size * 2, c + size * 2, size);
    }
}