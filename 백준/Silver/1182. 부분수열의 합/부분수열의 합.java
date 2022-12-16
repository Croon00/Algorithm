import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N, S, sub, nums[];

    // N개의 수를 M 자리만큼 받고
    // 수열의 길이는 M + 1만큼 받기
    static void input(){
        FastReader fr = new FastReader();
        N = fr.nextInt();
        S = fr.nextInt();
        nums = new int [N + 1];
        for (int i = 1; i <= N; i++){
            nums[i] = fr.nextInt();
        }
    }

    // 재귀 함수를 통해 M만큼의 자릿수만큼 수열들 나열
    static void rec_func(int k, int value){
        // k가 M보다 큰 경우 M의 자릿수의 수열을 다 채운 것으로 sb에 쌓아주기만 하면 된다.
        if ( k == N + 1 ){
          // value가 s와 같은지
            if(value == S){
                sub++;
            }
        }
        else{
            rec_func(k + 1, value + nums[k]);

            rec_func(k + 1, value);

            }
        }



    public static void main(String[] args) {
        input();
        rec_func(1, 0);

        if (S == 0){
            sub--;
        }
        System.out.println(sub);


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