import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N, M, V;
    static ArrayList<Integer>[] adj;
    static boolean visit[];

    static void input(){
        FastReader fr = new FastReader();
        N = fr.nextInt();
        M = fr.nextInt();
        V = fr.nextInt();
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++){
           adj[i] = new ArrayList<Integer>();
        }
        for (int i =1; i <= M; i++){
            int x =fr.nextInt(), y = fr.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        // 인접 리스트의 경우 넣은 순대로 되있기 때문에 정렬을 해주어야 한다.
        for (int i = 1; i <= N; i++){
            Collections.sort(adj[i]);
        }

    }

    static void dfs(int x){
        visit[x] = true;
        sb.append(x).append(' ');
        // adj[x]에 있는 값을 y로 받아서 이것이 방문 했는지만 확인하면 된다.
        // 모든 [y]에 대해서 체크하는 것이 아니라 0이 있는경우를 체크할 필요 없다.
        for (int y: adj[x]){
            if (visit[y]){
                continue;
            }
            dfs(y);
        }
    }

    static void bfs(int x){
        Queue<Integer> que = new LinkedList<>();

        que.add(x);
        visit[x] = true;

        while(!que.isEmpty()){
            x = que.poll();
            sb.append(x).append(' ');
            for (int y : adj[x]){
                
                // 이미 방문한 노드인 경우
                if(visit[y] == true){
                    continue;
                }
                que.add(y);
                visit[y] = true;
            }
        }
    }

    static void pro() {
        visit = new boolean[N + 1];
        dfs(V);
        sb.append('\n');
        // dfs 한 후에 visit에 방문 흔적을 초기화 해준다.
        for (int i = 1; i <= N; i++){
            visit[i] = false;
        }
        bfs(V);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        pro();

    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));

        }
        String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        long nextLong(){
            return Long.parseLong(next());
        }
    }
}