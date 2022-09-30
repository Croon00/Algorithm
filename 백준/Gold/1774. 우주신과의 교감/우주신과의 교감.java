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
        int v;
        Double weight;


        public Edge(int v, Double weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.weight, o.weight);
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge> [] adjList = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            adjList[i] = new ArrayList<>();
        }

        int [] godX = new int[N + 1];
        int [] godY = new int[N + 1];
        boolean [] visited = new boolean[N + 1];

        for(int i = 1 ; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            godX[i] = Integer.parseInt(st.nextToken());
            godY[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 이미 연결된 것들은 0.0 weight
            adjList[a].add(new Edge(b, 0.00));
            adjList[b].add(new Edge(a, 0.00));
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(i == j) continue;
                Double distance = Math.sqrt(Math.pow((godX[i] - godX[j]),2) + Math.pow((godY[i] - godY[j]), 2));
                adjList[i].add(new Edge(j, distance));
                adjList[j].add(new Edge(i, distance));
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue();
        // 1번 신 부터
        pq.addAll(adjList[1]);
        visited[1] = true;

        int pick = 1;
        double ans = 0;
        while (pick != N){
            Edge edge = pq.poll();

            // 해당 신이 이미 방문한거면 건너 띄기
            if(visited[edge.v]) continue;

            visited[edge.v] = true;

            ans += edge.weight;

            pq.addAll(adjList[edge.v]);
            pick++;
        }

        System.out.println(String.format("%.2f",ans));

    }
}