import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int [][] map;
    static ArrayList<xy> xy;
    static boolean [] visited;
    static int ans = Integer.MAX_VALUE;

    static class xy {
        int r;
        int c;

        public xy(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        xy = new ArrayList<>();


        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    xy.add(new xy(i,j));
                }
            }
        }

        visited = new boolean[xy.size()];
        dfs(0,0);
        System.out.println(ans);


    }


    // 조합으로 치킨 집을 고른다
    static void dfs(int cnt, int idx){
        // 최대 M개의 치킨 집 골랐을 경우
        if(cnt == M){
            // 도시의 치킨 거리
            int distance = 0;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    // 집인 경우
                    if(map[i][j] == 1){
                        int dis = Integer.MAX_VALUE;
                        for(int k = 0; k < xy.size(); k++){
                            // 방문 체크 한 치킨 집 경우에만
                            if(visited[k]){
                                dis = Math.min(Math.abs(i - xy.get(k).r) + Math.abs(j - xy.get(k).c), dis);
                            }
                        }
                        distance += dis;
                    }
                }
            }
            // 가장 짧은 도시의 치킨 거리
            ans = Math.min(ans, distance);

            return;
        }

        for(int i = idx; i < xy.size(); i++){
            visited[i] = true;
            dfs(cnt + 1, i + 1);
            visited[i] = false;
        }
    }
}