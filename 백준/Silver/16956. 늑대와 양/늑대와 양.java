import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int R, C;
    static Character [][] map;
    static int [][] dir = {{-1,0}, {1,0}, {0,-1}, {0, 1}};
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new Character[R][C];

        // map 받기
        for(int i = 0; i < R; i++){
            String s = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = s.charAt(j);
            }
        }

        // R, C를 돌면서 늑대를 찾으면 bfs 돌기
        loop:
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j] == 'W'){
                    bfs(i,j);
                }
                // flag 가 true이면 양이 죽기 때문에 break;
                if(flag){
                    break loop;
                }
            }
        }

        // 양이 죽기 때문에 0
        if(flag){
            System.out.println(0);
        }
        // 양이 죽지 않을 때 1, 하고 map을 보여준다.
        else{
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(1);
            System.out.println(sb);
        }
    }

    // bfs
    static void bfs(int x, int y){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);

        while (!queue.isEmpty()){
            int r = queue.poll();
            int c = queue.poll();

            for(int k = 0; k < 4; k++){
                int nr = r + dir[k][0];
                int nc = c + dir[k][1];

                // 늑대 주변에 .일 경우 벽으로 가둔다.
                if(nr >= 0 && nr < R && nc >= 0 && nc < C){
                    if(map[nr][nc] == '.'){
                        map[nr][nc] = 'D';
                    }
                    // 늑대 주변에 양이 있을 경우 flag= true 하고 끝내기.
                    else if(map[nr][nc] == 'S'){
                        flag = true;
                        return;
                    }

                }
            }
        }
    }
}