import java.util.*;
import java.io.*;

public class Main {

    static int R, C;

    static int [][] board;
    static int [][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    static boolean [] flag = new boolean[26];
    static int ans = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int [R][C];

        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j = 0; j < C; j++){
                board[i][j] = str.charAt(j) - 'A';
            }
        }

        flag[board[0][0]] = true;
        ans++;
        dfs(0,0,1);
        System.out.println(ans);
    }

    static void dfs(int r, int c, int cnt){

        for(int i = 0; i < 4; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;


            // 알파벳이 이미 한 번 나온 알파벳인지
            if (flag[board[nr][nc]] == true) {
                ans = Math.max(ans, cnt);
                continue;
            }
            // 나온 알파벳이 아닌 경우 true 해주고 다음 으로 이동 갔다 온 후 flag = false;
            // 방문 체크 해주고 dfs
            else {
                flag[board[nr][nc]] = true;
                dfs(nr, nc, cnt + 1);
                flag[board[nr][nc]] = false;
            }
        }
    }
}
