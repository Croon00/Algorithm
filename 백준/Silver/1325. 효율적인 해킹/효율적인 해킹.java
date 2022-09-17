import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, max;
    static ArrayList<Integer> [] computer;
    static int [] cnt;
    static boolean [] visit;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        computer = new ArrayList[N + 1];
        cnt = new int [N + 1];
        max = 0;
        for(int i = 1; i <= N; i++){
            computer[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            // A가 B를 신뢰하는 경우 B를 해킹하면 A도 해킹 가능
            computer[A].add(B);
        }

        // bfs를 정점마다 하기
        for(int i = 1; i <= N; i++){
            visit = new boolean[N + 1];
            bfs(i);
        }

        // max 값을 구하기
        for(int i = 1; i <= N; i++){
            max = Math.max(cnt[i], max);
        }


        // max 인 경우 오름차순 대로 쌓기
        for(int i = 1; i <= N; i++){
            if(max == cnt[i]){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);

    }


    // bfs
    static void bfs(int x){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visit[x] = true;

        while (!queue.isEmpty()){
            int y = queue.poll();
            for(int i = 0; i < computer[y].size(); i++){
                if(!visit[computer[y].get(i)]){
                    // 간선으로 이어진 값들의 cnt++
                    cnt[computer[y].get(i)]++;
                    visit[computer[y].get(i)] = true;
                    queue.add(computer[y].get(i));
                }
            }
        }
    }
}