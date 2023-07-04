import java.util.*;
import java.io.*;

public class Main {

    /*
        라디오 버튼
        첫 번째 버튼 - 주파수를 1MHz 증가시킨다.
        두 번째 버튼 - 주파수를 1MHz 감소시킨다.
        나머지 N개의 버튼은 즐겨찾기 기능으로, 미리 지정된 주파수로 이동한다.
        가장 적은 버튼 수 구하기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()); // 현재 주파수
        int B = Integer.parseInt(st.nextToken()); // 듣고 싶은 주파수

        int N = Integer.parseInt(br.readLine());

        int [] hz = new int[1001];

        // 즐겨 찾기 되있는 주파수 1로 바꾸기
        for(int i = 0; i < N; i++){
            hz[Integer.parseInt(br.readLine())] = 1;
        }
        int presentHz = A;
        boolean flag = false;

        // 즐겨 찾기에 등록된 주파수일 경우 1번 클릭하면 된다.
        if(hz[B] == 1){
            System.out.println(1);
        }
        // 아닌 경우
        else {
            for(int i = 1; i <= 1000; i++){
                // 즐겨찾기 주파수 경우
                if(hz[i] == 1){
                    // 현재 주파수 값을 B에서 뺀 절대 값이 더 클때 바꾸기
                    if(Math.abs(B - presentHz) > Math.abs(B - i)){
                        flag = true;
                        presentHz = i;
                    }
                }
            }
            if(flag){
                // 즐겨찾기 버튼을 한 번 누른 경우
                System.out.println(Math.abs(B - presentHz) + 1);
            }
            else {
                // 아닌 경우 현재 주파수에서 바로 간다.
                System.out.println(Math.abs(B - A));
            }
        }
    }
}
