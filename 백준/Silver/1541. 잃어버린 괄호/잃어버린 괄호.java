
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // - 를  부분으로 나누어서 +부터 계산
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int sum = Integer.MAX_VALUE;
        // -가 있는 만큼 나누기
        StringTokenizer sub = new StringTokenizer(br.readLine(), "-");

        // sub가 있는 만큼
        while (sub.hasMoreElements()){
            int temp = 0;

            // +로 나누기
            StringTokenizer add = new StringTokenizer(sub.nextToken(), "+");

            while (add.hasMoreElements()){
                temp += Integer.parseInt(add.nextToken());
            }

            if(sum == Integer.MAX_VALUE){
                sum = temp;
            }
            else{
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}
