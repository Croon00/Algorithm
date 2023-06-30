import java.util.*;
import java.io.*;

public class Main {
    /*
    독일 로또 1 ~ 49 개의 수중에 6개를 고른다
    49가지 수중 k 개의 수를 (k > 6) 골라 집합 S를 만든 다음 그 수만 가지고 있는 번호를 선택한다.

     */

    static int [] S;
    static int k;
    static boolean [] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        while (true){
            st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());
            // 0이 오면 끝
            if(k == 0) break;

            // 50 개의 숫자
            visited = new boolean[50];
            S = new int[k + 1];
            for(int i = 1; i <= k; i++){
                S[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 1);
            sb.append("\n");
        }

        System.out.println(sb);

    }

    // 순서 x 조합으로 6개 뽑기
    static void dfs(int cnt, int idx){
        // 6개 뽑았을 때
        if(cnt == 6){
            // 50개의 수중 true 된 것들
            for(int i = 1; i < 50; i++){
                if(visited[i]) sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        // S의 집합을 1 부터 k 까지
        // 해당 값을 visited에서 방문 체크 하고 dfs 한 후 다시 방문 체크 해제
        for(int i = idx; i <= k; i++){
            visited[S[i]] = true;
            dfs(cnt + 1, i + 1);
            visited[S[i]] = false;
        }
    }
}
