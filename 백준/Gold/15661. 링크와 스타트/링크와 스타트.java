import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean [] visited;
    static int [][] num;
    static int ans;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        num = new int[N][N];
        ans = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);

        System.out.println(ans);


    }

    static void dfs(int cnt, int idx){
        if(cnt == N){
            int start = 0;
            int link = 0;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(visited[i]){
                        if(visited[j]){
                            start += num[i][j];
                        }
                    }
                    else if(!visited[i]){
                        if(!visited[j]){
                            link += num[i][j];
                        }
                    }
                }
            }
            ans = Math.min(ans, Math.abs(start - link));
            return;
        }

        // 부분 수열
        visited[idx] = true;
        dfs(cnt + 1, idx + 1);
        visited[idx] = false;
        dfs(cnt + 1, idx + 1);
    }

}