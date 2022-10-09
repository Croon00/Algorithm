
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int [][] map;
    static ArrayList<xy> chicken;
    static ArrayList<xy> house;
    static boolean [] visited;
    static int ans;

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
        chicken = new ArrayList<>();
        house = new ArrayList<>();
        ans = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                // 2인 경우 치킨 집
                if(map[i][j] == 2){
                    chicken.add(new xy(i,j));
                }
                // 1인 경우 일반 집
                else if(map[i][j] == 1){
                    house.add(new xy(i,j));
                }
            }
        }

        // 고를 치킨 집들 방문처리
        visited = new boolean[chicken.size()];
        dfs(0,0);
        System.out.println(ans);


    }


    // 조합으로 치킨 집을 고른다
    static void dfs(int cnt, int idx){
        // 최대 M개의 치킨집 골랐을 경우
        if(cnt == M){
            // 도시의 치킨 거리
            int distance = 0;

            for(int i = 0; i < house.size(); i++){
                int minDist = Integer.MAX_VALUE;
                for(int j = 0; j < chicken.size(); j++){
                    // 방문 체크한 치킨집 만
                    if(visited[j]){
                        // 거리 계산하고 최고 작은거리로 갱신
                        int dist = Math.abs(house.get(i).r - chicken.get(j).r) + Math.abs(house.get(i).c - chicken.get(j).c);
                        minDist = Math.min(minDist, dist);
                    }
                }
                // 도시의 치킨 거리에 누적해서 더하기
                distance += minDist;
                // 구하던 도시의 치킨 거리가 ans 이상인 경우 백트래킹
                if(ans <= distance){
                    return;
                }

            }

            // 가장 짧은 도시의 치킨 거리
            ans = Math.min(ans, distance);
            return;
        }

        for(int i = idx; i < chicken.size(); i++){
            visited[i] = true;
            dfs(cnt + 1, i + 1);
            visited[i] = false;
        }
    }
}