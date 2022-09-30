
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
        int M = Integer.parseInt(st.nextToken());
        // 인접 리스트 초기화
        ArrayList<Edge> [] adjList = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            adjList[i] = new ArrayList<>();
        }

        // 해당 V 번 노드의 대학교가 남자 대학교인지 여자 대학교인지 받기
        String [] college = new String[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            college[i] = st.nextToken();
        }



        // 인접 리스트에 넣기 (i,j 자리에 비용)
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 남자 대학교 & 여자 대학교 일때만 연결
            if(!college[a].equals(college[b])){
                adjList[a].add(new Edge(b, c));
                adjList[b].add(new Edge(a, c));
            }

        }
        // 방문 처리
        boolean [] visited = new boolean[N + 1];
        long ans = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // 1번 건물 부터
        pq.addAll(adjList[1]);
        visited[1] = true;

        while(!pq.isEmpty()){
            Edge curr = pq.poll();


            if(visited[curr.v]) continue;

            ans += curr.weight;
            visited[curr.v] = true;

            pq.addAll(adjList[curr.v]);

        }

        // 모든 대학교가 연결 되어 있는지 확인
        boolean flag = true;
        for(int i = 1; i <= N; i++){
            if(visited[i] == false){
                flag = false;
                break;
            }
        }

        // 연결 되어 있을 경우
        if(flag){
            System.out.println(ans);
        }
        // 아닌 경우
        else{
            System.out.println(-1);
        }

    }

}


