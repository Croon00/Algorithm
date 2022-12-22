import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    /*
        N개의 집 이 수직선위에
        좌표 x1 ~ xN (하나의 좌표에 하나의 집)

        최대한 많은 곳에서 와이파이를 사용하기 위해 공유기 설치
        한 집에 공유기 하나만 설치 가능
        두 공유기 사이의 거리를 최대한 하여 설치

        N개의 집 0 ~ 20만
        C의 공유기의 개수 2 ~ N개
        집의 좌표 x 0 ~ 10억

        // 가장 긴 사거리를 가진 사거리를 찾기
        // 완탐으론 오래 시간 초과 --> 완전탐색
     */
    static int N, C; // 집의 수, 공유기의 수
    static int [] X;


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        X = new int[N];

        // 집의 좌표
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            X[i] = Integer.parseInt(st.nextToken());
        }

        // 집마다 거리를 구하기 위한 오름차순으로 정렬
        Arrays.sort(X);

        System.out.println(search());

    }

    // C개 만큼의 공유기가 설치 가능한지 확인
    static boolean check (int distance){
        // 맨 첫 집 한개 설치
        int cnt = 1;
        int before_Point = X[0];
        for(int i = 1; i < X.length; i++){
            // 두 집 사이의 거리가 주어진 distance 이상인 경우
            if(X[i] - before_Point >= distance){
                // 공유기의 갯수가 증가 후
                // 이전 집의 좌표 바꾸기
                cnt++;
                before_Point = X[i];
            }
            // 두 집 사이의 거리가 주어진 distance보다 낮은 경우
            // 이전집의 좌표를 바꾸지 않고 넘어가기
        }
        // C개의 공유기를 썼을 경우만 true
        if(cnt >= C){
            return true;
        }
        return false;
    }

    // 최대 거리 찾기
    static int search(){
        int ans = 0;
        int L = 1;
        int R = 1000000000;

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
}
