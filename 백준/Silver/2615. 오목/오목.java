import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 19개의 자리임으로 21개로 늘려서 본다.
        int [][] concave = new int[21][21];
        // 5개의 돌 중 가장 왼쪽에 있는
        // 세로로 있을 땐 가장 위에 있는 돌을 구하기 위해
        // 아래, 오른쪽 아래, 오른쪽, 오른쪽 위에를 보기 위한 dr / dc
        int [] dr = {1, 1, 0, -1};
        int [] dc = {0, 1, 1, 1};
        // 아직 게임이 진행중인지 아닌지
        boolean inGame = true;
        // 1부터 19까지에 돌을 둘 수 있다.
        for(int i = 1; i < 20; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < 20; j++){
                concave[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 1~ 20 까지의 바둑판 중에서 0이 아닌 것을 찾았을 때
        for(int i = 1; i < 20; i++){
            for(int j = 1; j < 20; j++){
                if(concave[i][j] != 0){
                    // 4가지 방향을 확인한다.
                    // 돌이 6개가 넘어가면 승리한 것이 아니기 때문에 이전 방향에 돌이 같지 않는 것을 확인한다.
                    for(int k = 0; k < 4; k++){
                        int cnt = 1;
                        int nr = i + dr[k] * cnt;
                        int nc = j + dc[k] * cnt;
                        int tempR = i - dr[k];
                        int tempC = j - dc[k];
                        // 이전 방향과 돌이 같지 않고, 진행할 방향의 돌과 현재 위치 돌이 같을 경우
                        if(concave[tempR][tempC] != concave[i][j] && concave[nr][nc] == concave[i][j]){
                            // 해당 방향으로 계속해서 cnt를 누적하다가 다른 돌이 나왔을 경우 멈춘다.
                            while(true){
                                cnt++;
                                nr = i + dr[k] * cnt;
                                nc = j + dc[k] * cnt;
                                if(concave[i][j] != concave[nr][nc]){
                                    break;
                                }
                            }
                            // 승부가 났기 때문에 inGame false후 이긴 돌을 보여준다.
                            // 해당 돌의 가장 왼쪽 (세로라면 가장 위에 있는 시점)의 돌 위치를 알려준다.
                            if(cnt == 5){
                                inGame = false;
                                System.out.println(concave[i][j]);
                                System.out.println(i + " " + j);

                            }
                        }
                    }
                }
            }
        }
        if(inGame){
            System.out.println(0);
        }
    }
}
