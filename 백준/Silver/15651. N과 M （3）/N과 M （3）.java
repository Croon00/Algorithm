import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N, M, selected[];

    // N개의 수를 M 자리만큼 받고
    // 수열의 길이는 M + 1만큼 받기
    static void input(){
        FastReader fr = new FastReader();
        N = fr.nextInt();
        M = fr.nextInt();
        selected = new int[M + 1];
    }

    // 재귀 함수를 통해 M의 자리만큼 중복 없이 수열 만들기
    static void rec_func(int k){
        // k가 M보다 큰 경우 M의 자릿수의 수열을 다 채운 것으로 sb에 쌓아주기만 하면 된다.
        if (k > M){
            for (int i = 1; i <= M; i++){
                sb.append(selected[i]);sb.append(' ');
            }
            sb.append('\n');
        }
        else{
            for(int cand = 1; cand <= N; cand++){
                selected[k] = cand;
                rec_func(k + 1);
                selected[k] = 0;
            }

            }
        }



    public static void main(String[] args) {
        input();
        rec_func(1);
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
    }
}
