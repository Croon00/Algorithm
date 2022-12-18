import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    /*
        n개의 자연수 중에서 M개를 고른 수열
        중복 수열 x
        사전 순으로 증가
        숫자는 중복 x
     */
    static int N, M; // N, M
    static int [] num; // 숫자 배열
    static int [] selected; // 들어갈 숫자
    static boolean [] visited; // 사용한 idx를 체크할 visited
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        visited = new boolean[N];
        selected = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        // 사전순으로 보여주기 위한 정렬
        Arrays.sort(num);

        dfs(0);
        System.out.println(sb);

    }

    static void dfs(int cnt){

        if(cnt == M){
            for(int i = 0; i < M; i++){
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        // 사용한 visited면 건너띄고 아닐 경우에만 dfs돌리면서 cnt + 1
        for(int i = 0; i < N; i++){
            if(visited[i]) continue;

            visited[i] = true;
            selected[cnt] = num[i];
            dfs(cnt + 1);

            visited[i] = false;
        }

    }



}
