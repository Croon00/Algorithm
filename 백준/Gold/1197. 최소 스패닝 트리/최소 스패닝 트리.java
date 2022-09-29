import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static class Edge implements Comparable<Edge>{
        int st;
        int ed;
        int weight;

        public Edge(int st, int ed, int weight) {
            this.st = st;
            this.ed = ed;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            // 각 노드들 [] 마다 가지고 있는 간선 List<Edge>
            List<Edge> [] adjList = new List[V + 1];
            // 각 노드들 리스트로 초기화
            for(int i = 1; i <= V; i++){
                adjList[i] = new ArrayList<>();
            }

            // 간선 개수 만큼
            for(int i = 0; i < E; i++){
                st = new StringTokenizer(br.readLine());
                // 시작 노드와 끝 노드, 가중치
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                // 무향 그래프임으로 서로 연결 해준다.
                adjList[A].add(new Edge(A, B, C));
                adjList[B].add(new Edge(B, A, C));

            }

            // 간선의 개수 만큼 방문 초기화
            boolean [] visited = new boolean[V + 1];

            // 비교 기준이 있는 Edge를 가진 최소 힙
            PriorityQueue<Edge> pq = new PriorityQueue<>();

            // 시작 지점 --> 0부터
            visited[1] = true;

            // 정점 0 과 이어져있는 모든 Edge 넣기
            pq.addAll(adjList[1]);

            int pick = 1;
            long ans = 0;

            // V개 모두 돌면 끝
            while (pick != V){
                // 해당 정점과 이어진 간선 중 가장 최소 가중치 값 간선
                Edge edge = pq.poll();

                // 해당 간선의 도착 지점이 이미 방문한 곳이면 건너띄기
                if(visited[edge.ed]) continue;

                // 정답에 가중치 더하기
                ans += edge.weight;

                // 해당 정점으로 이어지는 간선들을 다시 최소 힙에 넣기
                pq.addAll(adjList[edge.ed]);
                // 해당 정점은 방문 한걸로(이미 최소 가중치로 이어져 있다.)
                visited[edge.ed] = true;
                pick++;
            }
        System.out.println(ans);




    }
}