import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#" + tc + " ");
            // 문자열 길이와, 암호문
            int numLength;
            String password;
            ArrayList<Integer> passwordInt = new ArrayList<Integer>();
            st = new StringTokenizer(br.readLine());

            numLength = Integer.parseInt(st.nextToken());
            password = st.nextToken();

            for(int i = 0; i < numLength; i++){
                String temp = String.valueOf((password.charAt(i)-'0'));
                passwordInt.add(Integer.parseInt(temp));
            }
            // 소거가 모두 되었는지 확인
            boolean ans;
            
            // 소거가 모두 될때까지 반복
            while(true){
                ans = true;
                // 삭제해야할 인덱스
                int temp_idx = 0;
                
                // 값이 같은게 있으면 소거 안댐
                for(int i = 0; i < passwordInt.size() - 1; i++){
                    if(passwordInt.get(i) == passwordInt.get(i + 1)){
                        ans = false;
                        temp_idx = i;
                    }
                }

                // 같은 값이 없다면 반복문 나오기
                if(ans == true){
                    break;
                }
                // 삭제해야할 인덱스 2개 삭제
                passwordInt.remove(temp_idx);
                passwordInt.remove(temp_idx);

            }

            for(int i = 0; i < passwordInt.size(); i++){
                sb.append(passwordInt.get(i));
            }
            System.out.println(sb);
        }
    }
}
