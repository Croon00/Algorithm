
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
    static int N, M, ans;

    // make-set을 위한 parent
    static int[] parent;

    // 거짓말을 아는 사람의 번호를 true하기 위한 knowNum
    static boolean[] knowNum;

    /*
        전체 사람 수 N명, 파티 수 M
        유니온 파인드를 통해서
        parent가 각 파티에 처음 나온 번호를 가리키게 하고

        반복문을 통해서 해당 번호의 사람이 거짓말을 아는 사람일때
        그 사람의 parent를

        파티만큼 반복문 돌리면서 해당 첫 번째 파티에 온 번호 사람이 false인 경우만 세기

     */


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];

        // make-set
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int knowCnt = Integer.parseInt(st.nextToken());
        knowNum = new boolean[N + 1];


        // 거짓말 아는 사람 true
        for(int i = 0; i < knowCnt; i++){
            knowNum[Integer.parseInt(st.nextToken())] = true;
        }


        // 각 파티마다 몇 명이 파티에 올줄 모르니 ArrayList[M]
        ArrayList<Integer>[] peoples = new ArrayList[M];
        // 초기화
        for(int i = 0; i < M; i++){
            peoples[i] = new ArrayList<>();
        }

        // M번의 파티
        int preNum = 0, post;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            // 파티에 k명 먼저
            int partyNumCnt = Integer.parseInt(st.nextToken());

            // 1명 이상 파티에 올 때만
            if(partyNumCnt > 0){
                // 파티 사람에 첫 번째 사람 번호 추가
                preNum = Integer.parseInt(st.nextToken());
                // 번호 추가
                peoples[i].add(preNum);
            }


            // 그 후 파티에 오는 번호들 첫 번째 사람과 union 계속하기
            // 2 명 이상 올 때만 돌아감
            for(int j = 1; j < partyNumCnt; j++){
                post = Integer.parseInt(st.nextToken());
                peoples[i].add(post);
                union(preNum, post);
                preNum = post;
            }
        }

        // 1번 부터 N번중 아는 사람에 대해서 true하기
        for(int i = 1; i <= N; i++){
            if(knowNum[i]){
                knowNum[find(i)] = true;
            }
        }

        ans = 0;

        // M번 파티 돌면서
        for(int i = 0; i < M; i++){
            if(peoples[i].size() > 0){
                // 해당 파티에 첫 번째로 온 사람이 true가 아닌 경우에만 ans++
                int parent = find(peoples[i].get(0));
                if(!knowNum[parent]) ans++;
            }
        }
        System.out.println(ans);

    }

    static int find(int x){
        if(x == parent[x]){
            return parent[x] = x;
        }
        else{
            return find(parent[x]);
        }
    }


    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y){
            if(x > y){
                parent[x] = y;
            }
            else{
                parent[y] = x;
            }
        }
    }
}