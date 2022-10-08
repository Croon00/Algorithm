import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int [][] num;
    static int ans;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N][M];

        // 완전 제곱수 안되었을 경우 -1
        ans = -1;

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                num [i][j] = s.charAt(j) - '0';
            }
        }

        // 각 칸에 대해서 등차수열 전부 해보기
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                dfs(i, j);
            }
        }
        System.out.println(ans);

    }

    // 행의 공차, 열의 공차를 받아서 제곱 수인지 확인해서 넣기
    static void dfs(int r, int c){
        // -N의 공차 부터 N - 1까지 가능, -M ~ M - 1의 공차도 가능하다.
        for(int i = -N; i < N; i++){
            for(int j = -M; j < M; j++){
                // 공차가 모두 0인 경우는 건너띄기
                if(i == 0 && j == 0) continue;

                int row = r;
                int col = c;

                // 제곱수
                int sqr = 0;

                // 해당 수가 완전 제곱수 인지 확인 
                // 범위 넘어가지 않으면서
                while (row >= 0 && row < N && col >= 0 && col < M){
                    // 10 곱해서 넣어서 숫자 뽑기
                    sqr *= 10;
                    sqr += num[row][col];

                    // 제곱근 하여서
                    int root = (int)Math.sqrt(sqr);
                    
                    // 제곱근의 제곱이 sqr과 같은 경우 완전 제곱근이다.
                    if(Math.pow(root, 2) == sqr){
                        ans = Math.max(ans, sqr);
                    }
                    row += i;
                    col += j;
                }

            }
        }


    }

}