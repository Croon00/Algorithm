import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    /*
        n개의 서로 다른 양의 정수 a 수열에서
        a 수열 안에 들어있는 값은 1 보다 크거나 같고 1000000보다 작거나 같은 자연수이다.
        자연수 x가 주어졌을 때 ai + aj = x를 만족하는 ai, aj 쌍의 수를 구하는 프로그램 작성
     */

    static int n, x; // 수열의 크기n, 찾을 자연수 x
    // n 은 1 이상 10만 이하, x의 크기는 1 이상 2백만 이하.
    static int [] nums;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        n = Integer.parseInt(br.readLine());

        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        //
        Arrays.sort(nums);

        x = Integer.parseInt(br.readLine());

        System.out.println(search());
    }

    // 이분탐색으로 찾기
    static int search(){
        int cnt =0;


        // 해당 idx를 하나씩 이분탐색으로 더하기를 통해서 찾기
        for(int i = 0; i < nums.length; i++){

            // L은 i + 1 부터 세기
            int L = i + 1;
            int R = nums.length - 1;

            while (L <= R){
                int mid = (L + R) / 2;

                if(nums[i] + nums[mid] > x){
                    R = mid - 1;
                }
                // x보다 작은 값이면
                else if(nums[i] + nums[mid] < x){
                    L = mid + 1;
                }
                // 같이 x와 같으면
                else if(nums[i] + nums[mid] == x){
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }
}
