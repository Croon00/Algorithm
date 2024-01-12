import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        String N = st.nextToken();

        int B = Integer.parseInt(st.nextToken());

        // B 진법의 수 N

        // 10진법으로 바꾸기



        int answer = 0;




        int multiple = 1;

        for(int i = N.length() - 1; i >= 0; i--){
            int num = 0;
            // 대문자 영어 값이면
            if(N.charAt(i) >= 'A' && N.charAt(i) <= 'Z'){
                num = N.charAt(i) - 'A' + 10;
            }
            // 숫자이면 그대로
            else{
                num = N.charAt(i) - '0';
            }

            answer += multiple * num;
            multiple *= B;
        }

        System.out.println(answer);


    }

}



