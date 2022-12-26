import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    /*
        가능한 한 최대의 총 예산을 배정

        1. 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정한다.
        2. 모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 계산하여 그 이상인 예산 요청에는 모두 상한액을 배정

        // 금액을 이분 탐색으로 찾기
     */

    static int N, M, MaxPrice; // 지방의 수 N(3 ~ 1만 이하), 총 예산 M (N이상 10억 이하)
    static int [] price;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        price = new int[N];

        st = new StringTokenizer(br.readLine());


        for(int i = 0; i < N; i++){
            price[i] = Integer.parseInt(st.nextToken());
            MaxPrice = Math.max(MaxPrice, price[i]);
        }

        M = Integer.parseInt(br.readLine());

        System.out.println(search());

    }

    static int search(){
        int L = 0;
        int R = MaxPrice;
        int ans = 0;

        while (L <= R){
            int mid = (L + R) / 2;

            if(check(mid)){
                L = mid + 1;
                ans = mid;
            }
            else{
                R = mid - 1;
            }
        }
        return ans;
    }

    static boolean check(int money){
        int cnt = 0;
        // money에 값을 각 지방에서 요청한 예산에서 뺏을때 0 이상인 경우
        for(int i = 0; i < N; i++){
            // 각 지방에서 요청한 값 - 상한액 <= 0 이면 각 지방에서 요청한 값만 더한다.
            if(price[i] - money <= 0){
                cnt += price[i];
            }
            // 0 이상인 경우 상한액을 더한다.
            else{
                cnt += money;
            }
        }
        if(cnt <= M){
            // 총 예산과 같거나 낮은 경우
            return true;
        }
        else{
            return false;
        }
    }
}