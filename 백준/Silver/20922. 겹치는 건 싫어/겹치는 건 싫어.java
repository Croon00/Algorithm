import java.util.*;
import java.io.*;

public class Main {

    // 겹치는 건 싫어

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 수열에서 같은 원소가 여러개 들어있는거 싫어
        // K개 이하로 들어있는 최장 연속 부분 수열의 길이 구하기

        int N, K;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int [] num = new int[100001];

        int [] nums = new int[N];

        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int ans = 0;
        int sumLength = 0;


        while (end < N){
            // 현재 새로 추가하는 값이 더해졌을 때 K값 이하이면 계속해서 추가
            while(end < N && num[nums[end]] + 1 <= K){
                num[nums[end]]++;
                end++;
            }
            // 길이는 끝 인덱스 - 시작 인덱스
            sumLength = end - start;
            
            // 정답은 더 큰 값, start인덱스 부분 다시 빼고 start 인덱스++
            ans = Math.max(ans, sumLength);
            num[nums[start]]--;
            start++;
        }

        System.out.println(ans);
    }

}



