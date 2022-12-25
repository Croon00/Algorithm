import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    /*
        박성원 -> N개의 랜선 필요
        오영식 -> K개의 랜선 (길이가 제각각)
        모두 N개의 같은 길이의 랜선 만들기--> K개의 랜선을 잘라서 만들어야함

        k개의 랜선으로 N개의 랜선 만들수 없는 경우

        자를 때는 항상 센티미터 단위로 정수길이만큼 자름

        K는 1 이상 1만 이하 정수

        N은 1 이상 10만 이하의 정수

        항상 K <= N

        랜선의 길이 = 2^31승 - 1 보다 작거나 같은 자연수수
     */


    static int N, K;    static int [] Lan;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        Lan = new int[N];

        for(int i = 0; i < K; i++){
            Lan[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(search());

    }

    static long search(){
        long L = 1;
        long R  = Integer.MAX_VALUE;
        long ans  = 0;

        // L 이 R 초과할 경우 까지
        while (L <= R){
            long mid = (L + R) / 2;
            int cnt = 0;
            for(int i = 0; i < N; i++){
                cnt += Lan[i] / mid;
            }

            // cnt 갯수가 N 이상일 경우 ans 는 mid고 L 은 mid + 1의 값으로 한다.
            if(cnt >= N){
                ans = mid;
                L = mid + 1;
            }

            // 아닌 경우 R = mid - 1
            else{
                R = mid - 1;
            }
        }
        return ans;
    }
}