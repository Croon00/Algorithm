import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    /*
        N개의 강의가 존재
        강의의 순서 바뀌면 안된다.
        M개의 블루레이에 모든 기타 강의 동영상을 녹화

        N (1 <= N <= 10만) 과 (1 <= M <= N)

        1만분을 넘지 않고 N의 최대가 10만이기 때문에 곱해서 나오는 10이 최대 강의 길이;


     */
    static int N, M, minLength;
    static int [] videoLength;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        videoLength = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            videoLength[i] = Integer.parseInt(st.nextToken());
            minLength = Math.max(minLength, videoLength[i]);
        }
        

        System.out.println(search());
    }

    static int search(){
        int L = minLength; // 영상의 최소 길이
        int R = 1000000000;
        int ans = 0;

        while (L <= R){
            int mid = (L + R) / 2;

            // 최소의 크기를 출력
            if(check(mid)){
                ans = mid;
                R = mid - 1;
            }
            else {
                L = mid + 1;
            }
        }
        return ans;
    }

    static boolean check(int min){
        int cnt = 1;
        int sum = 0;
        for(int i = 0; i < N; i++){
            // sum에서 해당 분을 더한 것이 영상 길이보다 크면
            if(sum + videoLength[i] > min){
                // cnt 추가랑 sum은 해당 영상 길이를 들고가게 한다.
                cnt++;
                sum = videoLength[i];
            }
            // 누적해서 더 하기
            else{
                sum += videoLength[i];
            }
        }
        if(cnt <= M){
            return true;
        }
        else {
            return false;
        }
    }

}