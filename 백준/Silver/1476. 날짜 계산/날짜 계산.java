import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int eCnt = 1;
        int sCnt = 1;
        int mCnt = 1;

        int ans = 1;
        while (true){
            // 같은 경우 끝내자
            if(eCnt == E && sCnt == S && mCnt == M){
                break;
            }
            // 같지 않을 경우 1년도 뒤로
            else{
                eCnt++;
                sCnt++;
                mCnt++;
                ans++;
            }

            if(eCnt == 16) eCnt = 1;
            if(sCnt == 29) sCnt = 1;
            if(mCnt == 20) mCnt = 1;
        }
        System.out.println(ans);
    }
}
