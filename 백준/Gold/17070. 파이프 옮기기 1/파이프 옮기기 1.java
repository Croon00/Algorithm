import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int [][] board;
    static int move;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,1,0);
        System.out.println(move);

    }

    static void dfs(int x, int y, int direction){
        if(x == N - 1 && y == N - 1){
            move++;
            return;
        }
        // direction == 0 가로, 1일때 세로, 2일때 대각선
        if(direction == 0 || direction == 2){
            if(x < N && y + 1< N && board[x][y + 1] == 0){
                dfs(x, y + 1, 0);

            }
        }

        if(direction == 1 || direction == 2){
            if(x + 1< N && y < N && board[x + 1][y] == 0){
                dfs(x + 1, y, 1);
            }
        }
        if(direction == 0 || direction == 1 || direction == 2){
            if(x + 1 < N && y + 1 < N && board[x + 1][y + 1] == 0 && board[x][y + 1] == 0 && board[x + 1][y] == 0){
                dfs(x + 1, y + 1, 2);
            }
        }
    }
}