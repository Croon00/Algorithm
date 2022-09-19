import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader fr = new FastReader();
    static int N, M;
    static String road[];
    static int distance[][];
    static boolean visit[][];
    static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    static void input(){
        N = fr.nextInt();
        M = fr.nextInt();
        visit = new boolean[N][M];
        road = new String[N];
        distance = new int[N][M];
        for (int i = 0; i < N; i++){
            road[i] = fr.nextLine();
        }

    }

    static void bfs (int x, int y) {
        // distance 배열 초기화 (갈 수 없는 것으로 -1로 초기화)
        for (int i = 0; i < N; i++){
             for (int j = 0; j < M; j++){
                 distance[i][j] = -1;
             }
        }
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        Q.add(y);
        // 시작에서 1칸 밟음으로 1
        distance[x][y] = 1;
        visit[x][y] = true;

        // distance[][] 값이 -1인 경우 visit의 역할을 대신 해줄 수도 있다.
        while(!Q.isEmpty()){
            x = Q.poll();
            y = Q.poll();
            for (int k = 0; k < 4; k++){
                int nx = x + dir[k][0], ny = y + dir[k][1];
                // 제한된 값 밖인 경우 건너띄기
                if(nx < 0 || ny < 0 || nx >= N || ny >= M){
                    continue;
                }
                // 벽인 경우 건너띄기
                if(road[nx].charAt(ny) == '0'){
                    continue;
                }
                // 방문한 경우 건너띄기
                if(visit[nx][ny]){
                    continue;
                }
                Q.add(nx);
                Q.add(ny);
                visit[nx][ny] = true;
                // 시작점에서 x,y까지 온 거리에서 하나 더 지나갔음으로 + 1 해준다.
                distance[nx][ny] = distance[x][y] + 1;
            }
        }
    }


    static void pro() {
        // 시작점 (0, 0) 부터 탐색 시작
        bfs(0, 0);

        // 마지막 위치 까지 가는데 걸린 거리는 distance 배열 끝에 나와있다.
        System.out.println(distance[N-1][M-1]);

    }

    public static void main(String[] args) {
       input();
       pro();
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));

        }
        // 구분자를 가지고 받을 때, 기본 구분자 --> 공백
        String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        long nextLong(){
            return Long.parseLong(next());
        }

        // 구분자 없이 한 줄로 받을 때
        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}