import java.util.*;
import java.io.*;

public class Main {

    /*
        F층으로 이루어진 고층 건물
        G층에 존재하는 스타트링크
        강호가 있는 층은 S층
        엘레베이터 타고 G 층으로 이동
        위로 U층을 가는 U버튼, 아래로 D층을 가는 D 버튼 두 개
        G층에 가려면 버튼을 몇 번 눌러야 하는지 작성
        G층을 못 가면 use the stairs 출력
     */
    static int F, S, G, U, D;
    static boolean [] visited;
    static int ans;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        // S,G,F 1 ~1000000
        // U,D 0 ~ 1000000

        F = Integer.parseInt(st.nextToken()); // 총 층수
        S = Integer.parseInt(st.nextToken()); // 시작하는 층
        G = Integer.parseInt(st.nextToken()); // 도착해야 하는 층
        U = Integer.parseInt(st.nextToken()); // 올라가는 층
        D = Integer.parseInt(st.nextToken()); // 내려가는 층
        visited = new boolean[F + 1];

        ans = Integer.MAX_VALUE;

        bfs(S);

        if(!visited[G]){
            System.out.println("use the stairs");
        }
        else{
            System.out.println(ans);
        }

    }

    static void bfs(int floor) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(floor);
        queue.add(0);
        visited[floor] = true;

        // bfs로 돌리기
        while (!queue.isEmpty()){
            // 현재 층과 버튼 누른 횟수수
            int currentFloor = queue.poll();
            int cnt = queue.poll();

            // 도착 했을 경우 ans 최소 값으로
            if(currentFloor == G){
                ans = Math.min(ans, cnt);
            }

            // F만큼 올라갔을 때 F 층 이하일 경우
            if(currentFloor + U <= F){
                // 방문 체크 해주고 다음 queue에 추가
                if(!visited[currentFloor + U]){
                    queue.add(currentFloor + U);
                    queue.add(cnt + 1);
                    visited[currentFloor + U] = true;
                }
            }

            // D만큼 내려갔을 때 1층 이상일 경우
            if(currentFloor - D >= 1){
                // 방문 체크 해주고 다음 queue에 추가
                if(!visited[currentFloor - D]){
                    queue.add(currentFloor - D);
                    queue.add(cnt + 1);
                    visited[currentFloor - D] = true;
                }
            }
        }
    }
}
