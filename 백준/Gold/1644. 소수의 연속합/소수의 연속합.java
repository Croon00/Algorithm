import java.util.*;
import java.io.*;

public class Main {


    // 하나 이상의 연속된 소수의 합으로 나타낼 수 있는 자연수
    // 자연수가 주어졌을 때 이 자연수를 연속된 소수의 합으로 나타낼 수 있는 경우의 수를 구하라
    // 자연수 N 은 1 ~ 400만
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());


        // 미리 채워넣으면 될거 같은데

        int [] ans = new int[4000001];

        // 에라스토테네스의 체로 소수 구하기

        boolean [] check = new boolean[4000001];

        check[0] = true;
        check[1] = true;

        for(int i = 2; i <= 4000000; i++){
            if(check[i]) continue;
            for(int j = i + i; j <= 4000000; j += i){
                check[j] = true;
            }
        }


        // 시작 값은 2
        int startIdx = 2;
        // 시작 값이 400만 넘으면 끝
        while (startIdx <= 4000000){
            int sum = 0;

            for(int i = startIdx; i <= 4000000; i++){

                if(!check[i]) {
                    sum += i;
                    if(sum > 4000000) break;
                    ans[sum]++;
                }
            }

            startIdx++;

            while (startIdx <= 4000000 && check[startIdx]) startIdx++;

        }

        System.out.println(ans[N]);
    }
}



