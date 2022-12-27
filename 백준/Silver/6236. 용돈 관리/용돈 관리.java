import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    /*
        N일동안 자신이 사용할 금액을 계산
        M번만 통장에서 돈 빼서 스기
        K원을 인출하며 통장에서 뺀 돈으로 하루 보낼 수 있으면 그대로 사용
        모자라게 되면 남은 금액 통장에 넣고 다시 K원 인출
        M이라는 숫자를 좋아하기 때문에 M번을 맞추기 위해서 남은 금액이 그날 사용할 금액보다 많더라도
        남은 금액은 통장에 집어넣고 다시 K원 인출 가능
        K를 최소화

        1 <= N <= 10만
        1 <= M <= N

        1 <= 금액 <= 1만
        
        1만 * 10만 하면 시간 초과 함으로 이분 탐색으로 찾기
     */

    static int N; // N일
    static int M; // M 번 통장
    static int [] money;
    static int minMoney;



   public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        money = new int[N];


        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            money[i] = Integer.parseInt(st.nextToken());
            // 적어도 하루 최대 값의 필요한 돈은 최소로 가져야 한다.
            minMoney = Math.max(minMoney, money[i]);
        }

       System.out.println(search());

    }

    static int search(){
       int L = minMoney;
       int R = 10000 * 100000; // 최소로 인출하려면 금액 * N의 최대
       int ans = 0;

       while (L <= R){
           int mid = (L + R) / 2;

           // 최소한의 금액을 골라야 한다.
           if(check(mid)){
               R = mid - 1;
               ans = mid;
           }
           // 아닌 경우
           else{
               L = mid + 1;
           }
       }
       return ans;
    }

    static boolean check(int don){
       int cnt = 1;
       int presentMoney = don;

       for(int i = 0; i < N; i++){
           // 오늘 필요한 돈을 뺐을 때 가능하면 뺀 후 가져가기
           if(presentMoney - money[i] >= 0){
               presentMoney = presentMoney - money[i];
           }
           // 아닌 경우 다시 돈을 인출하고 거기서 오늘 필요한 돈 빼기 후 cnt++
           else{
               presentMoney = don - money[i];
               cnt++;
           }
       }
       // M번 이하 한 경우 true(어차피 M번 맞추려고 하면 이하는 다 가능)
       if(cnt <= M){
           return true;
       }
       // 나머지는 false
       else{
           return false;
       }
    }

}