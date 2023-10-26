import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 문자열 S, T가 주어졌을 때 S를 T로 바꾸는 게임
        // 문자열 뒤에 A를 추가한다 or 무낮열을 뒤집고 뒤에 B를 추가한다
        // 위 주어진 조건으로 S를 T로 만들 수 있는지 없는지 알아내기

        String S = br.readLine();
        String T = br.readLine();

        int answer = -1;
        // 역으로 T에서 S로 제거하면서 만들어서 가능하면 될거 같음


        while(true){
            // 맨 뒤에 있는게 A면 삭제
            if(T.charAt(T.length() - 1) == 'A'){
                T = T.substring(0, T.length() - 1);
            }
            // 뒤에 B 삭제하고 거꾸로 하기
            else{
                String temp = "";
                for(int i = T.length() - 2; i >= 0; i--) {
                    temp += T.charAt(i);
                }
                T = temp;

            }
            if(S.equals(T)){
                answer = 1;
                break;
            }
            // 크기 같은데도 같지 않으면 실패
            if(S.length() == T.length()){
                answer = 0;
                break;
            }
        }

        System.out.println(answer);

    }
}



