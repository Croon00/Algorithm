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
        st = new StringTokenizer(br.readLine());

        int [] length = new int[A];
        Arrays.fill(length, 1);


        int [] nums = new int[A];
        int ans = 1;
        for(int i = 0; i < A; i++){
            nums[i] = Integer.parseInt(st.nextToken());

        }

        // 1 번째 인덱스부터 A-1 번째 인덱스에
        for(int i = 1; i < A; i++){
            // 0번째 인덱스부터 자기 자신 전까지
            for(int j = 0; j < i; j++){
                // 내 값이 더 크면서, 해당 length에 + 1 했을 때 현재 length의 값 보다 클 때
                if(nums[i] > nums[j] && length[i] < length[j] + 1){
                    length[i] = length[j] + 1;
                    ans = Math.max(ans, length[i]);

                }
            }
        }

        System.out.println(ans);
    }
}