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
            int N = Integer.parseInt(br.readLine());

            String ans = br.readLine();
            String word = br.readLine();

            int alright = 0;

            for(int i = 0; i < N; i++){
                if(ans.charAt(i) == word.charAt(i)){
                    alright++;
                }
            }
            sb.append(alright);
            System.out.println(sb);
        }
    }
}