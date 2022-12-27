import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    /*
        N주전자를 주문
        K명에게 똑같은 양

        N <= 1만
        k <= 100만

       막걸리 용량 == > 2^32 - 1보다 작거나 같은 자연수 또는 0,
        N <= K (주전자의 개수가 사람 수보다 많을 수 없다)

        K명에게 최대한의 많은 양의 막걸리를 분배할 수 있는 용량
     */



    static int N;
    static int K;
    static int MaxMl;

    static int [] ml;


   public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ml = new int[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            ml[i] = Integer.parseInt(st.nextToken());
            MaxMl = Math.max(MaxMl, ml[i]);
        }

       System.out.println(search());
    }

    static long search(){
        long L = 0;
        long R = Integer.MAX_VALUE;
        long ans = 0;

       while (L <= R){
           long mid = (L + R) / 2;

           if(check(mid)){
               ans = mid;
               L = mid + 1;
           }
           else{
               R = mid - 1;
           }
       }
       return ans;
    }

    static boolean check(long amount){

       if(amount == 0){
           return false;
       }

       int sum = 0;
       for(int i = 0; i < N; i++){
           sum += ml[i] / amount;
       }

       if(sum >= K){
           return true;
       }
       else {
           return false;
       }
    }
}