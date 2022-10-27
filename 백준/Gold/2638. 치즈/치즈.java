import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
    외부 공기먼저 bfs로 돌린 후 치즈인 부분 찾아서 4방탐색
    이 방법을 치즈 없을 때 까지 하기
 */


public class Main {
    static int N, M;
    static int [][] map;
    static int [][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};




    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        while (true){
            boolean flag = false;

            // 치즈를 찾은 경우 bfs 돌리고 flag 바꾸고 loop 나가기
            loop:
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(map[i][j] == 1){
                        bfs();
                        flag = true;
                        ans++;
                        break loop;
                    }
                }
            }

            if(!flag){
                break;
            }
        }

        System.out.println(ans);




    }

    static void bfs(){
        // 외부 공기 먼저 만들기
        boolean [][] visited = new boolean[N][M];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        queue.add(0);

        // 공기 부분을 알려줄 map
        int [][] airMap =  new int[N][M];

        visited[0][0] = true;
        // 가장 자리에는 치즈 못옴
        airMap[0][0] = -1;

        while (!queue.isEmpty()){
            int row = queue.poll();
            int col = queue.poll();


            for(int k = 0; k < 4; k++){
                int nr = row + dir[k][0];
                int nc = col + dir[k][1];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;

                // 치즈 인 경우 빼고
                if(map[nr][nc] != 1){
                    visited[nr][nc] = true;
                    airMap[nr][nc] = -1;
                    queue.add(nr);
                    queue.add(nc);
                }
            }
        }


        // 치즈 찾은 경우 4방 보고 지우기
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 1){

                    int airCnt = 0;
                    for(int k = 0; k < 4; k++){
                        int nr = i + dir[k][0];
                        int nc = j + dir[k][1];

                        if(nr < 0 || nr >= N || nc < 0 || nc >= M)continue;

                        if(airMap[nr][nc] == -1){
                            airCnt++;
                        }
                    }
                    // 공기와 2곳 이상 맞닿아 있으면 공기로 만들기
                    if(airCnt >= 2){
                        map[i][j] = 0;
                    }

                }
            }
        }


    }

}