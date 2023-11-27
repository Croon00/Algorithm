import java.util.*;
import java.io.*;

public class Main {

    // 기다란 벤치 모양의 식탁에 사람들과 햄버거가 단위 간격으로 놓임
    // 자신의 위치에서 거리가 K 이하인 햄버거를 먹을 수 있음.
    //

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 식탁 길이 1 ~ 2만
        int K = Integer.parseInt(st.nextToken()); // 햄버거를 선택할 수 있는 거리 1 ~ 10

        String desk = br.readLine();

        boolean [] check = new boolean[N];
        // 해당 햄버거로부터 가장 가까운 K 거리 이내의 사람에게 준다.

        int ans = 0;

        for(int i = 0; i < desk.length(); i++){
            if(desk.charAt(i) == 'H'){
                // 햄버거를 발견 했을 경우 현재 햄버거 위치의 -K만큼에서 +K만큼 범위에서
                int startIdx = i - K;
                // 0보다 낮은 경우는 0부터
                if(startIdx < 0) startIdx = 0;

                // 끝의 경우에는 N 이상이면 N - 1로
                int endIdx = i + K;
                if(endIdx >= N ) endIdx = N - 1;

                for(int j = startIdx; j <= endIdx; j++){
                    // 아직 햄버거를 못 먹은 사람일 경우에만 check하고 ++
                    if(!check[j] && desk.charAt(j) == 'P'){
                        check[j] = true;
                        ans++;
                        break;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}



