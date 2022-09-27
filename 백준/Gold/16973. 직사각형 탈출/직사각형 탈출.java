import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, ans;
    static int H, W, Sr, Sc, Fr, Fc;
    static int [][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static boolean [][] visited;

    static int [][] map;

    static boolean check;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        Sr = Integer.parseInt(st.nextToken()) - 1;
        Sc = Integer.parseInt(st.nextToken()) - 1;
        Fr = Integer.parseInt(st.nextToken()) - 1;
        Fc = Integer.parseInt(st.nextToken()) - 1;

        // 벽을 찾았을 때 직사각형이 벽을 포함할 수 있는 범위 만큼을 1로 만듬
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 1){
                    for(int k = i; k >= i -(H - 1) && k >= 0; k--){
                        for(int l = j; l >= j - (W - 1) && l >= 0; l--){
                            map[k][l] = 1;
                        }
                    }
                }
            }
        }

        bfs(Sr, Sc, 0);
        if(check){
            System.out.println(ans);
        }
        else{
            System.out.println(-1);
        }
    }
    static void bfs(int x, int y, int d){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        queue.add(d);
        visited[x][y] = true;

        while (!queue.isEmpty()){
            int r = queue.poll();
            int c = queue.poll();
            int dis = queue.poll();

            for(int k = 0; k < 4; k++){
                int nr = r + dir[k][0];
                int nc = c + dir[k][1];

                // 해당 직사각형이 범위 안에 있을 경우
                if(nr >= 0 && nr + (H - 1) < N && nc >= 0 && nc + (W - 1) < M){
                    if(!visited[nr][nc] && map[nr][nc] != 1){
                        // 방문 체크
                        visited[nr][nc] = true;

                        // nr, nc 가 목표 지점에 도착 했을 경우
                        if(nr == Fr && nc == Fc){
                            check = true;
                            ans = dis + 1;
                            return;
                        }
                        queue.add(nr);
                        queue.add(nc);
                        queue.add(dis + 1);
                    }
                }
            }
        }
    }
}
