import java.util.*;
import java.io.*;

public class Main {

    // 보물섬
    //

    static int [][] dir = {{-1,0}, {1, 0}, {0,-1}, {0, 1}};
    static int N, M;
    static Character [][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 후크 선장이 보물 찾아나섬
        // 직사각형 모양이며 여러칸으로 나누어짐
        // L -> 육지, W -> 바다
        // 상하좌우 이웃한 육지로만 이동 가능
        // 한 칸당 한 시간
        // 보물은 서로 간에 최단 거리로 이동하는 데에 있어 가장 긴 시간이 걸리는 육지 두곳에 나누어 묻힘
        // 보물이 묻힌 두 곳간의 최단 거리 구하기

        // bfs를 해서 가장 길이가 긴 곳을 값으로 받으면 된다.
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Character[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++){
                map[i][j] = str.charAt(j);
            }
        }
        
        int answer = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 'L'){
                    boolean [][] visited = new boolean [N][M];
                    answer = Math.max(answer, bfs(visited, i, j));
                }
            }
        }

        System.out.println(answer);

    }

    static int bfs(boolean [][] visited, int x, int y){
        Queue<Integer> queue = new LinkedList<>();
        int ans = 0;
        queue.add(x);
        queue.add(y);
        queue.add(0);

        visited[x][y] = true;
        while(!queue.isEmpty()){
            int r = queue.poll();
            int c = queue.poll();
            int cnt = queue.poll();
            

            for(int i = 0; i < 4; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 'W') continue;

                visited[nr][nc] = true;
                queue.add(nr);
                queue.add(nc);
                queue.add(cnt + 1);
                ans = Math.max(ans, cnt + 1);
            }
        }

        return ans;
    }

}



