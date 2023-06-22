import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 100보다 작은 자연수
        int M = Integer.parseInt(st.nextToken()); // 50보다 작거나 같은 자연수

        int [][] guitar = new int[M][2];

        // N개의 끊어진 줄, M 개의 브랜드
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            // 가격 0 ~ 1000
            // 각 브랜드의 패키지 가격, 낱개 가격
            guitar[i][0] = Integer.parseInt(st.nextToken());
            guitar[i][1] = Integer.parseInt(st.nextToken());
        }

        // 적어도 N개의 기타줄을 사기 위해 필요한 돈의 최소값 출력

        int ans = 1000001; // 기타 줄이 N 은 100개 * 1000임으로 최대 값은 1000000임
        int string = N;
        int money = 1000001;

        if(string >= 6){
            for(int i = 0; i < M; i++){
                money =Math.min(money, (string / 6) * guitar[i][0]);

            }
        }
        string %= 6;


        int minMoney = 1000001;
        for(int i = 0; i < M; i++){
            minMoney = Math.min(minMoney, string * guitar[i][1]);
        }

        int packageMoney = 1000001;
        for(int i = 0; i < M; i++){
            int num = 0;
            int Pmoney = 0;
            while (num < N){
                Pmoney += guitar[i][0];
                num += 6;
            }
            packageMoney = Math.min(packageMoney, Pmoney);
        }

        int singleMoney2 = 1000001;

        for(int i = 0; i < M; i++){
            int num = 0;
            int singleMoney = 0;
            while (num != N){
                singleMoney += guitar[i][1];
                num++;
            }
            singleMoney2 = Math.min(singleMoney2, singleMoney);
        }

        ans = money + minMoney;

        ans = Math.min(ans, packageMoney);
        
        ans = Math.min(ans, singleMoney2);
        System.out.println(ans);
    }
}
