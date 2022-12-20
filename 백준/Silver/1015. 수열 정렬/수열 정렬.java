import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    /*
        P[0] ~~ P[N-1] 는 0 부터 N-1 까지의 수를 한 번씩 포함하고 있는 수열
        배열 A 가 있을 때 수열 P를 적용한 결과(배열 B)가 비내림차순이 되는 수열을 찾는 프로그램
     */
    // 수열 P 또한 출력할때 P[0] ~ P[N-1]로 출력해서 보여주어야 한다.

    // B 배열이 가질 num과 idx B배열에서 B[0] ~ B[N - 1] 가 가진 값이 정렬되어 있어야한다.

    // 예제 입력 1 ex)
    // A[0(idx)] = 2, A[1] = 3, A[2] = 1 에다가 P를 적용하면 배열 B가 되는데 이 배열 B는 A의 오름차순이여야 함으로 밑에와 같이
    // B[P[2](idx)] = A[2] = 1, B[P[0]] = A[0] = 2, B[P[1]]] = A[1] = 3 이라고 볼 수 있고 B는 정렬 된 것임으로
    // P[2] = 0, P[0] = 1, P[1] = 2이다.
    // 따라서 P[0] = 1, P[1] = 2, P[2] = 0 이 출력 된다.
    static class Elements implements  Comparable<Elements>{
        int num, idx;


        @Override
        public int compareTo(Elements o) {
            if(num == o.num){
                // 같을 경우 사전순으로(숫자가 같을 경우 idx 오름차순으로)
                return this.idx - o.idx;
            }
            // 비내림차순임으로 오름차순으로 정렬
            return this.num - o.num;
        }
    }


    static int N;
    static int[] P;
    static int [] A;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        P = new int[N];

        st = new StringTokenizer(br.readLine());
        // 주어진 배열 A
        A = new int[N];

        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        //
        Elements[] B = new Elements[N];
        for(int i = 0; i < N; i++){
            B[i] = new Elements();
            B[i].num = A[i];
            B[i].idx = i;
        }

        // 비내림차순(오름차순으로 정렬)
        Arrays.sort(B);

        // 정려된 B[i]의 idx가 가지고 있는 값이 수열 P에 들어감
        for(int i = 0; i < N; i++){
            P[B[i].idx] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(P[i]).append(" ");
        }

        System.out.println(sb);


    }
}
