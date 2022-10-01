
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
        

        // 인접 리스트 초기화
        ArrayList<Edge> [] adjList = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++){
            adjList[i] = new ArrayList<>();
        }

        // 각 논에 우물 파는데 드는 비용
        for(int i = 1; i <= N; i++) {
            // 0번째는 우물 --> 각 논에서 우물 파는데 드는 비용
            int cost = Integer.parseInt(br.readLine());
            adjList[0].add(new Edge(i, cost));
        }
        

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                int value = Integer.parseInt(st.nextToken());
                // 행열이 같을 때에는 건너 띄고
                if(i == j)continue;
                // 연결하기
                adjList[i].add(new Edge(j, value));
            }
        }


        // 방문 처리
        boolean [] visited = new boolean[N + 1];
        int ans = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // 우물 부터 시작
        pq.addAll(adjList[0]);
        visited[0] = true;

        while(!pq.isEmpty()){
            Edge curr = pq.poll();


            if(visited[curr.v]) continue;

            ans += curr.weight;
            visited[curr.v] = true;

            pq.addAll(adjList[curr.v]);

        }
        System.out.println(ans);
    }
}


