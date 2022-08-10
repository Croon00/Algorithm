import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int tc = 1; tc <= 10; tc++){
            StringBuilder sb = new StringBuilder();
            sb.append("#" + tc + " ");
            int N = Integer.parseInt(br.readLine());
            int [][] num = new int [100][100];
            // 교착 상태
            int deadRock = 0;
            
            // 100행 100열 상태 받기
            for(int i = 0; i < 100; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++){
                    num[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 100행 100열에 있는 값들 확인
            for(int i = 0; i < 100; i++){
                for(int j = 0; j < 100; j++){
                    // 열을 확인하는데 밑에서 부터 확인하면서 1이 나온 경우를 찾음
                    if(num[99-j][i] == 1) {
                        // 1이 있을 경우 그 1이 나온 부분 밑에서 부터 밑으로 2가 있는지 확인
                        for (int k = 99 - j + 1; k < 100; k++) {
                            // 2가 있다면 교착 상태가 일어남 그 후 break
                            if (num[k][i] == 2) {
                                deadRock++;
                                break;
                            }
                            // 찾는 도중 1이 있다면 이미 밑에 교착상태임으로 break
                            if (num[k][i] == 1){
                                break;
                            }
                        }
                    }
                }
            }
            sb.append(deadRock);
            System.out.println(sb);
        }
    }
}