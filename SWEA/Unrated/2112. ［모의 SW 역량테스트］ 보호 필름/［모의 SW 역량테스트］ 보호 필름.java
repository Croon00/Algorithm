
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder sb = new StringBuilder();
    static int D,W,K;
    static int min;
    static int [][] film;
    // 바꾼 행을 임시로 넣어줄 배열
    static int[] changed;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            sb.append("#" + tc + " ");
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            film = new int[D][W];

            for(int i = 0; i < D; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < W; j++){
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            min = Integer.MAX_VALUE;
            // 임시 행이기 때문에 D로 초기화 생성
            changed = new int[D];

            dfs(0,0);


            sb.append(min).append("\n");
        }
        System.out.println(sb);

    }

    // 행을 depth로 두어서 행을 바꾸냐 안 바꾸냐로 한다.
    static void dfs(int depth, int cnt){
        // 백 트래킹 부분
        if(cnt >= min) return;

        // check 해서 통과 하면 min 값 갱신하고 return
        if (check()){
            min = cnt;
            return;
        }
        // 행 값을 다 완료하면 return
        if(depth == D)return;



        // 해당 행을 A로 바꾸고 해보기
        changed[depth] = 1;
        dfs(depth + 1, cnt + 1);

        // 해당 행을 B로 바꾸고 해보기
        changed[depth] = 2;
        dfs(depth + 1, cnt + 1);

        // 해당 행을 바꾸지 않고 해보기
        changed[depth] = 0;
        dfs(depth + 1, cnt);


    }

    static boolean check() {

        // 각 열의 수
        for (int i = 0; i < W; i++) {
            boolean flag = false;
            int cntA = 0;
            int cntB = 0;

            // 각 행의 수
            for (int j = 0; j < D; j++) {
                // 바뀐 부분들 부터 체크한다.

                // 1인 부분은 A로 바뀐 부분
                if (changed[j] == 1) {
                    cntA++;
                    cntB = 0;
                }
                // 2인 부분은 B로 바뀐 부분
                else if (changed[j] == 2) {
                    cntA = 0;
                    cntB++;
                }
                // changed == 0 이면 바뀌지 않은 부분임으로 원래 부분에서 찾기
                else if (film[j][i] == 0) {
                    cntA++;
                    cntB = 0;
                } else if (film[j][i] == 1) {
                    cntA = 0;
                    cntB++;
                }

                if (cntA == K || cntB == K) {
                    // A, 나 B가 K 개 이상 쌓이면 통과 가능
                    flag = true;
                    break;
                }
            }
            if(!flag) return false;
        }
        return true;

    }
}
