

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    /*
        N-Queen 처럼 백트래킹으로 풀기?
     */
    static int[][] board;
    static List<int[]> list;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[9][9];
        list = new ArrayList<int []>();
        // 스도쿠 받기
        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = str.charAt(j) - '0';

                // 0인곳을 센다.
                if (board[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }
        dfs(0);


    }

    static void dfs(int cnt) {
        // 다 채웠을 경우 정답 스도쿠 출력
        if (list.size() == cnt) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
        }
        // 스도쿠 보면서 0인 곳을 발견했을 때

        int i = list.get(cnt)[0];
        int j = list.get(cnt)[1];


        boolean[] check = new boolean[10];

        // 그 행을 보면서
        for (int k = 0; k < 9; k++) {
            if (board[i][k] != 0) {
                check[board[i][k]] = true;
            }
        }

        // 열을 보면서
        for (int k = 0; k < 9; k++) {
            if (board[k][j] != 0) {
                check[board[k][j]] = true;
            }
        }
        // 3 * 3을 보기
        int gridX = (i / 3) * 3;
        int gridY = (j / 3) * 3;

        for (int k = gridX; k < gridX + 3; k++) {
            for (int l = gridY; l < gridY + 3; l++) {
                if (board[k][l] != 0) {
                    check[board[k][l]] = true;
                }
            }
        }


        for (int k = 1; k < 10; k++) {
            if (!check[k]) {
                board[i][j] = k;
                dfs(cnt + 1);
                board[i][j] = 0;
            }
        }
    }


}