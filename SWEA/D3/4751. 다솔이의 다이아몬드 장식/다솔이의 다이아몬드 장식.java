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
//            sb.append("#" + tc + " ");
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String sharp = "..#.";
            String sharp2 = ".#";
            String sharp3 = "#.";

            for(int i = 0; i < a.length(); i++){
                sb.append(sharp);
            }
            sb.append(".\n");

            for(int i = 0; i < a.length() * 2; i++){
                sb.append(sharp2);
            }
            sb.append(".\n");

            for(int i = 0; i < a.length(); i++){
                sb.append(sharp3 + a.charAt(i) + ".");
            }
            sb.append("#\n");

            for(int i = 0; i < a.length() * 2; i++){
                sb.append(sharp2);
            }
            sb.append(".\n");
            for(int i = 0; i < a.length(); i++){
                sb.append(sharp);
            }
            sb.append(".");
            System.out.println(sb);
        }
    }
}
