import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int [] num;
    static int N;
    static int K;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        num = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        dfs(0);
        System.out.println(ans);
    }

    static void dfs(int n){
        if(n > N){
            return;
        }
        if(ans < n){
            ans = n;
        }
        for(int i = K - 1; i >= 0; i--){
            dfs(n * 10 + num[i]);
        }
    }
}