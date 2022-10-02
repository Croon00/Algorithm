
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N, M, K, X;
    static boolean flag;
    static boolean [] visited;

    static ArrayList<Integer> city = new ArrayList<>();

    static StringBuilder sb = new StringBuilder();

    static class Node {
        int N;
        int weight;

        public Node(int n, int weight) {
            N = n;
            this.weight = weight;
        }
    }

    static ArrayList<Node> [] adjList;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        // 인접리스트 초기화
        adjList = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            adjList[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];


        // 단방향 도로
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // a에서 b 의 거리 1로 너어줌
            adjList[a].add(new Node(b, 1));
        }

        // X가 출발 도시 방문처리
        visited[X] = true;
        bfs(X);
        
        if(flag){
            // 오름 차순으로 정렬
            Collections.sort(city);
            for(int i = 0; i < city.size(); i++){
                System.out.println(city.get(i));
            }
        }
        else{
            System.out.println(-1);
        }

    }

    static void bfs(int x){
        Queue<ArrayList<Node>> queue = new LinkedList<>();
        Queue<Integer> dis = new LinkedList<>();
        // 시작 도시로 부터 연결 되어 있는 도시들
        queue.add(adjList[x]);
        dis.add(1);



        while (!queue.isEmpty()){
            ArrayList<Node> temp = queue.poll();
            int distance = dis.poll();
            for(Node node : temp){
                // 해당 노드 최단 거리로 구하기 위해 방문 처리
                if(visited[node.N]) continue;
                visited[node.N] = true;
                // 주어진 거리로 도착 했을 때
                // 도착한 노드 번호 넣고 해당 도시 존재하다고 flag true
                if(distance== K){
                    flag = true;
                    city.add(node.N);
                }
                // 해당 노드의 인접리스트를 다시 넣어주고, 거리도 넣어준다.
                queue.add(adjList[node.N]);
                dis.add(distance + 1);
            }

        }
    }




}


