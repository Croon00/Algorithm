import java.util.*;
import java.io.*;

public class Main {

    // 구구단

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int A = 0;
        int B = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            sb.append(A + B).append("\n");
        }
        System.out.println(sb);
    }
}



