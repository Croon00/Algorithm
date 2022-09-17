import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader fr = new FastReader();
    static int N, parent[];
    static ArrayList<Integer> adj[];


    static void input(){
        N = fr.nextInt();
        adj = new ArrayList[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        // 인접 리스트를 통한 그래프 생성
        for (int i = 1; i < N; i++){
            int x = fr.nextInt(), y = fr.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }

    }

    // dfs(x, parent) : 정점 x의 부모가 parent 였고, x의 children들을 찾아주는 함수
    // visit 을 사용하지 않고 parent를 이용해서 parent의 경우는 더 탐색할 필요 없는 노드로 둔다.
    static void dfs (int x, int par) {

        // y에 x의 자식 값 넣기
        for (int y : adj[x]){
            // 부모 노드인 경우 자식이 아님으로 건너띄기
            if ( y == par){
                continue;
            }
            // y의 부모 노드는 x를 가리킨다.
            parent[y] = x;
            dfs(y, x);
        }

    }

    // bfs를 한 후 K까지 가는데 걸린 최소 길이를 보여준다.
    static void pro() {
        // 1 번 정점이 ROOT 이므로, 여기서 시작해서 Tree 구조를 파악한다.
        // Root의 부모 없음으로 -1
        dfs(1, -1);
        for (int i = 2; i <= N; i++){
            System.out.println(parent[i]);
        }
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
        // 구분자를 가지고 받을 때, 기본 구분자 --> 공백
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

        // 구분자 없이 한 줄로 받을 때
        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}