import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // N 행 , M 열
    static int R, C, N;
    // 4 방향 보기
    static int [][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    // 4 방향 볼 때 방문 체크
    static boolean [][] visit;
    // 미로
    static char [][] map;
    static int [][] mapSec;
    // 1,1과 각 좌표간의 거리


    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        mapSec = new int[R][C];

        for(int i = 0; i < R; i++){
            String str = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'O'){
                    mapSec[i][j] = 0;
                }
                else{
                    mapSec[i][j] = -1;
                }
            }
        }
        boom(0);
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    // 폭탄 추가
    static void setBoom(int sec){
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                // .인 곳에 폭탄 추가
                if(map[i][j] == '.'){
                    map[i][j] = 'O';
                    // 폭탄 없는 곳에 추가한 경우 인자로 받은 시간 추가
                    mapSec[i][j] = sec;
                }
            }
        }
    }

    static void boom(int sec){
        for(int i = 1; i <= N; i++){
            // 1초 후에는 아무 일 없음
            if(i == 1){
                continue;
            }
            // 짝수 초가 지나면 폭탄 없는 곳에 추가
            else if(i % 2 == 0){
                setBoom(i);
            }
            // 그 외에는 폭탄 터뜨림
            else{
                visit = new boolean[R][C];
                bfs(i);
                
            }
        }
    }

    static void bfs(int sec){
        Queue<Integer> queue = new LinkedList();
        // 0, 0 좌표 부터 넣어서 시작
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j] == 'O'){
                    // 현재 주어진 시간에서 -3 전에 설치된 폭탄들이 터진다.
                    if(sec - 3 == mapSec[i][j]){
                        queue.add(i);
                        queue.add(j);

                    }
                }
            }
        }

        while (!queue.isEmpty()){
            // x, y값(행/렬)을 큐에서 꺼내기
            int x = queue.poll();
            int y = queue.poll();
            mapSec[x][y] = -1;
            map[x][y] = '.';
            for(int k = 0; k < 4; k++){
                // 행과 열의 위치를 dir로 이동
                int nr = x + dir[k][0];
                int nc = y + dir[k][1];
                // 폭탄 폭발 범위 안에 있을 때
                if(nr >= 0 && nr < R && nc >= 0 && nc < C){
                    // 폭탄이 있다면
                    if(map[nr][nc] == 'O'){
                        // 방문 하지 않았은 곳이라면
                        if(!visit[nr][nc]) {
                            // 폭탄이 터졌음으로 .으로 바꾸고
                            // mapSec는 -1로 초기화
                            visit[nr][nc] = true;
                            map[nr][nc] = '.';
                            mapSec[nr][nc] = -1;
                        }
                    }
                }
            }
        }
    }
}