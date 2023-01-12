import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
        결혼식에 학교 동기 중 친구와 친구의 친구를 초대
        동기 모두 N명, 학번 모두 1부터 N까지
     */
    static int n;
    static int m;
    static List<Integer> [] graph;
    static boolean [] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        // 1번 부터 임으로 n + 1
        graph = new List[n + 1];
        visited = new boolean[n + 1];

        // 초기화
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 서로 친구
            graph[a].add(b);
            graph[b].add(a);
        }
        System.out.println(bfs(1));

    }
    static int bfs(int x){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(0);
        visited[x] = true;
        int cnt = 0;

        while (!queue.isEmpty()){
            int human = queue.poll();
            int distance = queue.poll();
            
            // 친구 = 0, 친구의 친구 = 1, 그 이상은 건너띄기
            if(distance > 1) continue;
            
            // 큐에 계속해서 친구들 추가하기
            for (int next : graph[human]){
                // 이미 친구 맺은 사람은 건너띄기
                if(visited[next]) continue;
                // 친구 수 ++
                cnt++;
                // 방문 체크 한 후 큐에 다음 사람 과 거리 추가
                visited[next] = true;
                queue.add(next);
                queue.add(distance + 1);

            }
        }
        return cnt;
    }
}
