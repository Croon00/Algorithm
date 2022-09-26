import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N, M, ans;

    static ArrayList<Integer> [] graph;
    static boolean [] visited;
    static int [][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 그래프 초기화
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        ans = 0;
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                dfs(i);
                ans++;
            }
        }

        System.out.println(ans);

    }
    static void dfs(int idx){
        if(visited[idx]){
            return;
        }
        visited[idx] =true;
        for(int i = 0; i < graph[idx].size(); i++){
            int temp = graph[idx].get(i);
            if(!visited[temp]){
                dfs(temp);
            }
        }
    }
}
