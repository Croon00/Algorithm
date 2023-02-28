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
        int [] length = new int[A];

        Arrays.fill(length, 1);


        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < A; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 1;

        for(int i = 1; i < A; i++){
            for(int j = 0; j < i; j++){
                // 더 감소한 값이면서, 길이가 더했을 때 더 큰 경우
                if(nums[i] < nums[j] && length[i] < length[j] + 1){
                    length[i] = length[j] + 1;
                    ans = Math.max(ans, length[i]);
                }
            }
        }
        System.out.println(ans);
    }
}