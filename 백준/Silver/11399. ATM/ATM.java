import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int [] P = new int[N];
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int [] sumP = new int[N];
        int minTime = 0;
        for(int i = 0; i < N; i++){
            P[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(P);

        for(int i = 0; i < N; i++){
            sum += P[i];
            sumP[i] = sum;
            minTime += sumP[i];
        }

        sb.append(minTime);
        System.out.println(minTime);

    }
}