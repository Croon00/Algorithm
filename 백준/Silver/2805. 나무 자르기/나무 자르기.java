import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    /*
        나무의 배열이 주어졌을 때 적어도 M미터의 나무를 집에 가져가 위해서 절단기에 설정할 수 있는 높이의 최댓값 구하기

        나무의 높이를 정답으로 보아서 이분탐색으로 찾기 (완탐으로 찾으면 시간 초과)
     */
    static int N, M; // 나무의 수, 나무의 길이
    static int [] tree; // 나무 배열

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree = new int[N];

        st = new StringTokenizer(br.readLine());
        // 나무 높이 받기기
        for(int i = 0;i < N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }

        search();
    }

    // M미터 이상 가져가는지 확인
    static boolean check(int Height){
        long treeSum = 0;

        for(int i = 0; i < N; i++){
            // 자를 수 있는 경우에만
            if(tree[i] > Height){
                treeSum += tree[i] - Height;
            }
        }
        // 자르고 얻은 나무의 길이가 필요한 나무의 길이 이상일 경우 true
        if(treeSum >= M){
            return true;
        }
        // 아닐 경우 false;
        else{
            return false;
        }
    }

    static void search(){
        // 나무의 길이를 0 ~ 20억 까지 준 후 이분탐색으로 찾기
        int L = 0;
        int R = 2000000000;
        int ans = 0;

        // 최대한 높게 자른 값이 정답이어야 한다.
        while (L <= R){
            int mid = (L + R) / 2;

            // 해당 높이로 잘랐을 경우
            if(check(mid)){
                ans = Math.max(ans, mid);
                L = mid + 1;
            }
            else{
                R = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
