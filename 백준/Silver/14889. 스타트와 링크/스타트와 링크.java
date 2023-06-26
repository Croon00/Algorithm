import java.util.*;
import java.io.*;

public class Main {

    // N명 축구 하기 위해 모이고 N은 짝수
    // N/2명으로 나우어 스타트 팀 링크 팀

    // S_i 와 S_j번 같은 팀에 속했을 때 팀에 더해지는 능력치
    // i번 사람과 j 번 사람이 같은 팀에 속했을 때 더해지는 능력치는 S_i + S_j이다.

    // 차이를 최소로하기 능력치의 최소값 출력

    static int N;
    static int [][] S;
    static boolean [] startTeam;
    static int ans = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); // 4 ~ 20개
        S = new int [N][N];

        startTeam = new boolean[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // N개의 팀중에서 N/2개를 선택해서 고른 후 나머지 고른 후 비교
        // 팀이 나올 수 있는 경우의 수 --> nC2
        dfs(0, 0);
        System.out.println(ans);
    }

    static void dfs(int cnt, int start){
        if(cnt == N/2){
            int startTeamStats = 0;
            int linkTeamStats = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    // i == j 인 경우 0의 값이 들어감
                    if(i == j) continue;
                    // startTeam인 경우는 누적으로 더해주기
                    if(startTeam[i] && startTeam[j]){
                        startTeamStats += S[i][j];
                    }
                    // 아닌 경우 LinkTeam에 더해주기
                    else if(!startTeam[i] && !startTeam[j]){
                        linkTeamStats += S[i][j];
                    }
                }
            }
            // 최소 값을 가진 경우 정답 
            ans = Math.min(ans, Math.abs(startTeamStats - linkTeamStats));
        }

        for(int i = start; i < N; i++){
            startTeam[i] = true;
            dfs(cnt + 1, i + 1);
            startTeam[i] = false;
        }
    }
}
