import java.util.*;
import java.io.*;

public class Main {

    // 빵집
    // 가스비가 제일 크다 --> 근처 빵집의 가스관에 몰래 파이프를 설치해 훔쳐서 사용하기
    // R * C 격자
    // 첫째 열은 근처 빵집의 가스관, 마지막 열은 원웅이의 빵집
    // 가스관과 빵집 연결 파이프 설치하는데 건물이 있는 경우 파이프 x
    // 첫째 열에서 파이프라인 시작해야 하고 마지막 열에서 끝나야 한다.
    // 오른쪽, 오른쪽 위 대각선, 오른쪽 아래 대각선으로 연결 가능, 각 칸의 중심끼리 연결


    // 최대한 위로 가는 파이프를 먼저 써야 그리디하게 최대한 파이프라인을 만들 수 있다.
    // 오른쪽이랑 오른쪽 위 혹은 오른쪽 아래로만 움직일 수 있음으로 제일 왼쪽 열에서 시작하면서 제일 위에 행부터 깊이탐색을 하면
    // 그것이 최대한의 개수를 셀 수 있게된다.
    static Character [][] map;
    static int R, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new Character [R][C];

        for(int i = 0; i < R; i++){
            String str = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = str.charAt(j);
            }
        }

        int ans = 0;
        // 첫 번째 열에서 시작
        for(int i = 0; i < R; i++){


            if(dfs(i, 0)) ans++;
        }

        System.out.println(ans);
    }

    // 최대한 파이프라인을 만들기 위해 dfs로 만들기
    static boolean dfs(int r, int c) {



        // 현재 맵에 파이프를 만들었다는 표시를 한다.
        map[r][c] = 'x';

        // 마지막 열에 도착하면 가능
        if(c == C - 1){
            return true;
        }

        // map 범위 넘어가지 않게

        // 오른쪽 위 대각선 먼저 가준다.
        if(r - 1 >= 0 && c + 1 < C && map[r - 1][c + 1] == '.'){
            // 깊이 탐색하면서 마지막열 도착하면 끝내기기
           if(dfs(r - 1, c + 1)) return true;
        }

        // 오른쪽으로 가준다.
        if(c + 1 < C && map[r][c + 1] == '.'){
            if(dfs(r, c + 1)) return true;
        }

        // 오른쪽 아래 대각선으로 가준다
        if(r + 1 < R && c + 1 < C && map[r + 1][c + 1] == '.'){
            if(dfs(r + 1, c + 1)) return true;
        }

        return false;
    }

}



