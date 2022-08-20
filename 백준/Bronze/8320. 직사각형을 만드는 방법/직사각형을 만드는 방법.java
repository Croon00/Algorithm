import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        // 사각형 가로 갯수
        for(int i = 1; i <= N; i++){
            // 사각형 세로 갯수
            for(int j = i; j * i <= N; j++){
                count++;
            }
        }
        sb.append(count);
        System.out.println(sb);

    }
}
