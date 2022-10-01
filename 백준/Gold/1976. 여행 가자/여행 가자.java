
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
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean flag = true;

        // 각 원소들의 부모
        parent = new int[N + 1];

        // 자기 자신으로 make-Set
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                int a = Integer.parseInt(st.nextToken());
                // 0일때 두 도시 연결 안함
                // 1일때 두 도시 연결
                if(a == 1){
                    union(i, j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int start = findSet(Integer.parseInt(st.nextToken()));
        for(int i = 1; i < M; i++){
            int a = Integer.parseInt(st.nextToken());
            if(start != findSet(a)){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }


    //
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


