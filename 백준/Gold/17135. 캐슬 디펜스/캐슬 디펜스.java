
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, D;
    static int ans;

    static int maxAns = 0;
    static int [][] map;

    static int [][] originalMap;

    static boolean[] arrowVisited;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        // 맨 밑에 행에 궁수 3명 놓을 배열 만들기
        originalMap = new int[N + 1][M];
        map = new int[N + 1][M];
        arrowVisited = new boolean[M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                originalMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        System.out.println(maxAns);
    }

    // 궁수 위치를 브루트 포스로 넣기
    static void dfs(int cnt, int idx){
        // 궁수 3명 다 구햇으면 리턴
        if(cnt == 3){
            ans = 0;

            // 맵 다시 오리지널로 바꾸고 디펜스 하기
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    map[i][j] = originalMap[i][j];
                }
            }

            defence();

            maxAns = Math.max(maxAns, ans);
            return;
        }
        // 맵의 열 갯수만큼
        for(int i = idx; i < M; i++){
            if(arrowVisited[i])continue;
            arrowVisited[i] = true;
            // 궁수 행에 i번째 열에 궁수를 배치
            map[N][i] = 2;
            dfs(cnt + 1, i + 1);
            arrowVisited[i] = false;
            map[N][i] = 0;
        }

    }

    static void defence(){
        List<Integer> arrow = new ArrayList<>();
        
        // 궁수 좌표 넣기
        for(int i = 0; i < M; i++){
            if(map[N][i] == 2){
                arrow.add(i);
            }
        }

        while (true){

            // 적이 남아 있는지 확인 flag
            boolean flag = false;
            loop:
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    // 아직 적이 남아 있슴
                    if(map[i][j] == 1){
                        flag = true;
                        break loop;
                    }
                }
            }
            if(!flag) break;



            // 각 활잡이들이 잡아야 할 가장 짧은 거리
            Queue<Integer> queue = new LinkedList<>();
            for(int k = 0; k < 3; k++) {
                // 궁수 위치
                int arrowX = N;
                int arrowY = arrow.get(k);


                // 가장 짧은 거리 구하기
                int minDis2 = Integer.MAX_VALUE;
                for (int i = N - 1; i >= 0; i--) {
                    for (int j = 0; j < M; j++) {
                        // 활쏘는 범위 가능 한 곳에서
                        int dis = (Math.abs(arrowX - i)) + Math.abs(arrowY - j);
                        if (dis <= D) {
                            // 가장 짧은 범위 에 있는 얘 죽이기
                            if (map[i][j] == 1) {
                                minDis2 = Math.min(minDis2, dis);
                            }
                        }
                    }
                }

                loop2:
                // 가장 짧은 거리 좌표 구하기
                for (int j = 0; j < M; j++) {
                    for (int i = N - 1; i >= 0; i--) {
                        // 활쏘는 범위 가능 한 곳에서
                        int dis = (Math.abs(arrowX - i)) + Math.abs(arrowY - j);
                        if (dis <= D) {
                            // 가장 짧은 범위에 있는 좌표 queue에 넣기
                            if (map[i][j] == 1) {
                                if(minDis2 == dis){
                                    queue.add(i);
                                    queue.add(j);
                                    break loop2;
                                }
                            }
                        }
                    }
                }
            }

            while (!queue.isEmpty()){
                int x = queue.poll();
                int y = queue.poll();

                if(map[x][y] == 1){
                    ans++;
                    map[x][y] = 0;
                }


            }

            // 마지막 행 적 통과
            for(int i = 0; i < M; i++){
                map[N - 1][i] = 0;
            }

            // 적들 한 칸씩 내려가기
            for(int i = N - 2; i >= 0; i--){
                for(int j = 0; j < M; j++){
                    // 해당 지역에 적이 있으면
                    if(map[i][j] == 1){
                        // 땅으로 만들고
                        map[i][j] = 0;
                        // 한 칸 진행
                        map[i + 1][j] = 1;
                    }
                }
            }


        }

    }
}