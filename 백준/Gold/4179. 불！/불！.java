
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int R, C, ans;

    static Character [][] map;
    static boolean flag;
    static int [][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static Queue<Point> J = new LinkedList<Point>();
    static Queue<Point> F = new LinkedList<>();

    static class Point{
        int x;
        int y;
        int d;

        public Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new Character[R][C];

        for(int i = 0; i < R; i++){
            String s = br.readLine();
            for (int j = 0; j <C; j++){
                map[i][j] = s.charAt(j);
                // 지훈이 있는 곳을 큐에 저장
                if (map[i][j] == 'J'){
                    J.add(new Point(i,j, 0));
                }
                // 불 있는 곳들을 큐에 저장
                else if(map[i][j] == 'F'){
                    F.add(new Point(i, j, 0));
                }
            }
        }
        bfs();
        if(flag){
            System.out.println(ans);
        }
        else{
            System.out.println("IMPOSSIBLE");
        }

    }

    static void bfs(){
        
        // 지훈이 없어질때 까지

        while (!J.isEmpty()){
            
            // 불을 먼저 옮겨야함
            // 불은 먼저 안옮기면 불이 옮겨진 쪽으로 인간이 갈 수 있음

            // 불 있던 위치들 부터 다 옮기기 (현재 있던 위치만)
            // 사이즈를 처음에 만들어주어야 한다. i < F.size() 하면 F의 사이즈가 시시 각각 바뀌기 떄문에 사용 X
            int size = F.size();
            for(int i = 0; i < size; i++) {
                Point fire = F.poll();

                for (int k = 0; k < 4; k++) {
                    int nr = fire.x + dir[k][0];
                    int nc = fire.y + dir[k][1];

                    // 범위 안에 있으면서 벽이거나 불이나지 않은 곳에 불 일으키기
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                        if (map[nr][nc] != '#' && map[nr][nc] != 'F') {
                            map[nr][nc] = 'F';
                            F.add(new Point(nr, nc, fire.d + 1));
                        }
                    }
                }
            }
            // 지훈이 위치
            size = J.size();
            for(int i = 0; i < size; i++){
                Point j = J.poll();

                for(int k = 0; k < 4; k++){
                    int nr = j.x + dir[k][0];
                    int nc = j.y + dir[k][1];

                    // 범위 넘어가면 맵 밖으로 나감
                    if(nr < 0 || nr >= R || nc < 0 || nc >= C){
                        // ans에 거리 + 1 한 값을 가지고 나가기
                        flag = true;
                        ans = j.d + 1;
                        return;
                    }
                        // 나가지 못했으면
                    else{
                        // 땅인 곳에만 이동 가능
                        if(map[nr][nc] == '.'){
                            map[nr][nc] = 'J';
                            J.add(new Point(nr, nc, j.d+ 1));
                        }
                    }
                }
            }
        }
    }

}


