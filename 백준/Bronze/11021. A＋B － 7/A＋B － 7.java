import java.util.*;
import java.io.*;

public class Main {

    // 구구단

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        int A = 0;
        int B = 0;
        for(int i = 1; i <= T; i++){
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            int sum = A + B;
            sb.append("Case #" + i +": " + sum).append("\n");
        }
        System.out.println(sb);
    }
}



