
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int [] parent;


    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 각 원소들의 부모
        parent = new int[N + 1];

        // 자기 자신으로 make-Set
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++){
            // 0은 합집합, 1은 포함되어 있는지 확인
            st = new StringTokenizer(br.readLine());
            int set = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 0일때 b를 a 집합으로 넣기
            if(set == 0){
                union(a, b);
            }
            // 확인할 때 같으면 YES 아니면 NO
            else if(set == 1){
                if(findSet(b) == findSet(a)){
                    sb.append("YES").append("\n");
                }
                else{
                    sb.append("NO").append("\n");
                }
            }
        }
        System.out.println(sb);

    }

    static int findSet(int x){
        // 패스 컴페레이션 적용
        if(x != parent[x]){
            parent[x] = findSet(parent[x]);
        }
        return parent[x];
    }

    static void union(int x, int y){
        parent[findSet(y)] = findSet(x);
    }
}


