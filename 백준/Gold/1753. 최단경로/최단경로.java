import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        int v;
        int weight;

        public Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }


        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        List<Node> [] adjList = new ArrayList[V + 1];

        boolean [] visited = new boolean[V + 1];

        for(int i = 1; i <= V; i++){
            adjList[i] = new ArrayList<>();
        }

        int start = Integer.parseInt(br.readLine());

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            // 유향 그래프
            adjList[u].add(new Node(v, w));
        }

        int ans = 0;


        // 각 노드의 거리 무한대로 주기
        int [] dist = new int[V + 1];

        // 각 노드의 최단 거리를 무한대로 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 최소 힙
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 시작 노드 부터 넣기
        pq.add(new Node(start, 0));
        // 시작 지점의 최단 거리는 0 으로 초기화
        dist[start] = 0;
        while (!pq.isEmpty()){
            // 간선 중 최소 가중치 뽑기
            Node curr = pq.poll();

            // 방문했던 노드이면 건너띄기
             if(visited[curr.v]) continue;

             // 방문 처리
             visited[curr.v] = true;

             // 현재 노드로부터 이어진 노드들
             for(Node node : adjList[curr.v]){
                 // 방문하지 않아으면서
                 // dist[v]의 값이 현재 노드의 가중치 + 그 노드의 가중치 보다 크면
                 // 바꾸기
                 if(!visited[node.v] && dist[node.v] > dist[curr.v] + node.weight){
                     dist[node.v] = dist[curr.v] + node.weight;
                     pq.add(new Node(node.v, dist[node.v]));
                 }
             }
        }

        // 무한대일 경우 무한대 아닐 경우 최단 거리
        for(int i = 1; i <= V; i++){
            if(dist[i] != Integer.MAX_VALUE){
                System.out.println(dist[i]);
            }
            else{
                System.out.println("INF");
            }
        }

    }
}
