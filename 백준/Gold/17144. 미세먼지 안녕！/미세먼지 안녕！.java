import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    /*
        한 번에 미세먼지 위치와 양을 다 받고
        그 다음에 퍼뜨리기
        그 후 공기청정기에 의한 바람 이동
     */
    static int [][] dir = {{-1,0}, {1,0}, {0,-1},{0,1}};
    static int [][] board;
    static int airCleanerPoint = -1;
    static Queue<Point> queue = new LinkedList<>();
    static int R, C, T;

    static class Point {
        int x;
        int y;
        int amount;

        public Point(int x, int y, int amount) {
            this.x = x;
            this.y = y;
            this.amount = amount;
        }
    }



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        board = new int[R][C];

        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                board[i][j] = Integer.parseInt(st.nextToken());

                // 미니맵에 공기청정기 위치
               if(airCleanerPoint == -1 && board[i][j] == -1){
                    airCleanerPoint = i;
                }
            }
        }

        // T초 동안
        for(int t = 0; t < T; t++){

            // 1. 미세먼지 위치와 미세먼지 양 저장
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    // 미세먼지가 있는 위치
                    if(board[i][j] != -1 && board[i][j] != 0){
                        queue.add(new Point(i, j, board[i][j]));
                    }
                }
            }

            // 2. 미세먼지 퍼뜨리기
            while (!queue.isEmpty()){
                Point point = queue.poll();

                // 미세먼지가 5 미만이면 넘어가기
                if(point.amount < 5) continue;

                for(int k =0; k < 4; k++){
                    int nr = point.x + dir[k][0];
                    int nc = point.y + dir[k][1];

                    // 범위를 넘어가거나 공기 청정기가 있으면 넘어가기
                    if(nr < 0 || nr >= R || nc < 0 || nc >= C || board[nr][nc] == -1) continue;

                    // 해당 좌표에 /5 한 값 더하기
                    board[nr][nc] += point.amount / 5;
                    // 원래 좌표에서 /5 한 값 빼기
                    board[point.x][point.y] -= point.amount / 5;
                }
            }

            // 3. 공기청정기가 미세먼지 바람으로 불기

            int airCleaner1 = airCleanerPoint;
            int airCleaner2 = airCleanerPoint + 1;


            // 위에 공기청정기 부분
            // 아래 공기청정기로 바람 들어오기
            for(int i = airCleaner1 - 1; i > 0; i--){
                board[i][0] = board[i - 1][0];
            }

            // 오른쪽에서 왼쪽으로 바람 불기
            for(int i = 0; i < C - 1; i++){
                board[0][i] = board[0][i + 1];
            }

            // 아래서 위로 바람 불기
            for(int i = 0; i < airCleaner1; i++){
                board[i][C - 1] = board[i + 1][C - 1];
            }

            // 왼쪽에서 오른쪽으로 바람 불기
            for(int i = C - 1; i > 0; i--){
                // 공기청정기에서 바로 오는 바람 부분은 0으로 넣기
                if(i == 1){
                    board[airCleaner1][i] = 0;
                }
                else{
                    board[airCleaner1][i] = board[airCleaner1][i - 1];
                }
            }

            // 아래 공기청정기 바람 부는 방향
            // 아래에서 위로 부는 공기
            for(int i = airCleaner2 + 1; i < R - 1; i++){
                board[i][0] = board[i + 1][0];
            }

            // 오른쪽에서 왼쪽으로 바람 부는 방향
            for(int i = 0; i < C - 1; i++){
                board[R - 1][i] = board[R - 1][i + 1];
            }

            // 위에서 아래로 바람 부는 방향
            for(int i = R - 1; i > airCleaner2; i--){
                board[i][C - 1] = board[i - 1][C - 1];
            }

            // 왼쪽에서 오른쪽으로 바람 부는 방향
            for(int i = C - 1; i > 0; i--){
                // 공기 청정기에서 바로 오는 바람은 0
                if(i == 1){
                    board[airCleaner2][i] = 0;
                }
                //
                else{
                    board[airCleaner2][i] = board[airCleaner2][i - 1];
                }
            }

        }

        int ans = 0;
        // 다 끝난 후 미세먼지 있는 부분 더하기
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                // 미세먼지가 없거나 공기청정기 있는 부분이 아닌 곳에서
               if(board[i][j] != 0 && board[i][j] != -1){
                   ans += board[i][j];
               }
            }
        }
        System.out.println(ans);
    }

}