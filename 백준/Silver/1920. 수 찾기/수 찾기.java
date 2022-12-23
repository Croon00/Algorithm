import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    /*
        N개의 정수를 가진 A배열에 M개의 수들이 A안에 존재하는지 확인하기
        모든 정수의 범위 -2^31 ~ 2^31 사이

        N은 1 ~ 100000사이
        M은 1 ~ 100000 사이이


        // 완탐으로 하면 시간초과 함으로
        // 이분탐색으로 찾기
     */

    static int N, M;
    static int [] A;


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 이분탐색으로 찾기위한 정렬
        Arrays.sort(A);

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        // M개의 수
        for(int i = 0; i < M; i++){
            int num = Integer.parseInt(st.nextToken());
            sb.append(search(num)).append("\n");
        }

        System.out.println(sb);
    }

    static int search(int num){
        int L = 0;
        int R = A.length - 1;
        int ans = 0;

        // 이분 탐색으로
        while (L <= R){
            int mid = (L + R) / 2;
            // 만약 num이 중간에 있는 값보다 크면
            if(num > A[mid]){
                L = mid + 1;
            }
            // num이 중간 값보다 작으면
            else if(num < A[mid]){
                R = mid - 1;
            }
            // 값이 같으면
            else if(num == A[mid]){
                ans = 1;
                break;
            }
        }
        return ans;
    }
}
