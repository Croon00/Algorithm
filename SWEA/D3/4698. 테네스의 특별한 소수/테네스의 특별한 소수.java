import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        // 테케
        int [] prime = new int[1000001];
        // 2부터 소수 배열까지
        for(int i = 2; i < prime.length; i++){
            // i를 2로 두고 j 값을 올려가면서 곱해서 나온 값은 소수가 아님
            int j = 2;
            while (true){
                // B의 크기를 넘어가면 범위를 넘어감으로 구할 필요 없다.
                if(i * j > 1000000){
                    break;
                }
                prime[i * j]++;
                j++;
            }
        }
        for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#" + tc + " ");
            st = new StringTokenizer(br.readLine());

            // D, A, B
            String D = st.nextToken();
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int ans = 0;
            if(A == 1){
                A = 2;
            }
            // 소수를 담는 배열

            // A 이상 B 이하에서
            for(int i = A; i <= B; i++){
                // 해당 i 값이 소수일 경우
                if(prime[i] == 0){
                    String temp = String.valueOf(i);
                    // D를 포함하고 있을 때 ans++
                    if(temp.contains(D)){
                        ans++;
                    }
                }
            }
            sb.append(ans);
            System.out.println(sb);
        }
    }
}
