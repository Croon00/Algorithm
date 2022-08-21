import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1001 ~ 1001 가로 세로 길이 액자
        int [][] paper = new int[1001][1001];
        int N = Integer.parseInt(br.readLine());
        // N 번째 종이까지
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            // 해당 색종이 번호를 넣을 칸들
            for(int j = x; j < x + width; j++){
                for(int k = y; k < y + height; k++){
                    paper[j][k] = i;
                }
            }

        }
        // 색종이 갯수만큼 이 번호와 같은 부분 칸을 찾으면 cnt++해서 보여주기
        for(int i = 1; i <= N; i++){
            int cnt = 0;
            for(int j = 0; j < 1001; j++){
                for(int k = 0; k < 1001; k++){
                    if(paper[j][k] == i){
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}