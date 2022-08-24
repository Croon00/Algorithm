import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int ans = 0;
            st = new StringTokenizer(br.readLine());
            int cnt = 0;
            // 도시 수 만큼
            for(int i = 0; i < N; i++){
                // 게이트 웨이 받기
                int gateway = Integer.parseInt(st.nextToken());
                // 만약 게이트웨이가 없으면 cnt++
                if(gateway == 0){
                    cnt++;
                }
                else{
                    cnt = 0;
                }
                // cnt의 값이 D와 같아지면 게이트웨이가 필요함으로 ans++ 후 cnt를 0으로 초기화
                if(cnt == D){
                    ans++;
                    cnt = 0;
                }
            }
            System.out.println("#" + tc + " " + ans);
        }
    }
}
