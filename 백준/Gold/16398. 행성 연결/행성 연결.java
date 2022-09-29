
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static class Edge implements Comparable<Edge>{
        int v;
        long weight;

        public Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }


        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.weight, o.weight);
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
        for(int i = 1; i <= N; i++){
            adjList[i] = new ArrayList<>();
        }

        // 인접 리스트에 넣기 (i,j 자리에 비용)
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                int a = Integer.parseInt(st.nextToken());
                if(i == j) continue;
                adjList[i].add(new Edge(j,a));
                adjList[j].add(new Edge(i,a));
            }
        }
        // 방문 처리
        boolean [] visited = new boolean[N + 1];
        int pick = 1;
        long ans = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();



        // 1번 행성 부터
        pq.addAll(adjList[1]);
        visited[1] = true;

        while(pick != N){
            Edge curr = pq.poll();

            if(visited[curr.v]) continue;

            ans += curr.weight;
            visited[curr.v] = true;

            pq.addAll(adjList[curr.v]);
            pick++;
        }

        System.out.println(ans);

    }

}


