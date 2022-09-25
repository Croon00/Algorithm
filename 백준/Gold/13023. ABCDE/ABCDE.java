

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    dfs로 들어가면서 모두 연결된 경우 찾기
 */
public class Main {
    static int N, M;
    static ArrayList<Integer> [] graph;
    static boolean [] visited;
    static boolean flag = false;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++){
            graph[i] = new ArrayList<>();
        }

        // 그래프 형태 받기
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        // 0부터 
        for(int i = 0; i < N; i++){
            if(!flag){
                visited[i] = true;
                dfs(i, 1);
                visited[i] = false;
            }
        }

        if(flag){
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }

    }

    // dfs 로 들어가면서 5개 노드 연결 된 경우
    static void dfs(int idx, int cnt){
        if(flag){
            return;
        }
        if(cnt == 5){
            flag = true;
            return;
        }

        for(int i = 0; i < graph[idx].size(); i++){
            int tmp = graph[idx].get(i);
            if(!visited[tmp]){
                visited[tmp] = true;
                dfs(tmp, cnt + 1);
                visited[tmp] = false;
            }
        }
    }
}


