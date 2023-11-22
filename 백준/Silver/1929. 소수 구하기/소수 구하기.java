import java.util.*;
import java.io.*;

public class Main {

    // 소수 찾기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        boolean [] num = new boolean[1000001];
        num[0] = true;
        num[1] = true;

        // 에라스토테네스의 체
        for(int i = 2; i <= 1000000; i++){

            if(!num[i]){
                for(int j = i + i; j <= 1000000; j += i){
                    num[j] = true;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for(int i = M; i <= N; i++){
            if(!num[i]) sb.append(i).append("\n");
        }
        System.out.println(sb);

    }
}



