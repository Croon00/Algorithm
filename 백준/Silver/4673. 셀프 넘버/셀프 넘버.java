import java.util.*;
import java.io.*;

public class Main {

    // 셀프 넘버
    // 양의 정수 n에 대해서 d(n)을 n과 n의 자리수를  더하는 함수
    // 33--> 33 + 3 + 3 = 39 -> 39 + 3 + 9 = 51 -> 51 + 5 + 1 = 57
    // n을 d(n)의 생성자
    // 생성자가 없는 숫자를 셀프 넘버라고 함
    // 10000보다 작은 셀프넘버 구하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean [] ans = new boolean [10001];

        for(int i = 1; i < 10000; i++){

            int num = i;
            // 생성자 만들기
            // 만 이하로만
            while(true){
                String tempNum = String.valueOf(num);

                // 각 자리수 더하기
                for(int j = 0; j < tempNum.length(); j++){
                    num += Integer.parseInt(tempNum.substring(j, j + 1));
                }
                if(num > 10000) break;
                // 생성자가 존재한다.
                ans[num] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 10000; i++){
            if(!ans[i]) sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}



