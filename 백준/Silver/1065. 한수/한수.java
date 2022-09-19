import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int x, cnt;
    // 최대 값이 999이다.
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        x = Integer.parseInt(br.readLine());
        cnt = 0;

        count(x);
        System.out.println(cnt);
    }
    static void count (int x){
        if(x < 100){
            // 100 밑은 그냥 x 값
            cnt = x;
        }
        else{
            // 100 밑의 값들은 다 해서 99개
            cnt = 99;
            
            // 100의 자리 10의 자리 일의 자리를 
            for(int i = 100; i <= x; i++){
                int a = i / 100;
                int b = (i % 100) / 10;
                int c = i % 10;

                // 비교해서 차가 같을 경우
                if((a - b) == (b - c)){
                    cnt++;
                }
            }
        }
    }
}