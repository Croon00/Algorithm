import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#" + tc + " ");
            String ironStick = br.readLine();
            ArrayList<Character> stick = new ArrayList<>();
            for(int i = 0; i < ironStick.length(); i++){
                stick.add(ironStick.charAt(i));
            }
            // 레이저로 추가되는 막대기를 세기 위한 cnt
            int cnt = 0;
            // 총 막대기 수
            int totalStick = 0;
            
            // () 길이만큼 막대기를 더하고 줄이는 for문
            for(int i = 0; i < ironStick.length(); i++){
                // ( 바로 다음 )가 오면 레이저 임으로 여태 까지 안 닫힌 막대기 개수만큼 더 해준다.
                if(stick.get(i) == '(' && stick.get(i+1) == ')'){
                    totalStick += cnt;
                }
                // ( 바로 다음 )가 안 오는 경우 막대기가 1개 추가된다.
                else if(stick.get(i) == '(' && stick.get(i+1) !=')'){
                    cnt++;
                    totalStick++;
                }
                // (가 없는 )의 경우 현재 막대기 개수를 1개 빼준다.
                else if(stick.get(i) == ')' && stick.get(i-1) !='('){
                    cnt--;

                }
            }
            sb.append(totalStick);
            System.out.println(sb);
        }
    }
}