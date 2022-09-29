
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static class Edge implements Comparable<Edge>{
        int v;
        int weight;

        public Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 인접 리스트 초기화
        ArrayList<Edge> [] adjList = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            adjList[i] = new ArrayList<>();
        }

        // 인접 리스트에 넣기
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 무향 그래프
            adjList[a].add(new Edge(b, c));
            adjList[b].add(new Edge(a, c));
        }
        // 방문 처리
        boolean [] visited = new boolean[N + 1];
        int pick = 1;
        int ans = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        int max_weight = 0;

        // 1번 집부터
        pq.addAll(adjList[1]);
        visited[1] = true;

        // 최소 비용으로 마을 돌리려면 그냥 최고 비용으로 드는 집 하나 빼고 그게 마을이면 되겠네?
        while(pick != N){
            Edge curr = pq.poll();

            if(visited[curr.v]) continue;

            ans += curr.weight;
            max_weight = Math.max(curr.weight, max_weight);
            visited[curr.v] = true;

            pq.addAll(adjList[curr.v]);
            pick++;
        }

        System.out.println(ans - max_weight);

    }

}


