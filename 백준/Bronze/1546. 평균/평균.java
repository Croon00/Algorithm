import java.util.*;
import java.io.*;

public class Main {

    // 구구단

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());

        float [] score = new float[N];

        float maxScore = 0;
        float sum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            score[i] = Integer.parseInt(st.nextToken());
            sum += score[i];
            maxScore = Math.max(maxScore, score[i]);
        }

        float ans = 0;
        for(int i = 0; i < N; i++){
            float temp = score[i] / maxScore * 100;
            ans += temp;
        }

        System.out.println(ans / N);
    }
}



