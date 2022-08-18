import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int num = 2;
        int ans;
        // num 전에 있는 2의 제곱수를 구하기 위한 2제곱
        while(num < N){
            num *= 2;
        }
        // /2를 하여 전에 있는 2의 제곱수 구함
        num = num / 2;

        // 구하려는 값이 2보다 작을 경우 N - 이전 2의 제곱수 * 2의 값
        if(N > 2){
            ans = (N - num) * 2;
            sb.append(ans);
        }
        // 1 혹은 2의 값은 그대로 1, 2
        else{
            sb.append(N);
        }
        System.out.println(sb);
    }
}