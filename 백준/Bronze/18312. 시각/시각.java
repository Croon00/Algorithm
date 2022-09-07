import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int hour = 0;
        int min = 0;
        int sec = 0;
        int cnt = 0;
        while (true){
            if(sec == 60){
                min++;
                sec = 0;
                if(min == 60){
                    hour++;
                    min = 0;
                }
            }
            if(hour == N + 1){
                break;
            }
            if(hour % 10 == K || hour / 10 == K || min % 10 == K || min / 10 == K || sec % 10 == K || sec / 10 == K){
                cnt++;
            }
            sec++;
        }
        System.out.println(cnt);
    }
}
