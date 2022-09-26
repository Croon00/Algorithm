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

        for(int i = 0; i < R; i++){
            String s = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = s.charAt(j);
            }
        }

        loop:
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j] == 'W'){
                    bfs(i,j);
                }
                if(flag){
                    break loop;
                }
            }
        }

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");

        }
        if(flag){
            System.out.println(0);

        }
        else{
            System.out.println(1);
            System.out.println(sb);
        }
    }

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

                if(nr >= 0 && nr < R && nc >= 0 && nc < C){
                    if(map[nr][nc] == '.'){
                        map[nr][nc] = 'D';
                    }
                    else if(map[nr][nc] == 'S'){
                        flag = true;
                        return;
                    }

                }
            }
        }
    }
}
