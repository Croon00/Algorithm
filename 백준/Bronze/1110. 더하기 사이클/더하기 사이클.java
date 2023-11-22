import java.util.*;
import java.io.*;

public class Main {

    // 더하기 사이클
    // 0보다 크거나 같음, 99보다 작거나 같음
    // 10보다 작으면 앞에 0을 붙여 두 자리수로 만들기 후 각 자리수 더하기


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int cnt = 1;

        // 10 이상으로 만들기
        if(N < 10){
            N *= 10;
        }

        int sum = N / 10 + N % 10;

        int num = N % 10 * 10 + sum % 10;

        while (num != N){
            sum = num / 10 + num % 10;
            num = num % 10 * 10 + sum % 10;
            cnt++;
        }

        System.out.println(cnt);
    }
}



