
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int [] parent, cnt;
    static final int MAX = 1000000 + 1;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());


        // 각 원소들의 부모
        parent = new int[MAX];
        // union 할때 연결 되 있는 수 세기
        cnt = new int[MAX];

        // 자기 자신으로 make-Set
        for(int i = 1; i < MAX; i++){
            parent[i] = i;
            cnt[i] = 1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            // I는 조립
            if(command.equals("I")){
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                union(n1, n2);

            }
            // Q는 해당 로봇의 부품이 몇 개인지
            else if(command.equals("Q")){
                int n3 = Integer.parseInt(st.nextToken());
                sb.append(cnt[findSet(n3)]).append("\n");
            }
        }
        System.out.println(sb);


    }


    //
    static int findSet(int x){
        if(parent[x] == x) return x;
        return parent[x] = findSet(parent[x]);
    }

    static void union(int x, int y){
        x = findSet(x);
        y = findSet(y);

        if(x != y){
            parent[y] = x;
            cnt[x] += cnt[y];
        }


    }
}


