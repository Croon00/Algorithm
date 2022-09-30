import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        int [] A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int [] B = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(B);
        int [] C = new int[N];

        for(int i = 0; i < B.length; i++){
            C[i] = B[B.length - i - 1];
        }

        for(int i = 0; i < N; i++){
            sum += A[i] * C[i];
        }
        System.out.println(sum);
    }
}