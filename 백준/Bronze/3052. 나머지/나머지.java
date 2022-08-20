import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int [] rest = new int[42];
        int cnt = 0;
        for(int i = 0; i < 10; i++){
            int N = Integer.parseInt(br.readLine());
            rest[N % 42]++;
        }
        for(int i = 0; i < 42; i++){
            if(rest[i] != 0){
                cnt++;
            }
        }
        sb.append(cnt);
        System.out.println(sb);
    }
}