import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int [][] confetti;
    static int [][] visited;
    static int [] confettiCnt = {5, 5, 5, 5, 5}; // 1x1, 2x2, 3x3, 4x4, 5x5
    static int minCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        confetti = new int[10][10];
        for(int i = 0; i < 10; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++){
                confetti[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        minCnt = Integer.MAX_VALUE;
        dfs(0,0,0);
        if(minCnt == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(minCnt);
        }

    }

    static void dfs(int x, int y, int cnt){
        // 끝까지 왔을 때
        if(x == 9 && y == 10){
            minCnt = Math.min(minCnt , cnt);
            return;
        }

        // 오른쪽으로 끝까지 갔을 때
        if(y == 10){
            // 다시 다음 행의 0번째 열부터 탐색
            dfs(x + 1, 0, cnt);
            return;
        }

        // 현재까지 쓴 종이수가 최소 종이수 이상이면 return
        if(cnt >= minCnt){
            return;
        }

        // 1이 있는 경우
        if(confetti[x][y] == 1){
            // 0 ~ 4번 까지의 종이를 사용 하는데
            // 그리디 하게 4번 부터 사용 해야 함
            for(int i = 4; i >= 0; i--){
                // 사용하려는 색종이가 0개 이상이면서 붙이기 가능할 때
                if(confettiCnt[i] > 0 && isAttach(x, y, i)){
                    // 해당 색종이 갯수 --
                    confettiCnt[i]--;
                    // 붙이기
                    attach(x, y, i);
                    // dfs
                    dfs(x, y + 1, cnt + 1);
                    // 다시 돌아와서 해당 색종이 개수 ++
                    confettiCnt[i]++;
                    // 붙였던거 때내기
                    detach(x, y, i);
                }
            }
        }
        else{
            dfs(x, y + 1, cnt);
        }
    }

    // 그 색종이를 붙이는게 가능한가
    static boolean isAttach(int x, int y, int size){
        // 붙이는게 가능한가 체크
        boolean check = true;
        // 반복문 나가기 위한 flag
        boolean flag = false;

        // x,y 좌표에서 size 만큼 더한 좌표를 보면서
        for(int i = x; i <= x + size; i++){
            for(int j = y; j <= y + size; j++){
                // 10 x 10 범위를 넘지 않고 해당 위치 값이 1일 때
                if(i >= 0 && i < 10 && j >= 0 && j < 10 && confetti[i][j] == 1){
                    flag = true;
                }
                // 이외에는 안됨으로 check = false, 반복문 나가기 위해 flag = false 후 break;
                else{
                    flag = false;
                    check = false;
                    break;
                }
            }
            if(!flag){
                break;
            }
        }

        if(check){
            return true;
        }
        else {
            return false;
        }
    }

    // 붙이는 함수
    static void attach(int x, int y, int size){
        for(int i = x; i <= x + size; i++){
            for(int j = y;  j <= y + size; j++){
                confetti[i][j] = 0;
            }
        }
    }

    // 때내는 함수
    static void detach(int x, int y, int size){
        for(int i = x; i <= x + size; i++){
            for(int j = y;  j <= y + size; j++){
                confetti[i][j] = 1;
            }
        }
    }
}
