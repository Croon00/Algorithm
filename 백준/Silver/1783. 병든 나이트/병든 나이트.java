import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N;
        int M;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int ans = 0;
        if(N == 1){
            ans = 1;
        }
        else if(N == 2){
            // 이동 가능한건 위1 오2 or 아래 1 오2 그러나 3번까지만 가능하다.(시작 지점 포함 4이 최대)
            ans = Math.min( (M + 1) / 2, 4);
        }
        else{
            // N 이 3 이상부터는 위 아래로 와따 가따 하는게 제일 많이 함
            // 7 부터는 4방향 모두 가능하기 때문에 -2 를 해주어야 한다.(위 1 오2, 아래 1 오2 할때 2칸 사라짐)
            if(M < 7){
                ans = Math.min(M, 4);
            }
            else{
                ans = M - 2;
            }

        }
        System.out.println(ans);
    }
}
