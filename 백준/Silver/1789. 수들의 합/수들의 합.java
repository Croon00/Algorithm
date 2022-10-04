

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long N = Long.parseLong(br.readLine());

        long sum = 0;

        int cnt = 0;
        long num = 1;

        // 누적해서 값을 더하다 N 보다 커지면 N을 맞춰주기 위한 값을 1개 빼면 된다.
        while (sum <= N){
            sum += num;
            num++;
            cnt++;
        }

        System.out.println(cnt - 1);
    }
}