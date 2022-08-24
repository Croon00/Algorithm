import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String s2 = st.nextToken();
            boolean same = true;
            // s 길이만큼 보면서 A, D, O, P, Q, R의 경우 구멍 하나, B는 구멍 2개, 그 외에는 구멍 X
            for(int i = 0; i < s.length(); i++){
                // 길이가 서로 다르면 다른 문자열
                if(s.length() != s2.length()){
                    same = false;
                    break;
                }
                // A, D, O, P, Q, R이 들어왔을 때에는 같은 구멍 하나만 뚫린 글자가 같은 위치에 있을 때 같은 글자라고 인식
                char a = s.charAt(i);
                if(a == 'A' || a == 'D' || a == 'O' || a == 'P' || a == 'Q' || a == 'R'){
                    if(s2.charAt(i) == 'A' || s2.charAt(i) == 'D' || s2.charAt(i) == 'O' || s2.charAt(i) == 'P' || s2.charAt(i) == 'Q' || s2.charAt(i) == 'R'){
                        continue;
                    }
                    else{
                        same = false;
                        break;
                    }
                }
                // B가 있는 위치의 경우 위 같은 B가 같은 위치에 있어야 같은 문자라고 인식
                else if(a == 'B') {
                    if(s2.charAt(i) == 'B'){
                        continue;
                    }
                    else{
                        same = false;
                        break;
                    }
                }
                // s에 구멍 하나 뚫린 문자나 B가 안 온 상태에서 s2에 해당 문자들이 같은 위치에 오면 같은 문자열이 아니다.
                else{
                    if(s2.charAt(i) == 'A' || s2.charAt(i) == 'D' || s2.charAt(i) == 'O' || s2.charAt(i) == 'P' || s2.charAt(i) == 'Q' || s2.charAt(i) == 'R' || s2.charAt(i) == 'B'){
                        same = false;
                        break;
                    }
                }
            }
            if(same){
                System.out.println("#" + tc + " SAME");
            }
            else{
                System.out.println("#" + tc + " DIFF");
            }
        }
    }
}
