import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringBuilder sb = new StringBuilder();
            sb.append("#" + tc + " ");
            String cardList = br.readLine();
            // 스페이드 다이아몬드 하트 클로버 13장씩
            int [] S = new int[14];
            int [] D = new int[14];
            int [] H = new int[14];
            int [] C = new int[14];
            // 각각의 카드를 세는 cnt
            int s_cnt = 0;
            int d_cnt = 0;
            int h_cnt = 0;
            int c_cnt = 0;
            // 만약 겹치는 카드가 1개라도 있을 경우 false
            boolean Error = true;
            // cardList에서 문자를 발견했을 경우
            for(int i = 0; i < cardList.length() - 2; i++) {
                // 각각의 문자를 발견했을 경우
                // 문자 뒤에 0이 오면 그 다음 숫자의 카드 번호 ++
                // 문자 뒤에 1이 오면 1을 포함한 카드 번호 ++
                if (cardList.charAt(i) == 'S') {
                    if ( cardList.charAt(i + 1) == '0') {
                        S[Character.getNumericValue(cardList.charAt(i + 2))]++;
                    } else if(cardList.charAt(i+1) == '1') {
                        S[Integer.parseInt(cardList.substring(i + 1, i + 3))]++;
                    }
                }
                else if (cardList.charAt(i) == 'D') {
                    if (cardList.charAt(i + 1) == '0') {
                        D[Character.getNumericValue(cardList.charAt(i + 2))]++;
                    } else if(cardList.charAt(i+1) == '1') {
                        D[Integer.parseInt(cardList.substring(i + 1, i + 3))]++;
                    }
                }
                else if (cardList.charAt(i) == 'H') {
                    if (cardList.charAt(i + 1) == '0') {
                        H[Character.getNumericValue(cardList.charAt(i + 2))]++;
                    } else if(cardList.charAt(i+1) == '1'){
                        H[Integer.parseInt(cardList.substring(i + 1, i + 3))]++;
                    }
                }
                else if (cardList.charAt(i) == 'C') {
                    if (cardList.charAt(i + 1) == '0') {
                        C[Character.getNumericValue(cardList.charAt(i + 2))]++;
                    } else if(cardList.charAt(i+1) == '1'){
                        C[Integer.parseInt(cardList.substring(i + 1, i + 3))]++;
                    }
                }
            }
            // 1부터 13까지 새면서 2장 이상인 경우엔 바로 error 후 break
            // 나머지는 0장인 카드 만큼 필요함을 0일때 ++
            for(int i = 1; i < 14; i++){
                if(S[i] > 1 || D[i] > 1 || H[i] > 1 || C[i] > 1){
                    Error = false;
                    break;
                }
                if(S[i] == 0){
                    s_cnt++;
                }
                if(D[i] == 0){
                    d_cnt++;
                }
                if(H[i] == 0){
                    h_cnt++;
                }
                if(C[i] == 0){
                    c_cnt++;
                }
            }

            // Error 가 true인 경우에만 각각의 필요한 카드 보여주고 겹치는 카드 있을 경우 ERROR
            if(Error == true){
                sb.append(s_cnt + " " + d_cnt + " " + h_cnt + " " + c_cnt);
            }
            else{
                sb.append("ERROR");
            }
            System.out.println(sb);
        }
    }
}
