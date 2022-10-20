

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    bfs 2개 돌리기

 */
public class Main {
    static Character [][] rgb;
    static int N;
    static int ansGeneral, ansWeak;
    static boolean [][][] visited;
    static int [][] dir = {{-1,0}, {1,0}, {0,-1},{0,1}};

    static class rgbPoint{
        int x;
        int y;
        Character Color;

        public rgbPoint(int x, int y, Character color) {
            this.x = x;
            this.y = y;
            Color = color;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        ansGeneral = 0;
        ansWeak = 0;

        visited = new boolean[N][N][2];
        rgb = new Character[N][N];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                rgb[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j][0]){
                    rgbPoint rgbpoint = new rgbPoint(i,j, rgb[i][j]);
                    bfs_rgbWeak(rgbpoint);
                    ansWeak++;
                }
                if(!visited[i][j][1]){
                    rgbPoint rgbpoint = new rgbPoint(i,j, rgb[i][j]);
                    bfs(rgbpoint);
                    ansGeneral++;
                }
            }
        }

        
        System.out.println(ansGeneral + " " + ansWeak);

    }

    // 적록색약 bfs
    static void bfs_rgbWeak(rgbPoint rgbpoint){
        Queue<rgbPoint> queue = new LinkedList<>();
        queue.add(rgbpoint);
        visited[rgbpoint.x][rgbpoint.y][0] = true;

        while (!queue.isEmpty()){
            rgbPoint rgbColor = queue.poll();
            // 방문처리


            Character color = rgbColor.Color;

            for(int k = 0; k < 4; k++){

                int nr = rgbColor.x + dir[k][0];
                int nc = rgbColor.y + dir[k][1];

                if(nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc][0]) continue;


                // 적록 색약인 경우에는 빨강 혹은 녹색일 때 빨강 녹색이면 큐에 넣기
                if(color == 'R' || color == 'G'){
                    if(rgb[nr][nc] == 'R' || rgb[nr][nc] == 'G'){
                        // 계속 다음으로 이동
                        rgbPoint nextRgbPoint = new rgbPoint(nr,nc, rgb[nr][nc]);
                        visited[nextRgbPoint.x][nextRgbPoint.y][0] = true;
                        queue.add(nextRgbPoint);

                    }
                }

                // 파랑일 경우 파랑으로 계속 큐에 넣기
                else{
                    if(rgb[nr][nc] == 'B'){
                        // 계속 다음으로 이동
                        rgbPoint nextRgbPoint = new rgbPoint(nr,nc, rgb[nr][nc]);
                        visited[nextRgbPoint.x][nextRgbPoint.y][0] = true;
                        queue.add(nextRgbPoint);

                    }
                }
            }

        }

    }
    // 일반인 bfs
    static void bfs(rgbPoint rgbpoint){
        Queue<rgbPoint> queue = new LinkedList<>();
        queue.add(rgbpoint);
        visited[rgbpoint.x][rgbpoint.y][1] = true;

        while (!queue.isEmpty()){
            rgbPoint rgbColor = queue.poll();
            // 방문처리

            Character color = rgbColor.Color;

            for(int k = 0; k < 4; k++){
                int nr = rgbColor.x + dir[k][0];
                int nc = rgbColor.y + dir[k][1];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc][1]) continue;


                // 현재 있는 위치의 rgb 색과 같은 rgb 색이 나오면 계속 큐에 넣기
                if(color == rgb[nr][nc]){
                    // 계속 다음으로 이동
                    rgbPoint nextRgbPoint = new rgbPoint(nr,nc, rgb[nr][nc]);
                    visited[nextRgbPoint.x][nextRgbPoint.y][1] = true;
                    queue.add(nextRgbPoint);
                }

                
            }

        }

    }
}