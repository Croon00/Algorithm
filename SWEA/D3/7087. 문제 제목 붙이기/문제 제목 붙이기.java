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
            boolean [] alphabet = new boolean[27];
            int titleSize = Integer.parseInt(br.readLine());
            int cnt = 0;
            for(int i = 0; i < titleSize; i++){
                String s = br.readLine();
                alphabet[s.charAt(0) - 'A'] = true;
            }
            for(int i = 0; i < 27; i++){
                if(alphabet[i]){
                    cnt++;
                }
                else{
                    break;
                }
            }
            System.out.println("#" + tc + " " +cnt);
        }
    }
}