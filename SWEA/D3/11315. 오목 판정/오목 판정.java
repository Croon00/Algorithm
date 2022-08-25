import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        // 상하좌우를 탐색하는 dr/dc
        int [] dr = {-1, 1, 0, 0};
        int [] dc = {0, 0, -1, 1};
        // 4곳의 대각선을 탐색하는 dr2/dc2
        int [] dr2 = {-1, 1, -1, 1};
        int [] dc2 = {-1, -1, 1, 1};
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            String s;
            Character[][] concave = new Character[N][N];
            // 돌이 5개 인가?
            boolean ans = false;
            for (int i = 0; i < N; i++) {
                s = br.readLine();
                for (int j = 0; j < N; j++) {
                    concave[i][j] = s.charAt(j);
                }
            }

            // 오목판 전체를 돌면서
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    // o 가 있는 곳은 돌이 있는 곳
                    if(concave[i][j] == 'o'){
                        // 상하좌우를 보면서
                        for(int k = 0; k < 4; k++){
                            int cnt = 1;
                            // 5개의 돌이 있는지 확인하기 위해 해당 방향으로 5번 가기
                            for(int l = 0; l < 4; l++){
                                // cnt로 해당 방향으로 계속 가준다.
                                int nr = i + dr[k] * cnt;
                                int nc = j + dc[k] * cnt;
                                // 오목판 범위를 넘지 않으면서
                                if(nr >= 0 && nr < N && nc >= 0 && nc < N){
                                    // 만약 돌이 없다면 break
                                    if(concave[nr][nc] != 'o'){
                                        break;
                                    }
                                    // 돌이 있다면 cnt++
                                    else{
                                        cnt++;
                                    }
                                    // 만약 cnt가 5이면 돌이 5개임으로 ans = true
                                    if(cnt == 5){
                                        ans = true;
                                    }
                                }
                                // 오목판 범위를 넘었을때 break
                                else{
                                    break;
                                }
                            }
                        }
                        // 위와 같은 탐색을 이번엔 대각선 4곳으로 해보기
                        for(int k = 0; k < 4; k++){
                            int cnt = 1;
                            for(int l = 0; l < 4; l++){
                                int nr = i + dr2[k] * cnt;
                                int nc = j + dc2[k] * cnt;
                                if(nr >= 0 && nr < N && nc >= 0 && nc < N){
                                    if(concave[nr][nc] != 'o'){
                                        break;
                                    }
                                    else{
                                        cnt++;
                                    }
                                    if(cnt == 5){
                                        ans = true;
                                    }
                                }
                                else{
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if(ans){
                System.out.println("#" + tc + " " + "YES");
            }
            else{
                System.out.println("#" + tc + " " + "NO");
            }
        }
    }
}