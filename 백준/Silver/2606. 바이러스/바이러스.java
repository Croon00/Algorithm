import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 정점 N개, 간선 M개, 바이러스 갯수
    static int N, M, virusCnt;
    // 그래프
    static ArrayList<Integer> [] graph;
    // 방문 체크
    static boolean [] visit;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        // 1번 컴퓨터 부터
        dfs(1);
        // 1번 을 제외한 바이러스 갯수
        System.out.println(virusCnt - 1);
    }

    static void dfs(int x){
        visit[x] = true;
        virusCnt++;

        for(int i = 0; i < graph[x].size(); i++){
            if(!visit[graph[x].get(i)]){
                dfs(graph[x].get(i));
            }
        }
    }
}