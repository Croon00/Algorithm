import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int A = Integer.parseInt(br.readLine());


        int [] nums = new int[A];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < A; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int [] maxSum = new int[A];

        int ans = 0;

        // dp를 자기 자신의 값으로 초기화
        for(int i = 0; i < A; i++){
            maxSum[i] = nums[i];
            ans = Math.max(ans , maxSum[i]);
        }



        for(int i = 1; i < A; i++){
            for(int j = 0; j < i; j++){
                // 지금 값이 전의 값 보다 크기 && 현재 sum이 < j의 max 값 + 현재 값 인 경우
                if(nums[i] > nums[j] && maxSum[i] < maxSum[j] + nums[i]){
                    maxSum[i] = maxSum[j] + nums[i];
                    ans = Math.max(ans, maxSum[i]);
                }
            }
        }

        System.out.println(ans);
    }
}