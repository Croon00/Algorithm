import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static final int MOD = 1234567891;
    static long [] factorial = new long[1000001]; // MOD로 모듈러 연산한 factorial 값을 담을 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        factorial();
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            // nCr에서 분자 부분
            long up = factorial[N];
            // nCr에서 분모 부분
            long bottom = (factorial[N-K] * factorial[K]) % MOD;
            // 역을 구하기 위해서 MOD-2
            bottom = pow(bottom, MOD-2);

            System.out.println("#" + tc + " " + (up * bottom) % MOD);

        }

    }
    static void factorial(){
        // 0은 1
        factorial[0] = 1;
        // factorial 하면서 그전 값 * 자기값 i 에서 모듈러 연산한 값을 넣는다.
        for(int i = 1; i < 1000001; i++){
            factorial[i] = (factorial[i - 1] * i) % MOD;
        }
    }

    static long pow(long n, long k){
        if(k == 1){
            return n;
        }
        long x = pow(n, k/2) % MOD;
        if(k % 2 == 0){
            return (x * x) % MOD;
        }
        else{
            return ( (x * x) % MOD * n) % MOD;
        }
    }
}