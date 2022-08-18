import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int ans = 1;
        // 2부터 1씩 더한 값을 보여주기
        int range = 2;
        if(N == 1){
            sb.append(1);
        }
        else{
            while(range <= N){
                range = range + (6 * ans);
                ans++;
            }
            sb.append(ans);
        }
        System.out.println(sb);
    }
}