import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        // M 자리수 까지 채워야 함으로
        selected = new int[M + 1];
        // N 까지의 수를 나타내야 함으로
        used = new int[N + 1];
    }
    static int N, M, selected[], used[];



    static void rec_func(int k){
        if(k == M + 1){
            for(int i = 1; i <= M; i++){
                // StringBuilder에 각 수열 자릿수 넣기
                sb.append(selected[i]).append(' ');
            }
            // 다음 수열 넣기
            sb.append('\n');
        }
        else{
            for(int cand = 1; cand <= N; cand++){
                // k번째 자리에 값 넣기
                if(used[cand] == 1){
                    continue;
                }

                selected[k] = cand;
                used[cand] = 1;

                // k+1번째 자리도 넣기
                rec_func(k + 1);
                selected[k] = 0;
                used[cand] = 0;

            }
        }

    }


    public static void main(String[] args) {
        input();

        rec_func(1);
        System.out.println(sb.toString());

    }



    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

    }
}