import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 동전
    static int [][] coin;
    // 최소 뒤집는 수
    static int min;
    //  모두 같은 면이 가능한지 불가능한지
    static boolean flag;
    // 총 8가지의 뒤집기 할 수 있음, 8!의 가짓수가 나온다.
    // 해당 뒤집는 방법을 했는지 안했는지 체크 하기 위한 boolean 배열
    static boolean [] visit;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            visit = new boolean[8];
            coin = new int[3][3];
            flag = false;
            min = 9;
            for(int i = 0; i < 3; i++){
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < 3; j++){
                    String coinDirect = st.nextToken();

                    if(coinDirect.equals("H")){
                        coin[i][j] = 0;
                    }
                    else {
                        coin[i][j] = 1;
                    }
                }
            }
            dfs(0);
            if(flag){
                sb.append(min).append('\n');
            }
            else {
                sb.append(-1).append('\n');
            }
        }
        System.out.println(sb);


    }

    static void dfs(int cnt){
        // 체크 해서 모두 한 면일 경우
        if(check()){
            // 모두 한 면이 가능함으로 flag = true
            flag = true;
            // 최소 횟수를 min에 넣고 return;
            min = Math.min(min, cnt);
            return;

        }
        // 모든 가짓수의 뒤집기를 완전 탐색으로 구하기
        for(int i = 0; i <8; i++){
            if(!visit[i]){
                visit[i] = true;
                reverse(i);
                dfs(cnt + 1);
                visit[i] = false;
                // 다음 i + 1번째를 위해 reverse(i)를 통해서 다시 원상 복귀
                reverse(i);

            }
        }

    }

    // 해당 coin 상태가 모두 같은 면인지 아닌지
    static boolean check(){
        int start = coin[0][0];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(coin[i][j] != start){
                    return false;
                }
            }
        }
        return true;
    }

    // 뒤집는 방법
    static void reverse(int x){
        // 행을 뒤집기
        if(x < 3){
            for(int i = 0; i < 3; i++){
                if(coin[x][i] == 0){
                    coin[x][i] = 1;
                }
                else{
                    coin[x][i] = 0;
                }
            }
        }
        // 열을 뒤집기
        else if(x < 6){
            for(int i = 0; i < 3; i++){
                if(coin[i][x-3] == 0){
                    coin[i][x-3] = 1;
                }
                else{
                    coin[i][x-3] = 0;
                }
            }
        }
        // 왼쪽 위에서 오른쪽 아래로 내려오는 대각선 뒤집기
        else if (x == 6){
            for(int i = 0; i < 3; i++){
                if (coin[i][i] == 0){
                    coin[i][i] = 1;
                }
                else{
                    coin[i][i] = 0;
                }
            }
        }
        // 오른쪽 위에서 왼쪽 아래로 내려오는 대각선 뒤집기
        else {
            for(int i = 0; i < 3; i++){
                if(coin[i][2 - i] == 0){
                    coin[i][2 - i] = 1;
                }
                else {
                    coin[i][2 - i] = 0;
                }
            }
        }
    }

}
