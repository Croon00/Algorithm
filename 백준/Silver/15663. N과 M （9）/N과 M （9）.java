import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    /*
       순열 이면서 (순서 o),
       숫자는 중복 가능
       수열은 중복 x
     */

    static int N, M; // N개의 자연수와 자연수 M이 주어졌을 때
    static int [] num; // N개의 숫자 배열
    static boolean [] check; // 사용한 숫자 체크
    static int [] selected; // 가져갈 숫자
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        check = new boolean[N];
        selected = new int[M];

        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        // 사전순으로 증가하기 위한 순서 출력하기 위해 정렬
        Arrays.sort(num);

        dfs(0);

        System.out.println(sb);

    }
    // 순열 하기
    static void dfs(int cnt){
        if(cnt == M){
            for(int i = 0; i < M; i++){
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
            return;
        }


        // 수열 중복을 막기 위한 lastNum
        int lastNum = 0;

        for(int i = 0; i < N; i++){
            if(check[i]) continue;
            if(num[i] == lastNum) continue;

            lastNum = num[i];
            selected[cnt] = num[i];
            check[i] = true;
            dfs(cnt + 1);
            selected[cnt] = 0;
            check[i] = false;
        }
    }
}
