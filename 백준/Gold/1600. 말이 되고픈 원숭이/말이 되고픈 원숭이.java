import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int K, W, H;
    static int [][] map;
    static int [][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int [][] dir2 = {{-1,-2}, {-2,-1},{-2,1},{-1,2},{1,-2},{2,-1},{2,1},{1,2}};
    static boolean [][][] visited;
    static int [][] distance;
    static boolean flag;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        K  = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int [H][W];
        visited = new boolean[H][W][K + 1];
        distance = new int[H][W];

        for(int i = 0; i < H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 0, 0 좌표는 이미 체크
        for(int i = 0; i < K; i++){
            visited[0][0][i] = true;
        }

        bfs(0,0,0,0);

        if(flag){
            System.out.println(distance[H - 1][W - 1]);
        }
        else{
            System.out.println(-1);
        }


    }
    // horse = 0 이면
    static void bfs(int x, int y, int d, int horse){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        queue.add(d);
        queue.add(horse);
        if(x == H - 1 && y == W - 1){
            flag = true;
        }

        while (!queue.isEmpty()){
            int r = queue.poll();
            int c = queue.poll();
            int dis = queue.poll();
            int h = queue.poll();

            // 기본은 원숭이 스텝으로 움직임
            for(int k = 0; k < 4; k++){
                int nr = r + dir[k][0];
                int nc = c + dir[k][1];
                // 범위 안에 있으면서
                if(nr >= 0 && nr < H && nc >= 0 && nc < W){
                    // 방문하지 않았을 경우
                    if(!visited[nr][nc][h] && map[nr][nc] != 1){
                        visited[nr][nc][h] = true;
                        queue.add(nr);
                        queue.add(nc);
                        queue.add(dis + 1);
                        if(nr == H - 1 && nc == W - 1){
                            flag = true;
                        }
                        if(distance[nr][nc] != 0){
                            distance[nr][nc] = Math.min(distance[nr][nc], dis + 1);
                        }
                        else{
                            distance[nr][nc] = dis + 1;
                        }
                        queue.add(h);
                    }
                }
            }
            // 아직 말 스텝으루 움직일 기회가 있으면 말스텝도 해보기
            if(h < K){
                for(int k = 0; k < 8; k++){
                    int nr = r + dir2[k][0];
                    int nc = c + dir2[k][1];
                    if(nr >= 0 && nr < H && nc >= 0 && nc < W){
                        if(!visited[nr][nc][h + 1] && map[nr][nc] != 1){
                            visited[nr][nc][h + 1] = true;
                            queue.add(nr);
                            queue.add(nc);
                            queue.add(dis + 1);
                            if(nr == H - 1 && nc == W - 1){
                                flag = true;
                            }
                            if(distance[nr][nc] != 0){
                                distance[nr][nc] = Math.min(distance[nr][nc], dis + 1);
                            }
                            else{
                                distance[nr][nc] = dis + 1;
                            }
                            queue.add(h + 1);
                        }
                    }
                }
            }

        }
    }


}
