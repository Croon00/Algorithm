import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // N개의 정점
    static int N;
    static ArrayList<Integer> [] graph;
    // 부모 노드
    static int [] parent;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        parent = new int[N + 1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        // 정점 연결
        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        // 루트 노드인 1 부터 부모는 -1로 설정
        dfs(1, -1);
        // 2번 노드 부터 순서대로 부모 노드 출력
        for(int i = 2; i <= N; i++){
            System.out.println(parent[i]);
        }
    }

    static void dfs(int x, int par){
        // x의 자식 노드들을 돌면서
        for(int i = 0; i < graph[x].size(); i++){
            // 자식 노드들이 가진 값이 현재 주어진 부모노드가 아닌 경우
            if(graph[x].get(i) != par){
                // 이 자식 노드들의 값은 현재 주어진 x의 값이 부모 노드이다.
                parent[graph[x].get(i)] = x;
                // 재귀로 해당 자식 노드들의 자식 노드들도 똑같이 dfs한다.
                dfs(graph[x].get(i), x);
            }
        }
    }
}
