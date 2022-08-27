import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        // 기존 격자, 입력한 격자, 결과 격자
        Character[][] board = new Character[N][N];
        Character[][] open = new Character[N][N];
        Character[][] ans = new Character[N][N];
        // 지뢰를 밟았는지 아닌지 확인
        boolean isMine = false;
        // 8방향을 확인하기
        int [] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int [] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
        // 격자 받기
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                board[i][j] = str.charAt(j);
            }
        }
        // 누를 격자 받기
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < N; j++){
                open[i][j] = str.charAt(j);
            }
        }
        // 정답은 .으로 초기화 시켜놓는다.
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                ans[i][j] = '.';
            }
        }
        // 주어진 격자와 누른 격자를 비교하면서 확인
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                // 지뢰가 있는 곳을 눌렀을 때
                if(open[i][j] == 'x' && board[i][j] == '*'){
                    // 마인 밟음
                    isMine = true;
                    // *인 곳은 *로, 아닌 곳은 .으로 초기화 시킨다.
                    for(int k = 0; k < N; k++){
                        for(int l = 0; l < N; l++){
                            if(board[k][l] == '*'){
                                ans[k][l] = '*';
                            }
                        }
                    }
                }
                // .이면서 누른 곳이면서 아직 마인을 안눌렀을 경우
                // 8방향으로 확인하면서 지뢰 있는 만큼 수를 ++해서 보여줌
                if(open[i][j] =='x' && board[i][j] == '.' ){
                    Character temp = '0';
                    for(int k = 0; k < 8; k++){
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if(nr >= 0 && nr < N && nc >= 0 && nc < N){
                            if(board[nr][nc] == '*') {
                                temp++;
                            }
                        }
                    }
                    ans[i][j] = temp;
                }
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }
}