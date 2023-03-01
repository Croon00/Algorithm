import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /*
        상승과 하강 배열을 모두 만들어서 그 합이 가장 큰 것
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int A = Integer.parseInt(br.readLine());

        int [] nums = new int[A];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < A; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int [] up = new int[A];
        int [] down = new int[A];

        Arrays.fill(up,1);
        Arrays.fill(down, 1);

        int ans = 0;

        // up 구하기
        for(int i = 1; i < A; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j] && up[i] < up[j] + 1){
                    up[i] = up[j] + 1;
                }
            }
        }

        // down 구하기
        for(int i = A - 2; i >= 0; i--){
            for(int j = A - 1; j > i; j--){
                if(nums[i] > nums[j] && down[i] < down[j] + 1){
                    down[i] = down[j] + 1;
                }
            }
        }

        for(int i = 0; i < A; i++){
            ans = Math.max(ans, up[i] + down[i]);
        }
        System.out.println(ans - 1);
    }
}