import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int N, M;
    static int [] nums;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];


        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();


        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            // upperBound와 lowerBound의 차이 값을 구한다.
            sb.append(upperBound(num) - lowerBound(num)).append(' ');
        }
        System.out.println(sb);

    }

    private static int lowerBound(int num) {
        int L = 0;
        int R = nums.length - 1;
        int ans = R + 1;

        // lo가 hi랑 같아질 때 까지 반복
        while (L  <=  R) {

            int mid = (L  + R) / 2; // 중간위치를 구한다.

            // 같은 경우 왼쪽 인덱스로 내려가게 한다.
            if (num <= nums[mid]) {
                ans = mid;
                R = mid - 1;

            }
            //
            else {
                L  = mid + 1;
            }
        }
        return ans;
    }

    private static int upperBound(int num) {
        int L = 0;
        int R = nums.length - 1;
        int ans = R + 1;

        // lo가 hi랑 같아질 때 까지 반복
        while (L <= R) {

            int mid = (L + R) / 2; // 중간위치를 구한다.

            // key값이 중간 위치의 값보다 작을 경우
            if (num < nums[mid]) {
                ans = mid;
                R = mid - 1;
            }
            // 중복원소의 경우 else에서 처리된다.
            else {
                L = mid + 1;
            }

        }
        return ans;
    }


}