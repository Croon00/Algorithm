import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int cnt = 1;
        boolean flag = false;

        while (B > A){
            String str = String.valueOf(B);
            // B의 마지막 숫자가 1이 아니거나, B가 짝수가 아니면 불가능함
            if(str.charAt(str.length() - 1) != '1' && B % 2 != 0){
                flag = false;
                break;
            }
            // 짝수 일때는
            if(B % 2 == 0){
                B = B/2;
            }
            // 짝수가 아닐 때는
            else{
                // 임시에다가 밑에 1을 빼놓고 넣어주고 이를 parseInt해서 넣기
                String temp = "";
                for(int i = 0; i < str.length() - 1; i++){
                    temp += str.charAt(i);
                }
                B = Integer.parseInt(temp);
            }
            cnt++;

            // 해당 값이 A랑 같아지면 끝내기
            if(B == A){
                flag = true;
                break;
            }
        }

        if(flag){
            System.out.println(cnt);
        }
        else{
            System.out.println(-1);
        }


    }


}

