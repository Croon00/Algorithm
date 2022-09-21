import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, minDistance; // N개, 최소 거리
    static int [] company; // 회사
    static int [] home; // 집
    static int [][] customer; // 고객 집
    static boolean [] visited; // 방문 체크


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            // 최소 거리 초기화, 나머지 들도 초기화
            minDistance = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N];
            company = new int[2];
            home = new int[2];
            customer = new int[N][2];

            // 0에 x 좌표 1에 y 좌표
            st = new StringTokenizer(br.readLine());
            company[0] = Integer.parseInt(st.nextToken());
            company[1] = Integer.parseInt(st.nextToken());
            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());
            // 고객집의 수 N개 만큼 0에 x 좌표 1에 y좌표
            for(int i = 0; i < N; i++){
                for(int j = 0; j < 2; j++){
                    customer[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // cnt = 0, 회사--> 고객 집 --> 집 순서 이기 때문에 회사 x,y 좌표, 거리 0
            perm(0, company[0], company[1], 0);
            System.out.println("#" + tc + " " +minDistance);
        }
    }

    // 집으로 가는 방법은 순서 o 이기 때문에    순열
    static void perm(int cnt, int x, int y, int dis){
        // N번이면 집을 다 돌음
        if(cnt == N){
            dis += Math.abs(x - home[0]) + Math.abs(y - home[1]);
            minDistance = Math.min(minDistance, dis);
        }

        for(int i = 0; i < N; i++){
            // 방문 체크
            if(!visited[i]){
                // true로 두고
                visited[i] = true;
                // 재귀를 돌때 cnt + 1, 좌표는 고객 x, y좌표, 거리는 |x1-x2| + |y1-y2|로 다시 주기
                perm(cnt + 1, customer[i][0], customer[i][1], dis + (Math.abs(customer[i][0] - x) + Math.abs(customer[i][1] -y)));
                visited[i] = false;
            }
        }
    }
}