import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#" + tc + "\n");
            int N = Integer.parseInt(br.readLine());

            // N 크기 만큼의 2차원 배열
            int [][] num = new int[N][N];
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                // 2차원 배열 받기
                for(int j = 0; j < N; j++){
                    num[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 함수를 통해 90도를 받고 180도 270도는 90도를 90도 하고 180도를 90도 하면 된다.
            int [][] rotated90 = rotated90(num);
            int [][] rotated180 = rotated90(rotated90);
            int [][] rotated270 = rotated90(rotated180);

            // 90도 , 180도, 270 도 돌린 값들의 위에 행부터 " " 씩 띄워서 보여줘야 한다.
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    sb.append(rotated90[i][j]);
                }
                sb.append(" ");
                for(int j = 0; j < N; j++){
                    sb.append(rotated180[i][j]);
                }
                sb.append(" ");
                for(int j = 0; j < N; j++){
                    sb.append(rotated270[i][j]);
                }
                sb.append("\n");
            }

            System.out.print(sb);
        }
    }

    // 90도 돌리는 함수
    static int[][] rotated90 (int [][]num){
        // 90 도 돌아진 값을 받을 2차원 배열
        int [][] rotated = new int[num.length][num.length];
        // 90도 돌리려면 아래에 있는 열부터 읽어서 행렬에 채우면 된다.
        for(int i = 0; i < num.length; i++){
            for(int j = 0; j < num.length; j++){
                rotated[i][j] = num[num.length - 1 - j][i];
            }
        }
        return rotated;
    }
}

