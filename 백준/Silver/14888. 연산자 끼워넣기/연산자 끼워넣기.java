import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N; // 연산 할 값의 갯수
    static int [] A; // 연산 할 값들
    static int [] operand = new int[4]; // +, -, *, / 연산의 갯수
    static int MaxAns = -1000000001;
    static int MinAns = 1000000001;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        st = new StringTokenizer(br.readLine());

        // 연산 할 값들 받기
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        // 사용할 수 있는 연산자 갯수 받기
        for(int i = 0; i < 4; i++){
            operand[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, A[0]);
        System.out.println(MaxAns);
        System.out.println(MinAns);

    }

    // 우선순위 없이 앞에서부터 진행
    // 순열
    static void dfs(int depth, int number){
        // 연산은 N - 1개 만큼 한 경우 Max값과 Min 값 갱신
        if(depth == N - 1){
            MaxAns = Math.max(MaxAns, number);
            MinAns = Math.min(MinAns, number);

        }

        // 4개의 연산을 보면서
        for(int i = 0; i < 4; i++){
            // 해당 연산이 남았을 경우
            if(operand[i] > 0){
                // 연산의 횟수를 빼주고
                operand[i]--;
                dfs(depth + 1, cal(number, A[depth + 1], i));
                operand[i]++;
            }
        }
    }

    static int cal(int num1, int num2, int operand){
        // 더하기 일 때
        if(operand == 0){
            return num1 + num2;
        }
        // 빼기일 떄
        else if(operand == 1){
            return num1 - num2;
        }
        // 곱하기 일 때
        else if(operand == 2){
            return num1 * num2;
        }
        // 나누기 일 때
        else{
            return num1 / num2;
        }
    }
}
