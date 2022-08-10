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
            String N = br.readLine();
            // 0~9 까지의 다양성을 체크할 불리언
            boolean [] num = new boolean[10];
            // 다양성
            int diversity = 0;

            // N의 크기만큼 보면서 하나의 숫자씩 charAt(i)-'0'을 받아오고 이를 string으로 바꾸었다가 int로 바꿈
            for(int i = 0; i < N.length(); i++){
               int n = Integer.parseInt(String.valueOf(N.charAt(i)-'0'));
               // 아직 한 번도 체크 안 한 것이면 다양성 올리고 true로 바꿈
               if(num[n] == false){
                    diversity++;
                    num[n] = true;
               }
            }
            sb.append(diversity);
            System.out.println(sb);
        }
    }
}