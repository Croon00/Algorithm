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
            StringBuilder sb = new StringBuilder();
            sb.append("#" + tc + " ");
            // 5줄에 받을 String
            String [] temp = new String[5];
            // 각 줄마다 String의 문자를 하나씩 받을 s
            String s [][] = new String[5][16];

            // 5줄 받기
            for(int i = 0; i < 5; i++){
                temp[i] = br.readLine();
            }
            // 5줄 동안 해당 문자열에 대한 길이만큼 문자 하나씩 배열에 받기
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < temp[i].length(); j++){
                    s[i][j] = String.valueOf(temp[i].charAt(j));
                }
            }

            // 열부터 읽기, null이 아닌 경우에만 넣는다.
            for(int i = 0; i < 16; i++){
                for(int j = 0; j < 5; j++){
                    if(!(s[j][i] == null)){
                        sb.append(s[j][i]);
                    }
                }
            }
            System.out.println(sb);
        }
    }
}
