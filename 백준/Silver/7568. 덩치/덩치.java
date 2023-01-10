import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
        사람의 덩치를 키와 몸무게 이 두개의 값으로 표현해서 등수륾 매긴다.

     */
    static int N;
    static int [][] status;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        status = new int[N][2];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            status[i][0] = Integer.parseInt(st.nextToken());
            status[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            int cnt = 1;
            for(int j = 0; j < N; j++){
                // 같은 사람은 비교 x
                if(i == j) continue;

                // 나보다 키가 크고 몸무게가 높은 사람을 세서 내 순위 높이기
                if(status[i][0] < status[j][0] && status[i][1] < status[j][1]){
                    cnt++;
                }

            }
            System.out.print(cnt + " ");

        }
    }
}