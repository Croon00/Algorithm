
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int N, M, minBacon, ans;
    static ArrayList<Integer>[] adjList;
    static boolean [] visited;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];
        minBacon = Integer.MAX_VALUE;

        // 인접 리스트 초기화
        for(int i = 1; i <= N; i++){
            adjList[i] = new ArrayList<>();
        }


        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 무방향 그래프
            adjList[a].add(b);
            adjList[b].add(a);
        }

        // N번의 사람까지 모두 돌면서
        for(int i = 1; i <= N; i++){
            visited = new boolean[N + 1];

            // 최소 베이컨이 bfs보다 이상인 경우만 갱신하기(같을 경우 최소 번호 사람을 뽑아야 하기 때문에)
            int temp = bfs(i);
            if(minBacon > temp){
                minBacon = temp;
                ans = i;
            }
        }
        System.out.println(ans);

    }

    static int bfs(int user){
        Queue<Integer> queue = new LinkedList<>();
        // 해당 사람 번호와 거리를 큐에 넣는다.
        queue.add(user);
        queue.add(1);
        // 해당 사람 방문처리
        visited[user] = true;
        // 해당 사람의 케빈 베이컨 값을 알려줄 cnt
        int cnt = 0;

        // 큐 돌면서 방문처리 하면서 다시 큐가 빌 때까지 넣기
        while (!queue.isEmpty()){
            int temp = queue.poll();
            int dis = queue.poll();

            for(Integer node : adjList[temp]){
                if(visited[node]) continue;
                visited[node] = true;
                queue.add(node);
                cnt = cnt + dis;
                queue.add(dis + 1);
            }
        }
        return cnt;
    }
}