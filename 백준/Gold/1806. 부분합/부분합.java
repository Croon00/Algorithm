import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N, S, ans, sum, nums[];

    static void input(){
        FastReader fr = new FastReader();
        N = fr.nextInt();
        S = fr.nextInt();
        nums = new int[N + 1];
        for(int i = 1; i <= N; i++){
            nums[i] = fr.nextInt();
        }

    }

    static void sort(){
        int R = 0; sum = 0; ans = N + 1;
        for( int L = 1; L <= N; L++){
            // L - 1 을 구간에서 제외하기
            sum -= nums[L - 1];

            // R을 옮겨야 할 때 옮기기(수열 갯수는 안 넘고, S의 값 보다 작을 때)
            while ( R + 1 <= N && sum < S){
                R++;
                sum += nums[R];
            }

            // [L ~ R]의 연속 부분 수열 합이(sum) S(조건)와 같으면 정답에 +1 추가
            if (sum >= S){
                ans = Math.min(ans, R - L + 1);
            }
        }
        // 한 번도 값이 갱신이 안되었다면 불가능한 연속 부분 수열이다.
        if (ans == N + 1){
            ans = 0;
        }
        System.out.println(ans);

    }


    public static void main(String[] args) {
        input();
        sort();
        System.out.println(sb.toString());

    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));

        }
        String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        long nextLong(){
            return Long.parseLong(next());
        }
    }
}