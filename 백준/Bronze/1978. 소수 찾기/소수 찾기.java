import java.util.*;
import java.io.*;

public class Main {

    // 소수 찾기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        boolean [] num = new boolean[1001];
        num[0] = true;
        num[1] = true;

        // 에라스토테네스의 체
        for(int i = 2; i <= 1000; i++){

            if(!num[i]){
                for(int j = i + i; j <= 1000; j += i){
                    num[j] = true;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(st.nextToken());
            if(!num[n]){
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}



