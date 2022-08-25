import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    // N 개의 숫자, 부분 수열 합이 K, 경우의 수 cnt
    static int N, K, cnt;
    // n개의 숫자들
    static int [] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            // num을 n개 만큼 선언
            num = new int[N];
            cnt = 0;
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                num[i] = Integer.parseInt(st.nextToken());
            }
            // 재귀함수 0번째부터 합 0으로 시작
            rec(0, 0);
            System.out.println("#" + tc + " " + cnt);
        }
    }

    // 재귀 함수 idx를 받고 누적 합 sum을 받는다.
    static void rec(int idx, int sum){
        // idx가 숫자들만큼 받아들이면
        if(idx == N){
            // 만약 sum의 값이 K와 같은 경우 cnt++ 후 재귀함수 끝내기 위한 return
            if(sum == K){
                cnt++;
            }
            return;
        }
        
        // 다음 idx로 넘어갔을 때 해당 num을 더할 경우 혹은 안 더할 경우
        rec(idx + 1, sum+num[idx]);
        rec(idx + 1, sum);
    }
}