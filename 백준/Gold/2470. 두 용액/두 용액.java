import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    /*
        산석 용액의 특성 값 1 ~ 10억
        알칼리 용액의 특성 값 -1 ~ -10억

        같은 양의 두 용액을 혼합해 0에 가까운 용액 만들기

        ex) [-2, 4, -99, -1, 98]인 경우 -99와 98인 용액 혼합 --> -1인 용액(0에 가장 가까움)

        정렬 후에 이분탐색으로 찾기
     */


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int [] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int L = 0;
        int R = A.length - 1;

        int minSum = Integer.MAX_VALUE;
        int idx1 = 0;
        int idx2 = 0;

        while (L < R){
            // 양 끝에 있는 값을 더했을 경우
            int sum = A[L] + A[R];

            // 최소 값이 sum 보다 큰 경우 갱신
            if(minSum > Math.abs(sum)){
                minSum = Math.abs(sum);
                idx1 = A[L];
                idx2 = A[R];
            }
            if(sum > 0){
                R--;
            }
            else{
                L++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(idx1).append(" ").append(idx2).append("\n");
        System.out.println(sb);
    }
}
