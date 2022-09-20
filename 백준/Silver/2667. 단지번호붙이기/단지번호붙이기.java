import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader fr = new FastReader();

    static int dir [][] = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static ArrayList<Integer> group;
    static int N, group_count;
    static boolean[][] visit;
    static String h [];

    static void input(){
        N =fr.nextInt();
        h = new String[N];
        for (int i = 0; i < N; i++){
            h[i] = fr.nextLine();
        }
        visit = new boolean[N][N];
    }

    static void dfs (int x, int y){
        group_count++;
        visit[x][y] = true;

        for (int k = 0; k < 4; k++){
            //(x, y) -> dir[k]
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            // 실제로 존재 하는가?
            if (nx < 0 || ny < 0 || ny >= N || nx >= N){
                continue;
            }
            // 집이 없는가 ?
            if (h[nx].charAt(ny) == '0') {
                continue;
            }
            // 방문 했던 집인가?
            if(visit[nx][ny]){
                continue;
            }
            dfs(nx, ny);

        }
    }


    static void pro() {
        group = new ArrayList<>();
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (!visit[i][j] && h[i].charAt(j) == '1'){
                    group_count = 0;
                    dfs(i, j);
                    group.add(group_count);
                }
            }
        }

        // 찾은 단지에 있는 집의 정보
        Collections.sort(group);
        // 총 단지 수
        sb.append(group.size()).append('\n');

        // 단지별로 있는 집들의 수
        for (int count : group){
            sb.append(count).append('\n');
        }

        System.out.println(sb);
    }

    public static void main(String[] args) {
       input();
       pro();
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));

        }
        String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        long nextLong(){
            return Long.parseLong(next());
        }

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
