import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        boolean possible = false;

        // 1 부터 N 까지
        for(int i  = 1; i < N; i++){
            // 해당 숫자의 길이를 세기 위해 String으로 바꾸기
            String str = String.valueOf(i);
            // num 에 i
            int num = i;
            // String의 길이를 구하기
            int len = str.length();
            // 길이 만큼 해당 숫자를 누적합하기
            for(int j = 0; j < len; j++){
                 num += str.charAt(j) -'0';
            }
            // 이 누적합 한 값이 같을 경우 i를 출력하고 break;
            if(num == N){
                possible = true;
                System.out.println(i);
                break;
            }
        }
        // 생성자가 없는 경우 0 으로 출력
        if(!possible){
            System.out.println(0);
        }
    }
}