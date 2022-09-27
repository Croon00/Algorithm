import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, a, b, M, ans;
    static ArrayList<Integer> [] graph;
    static boolean [] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st. nextToken());
        b = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        // 인접 리스트 초기화
        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        // 정답 - 1로 초기화
        ans = -1;
        
        // 간선 받기
       for(int i = 0; i < M; i ++){
           st = new StringTokenizer(br.readLine());
           int x = Integer.parseInt(st.nextToken());
           int y = Integer.parseInt(st.nextToken());
           graph[x].add(y);
           graph[y].add(x);
       }

       // a랑 cnt
       dfs(a,0);
        System.out.println(ans);
    }

    static void dfs(int x, int cnt){
        // b 찾으면 ans에 cnt 넣기
        if(x == b){
            ans = cnt;
            return;
        }
        // 방문 체크
        visited[x] = true;
        // 그래프 사이즈 만큼 돌면서 방문 체크하기
        for(int i = 0; i < graph[x].size(); i++){
            int temp = graph[x].get(i);
            if(!visited[temp]){
                dfs(temp, cnt + 1);
            }
        }
    }
}
