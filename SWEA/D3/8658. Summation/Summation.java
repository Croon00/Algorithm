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
            StringBuilder sb = new StringBuilder();
            sb.append("#" + tc + " ");

            int max = 0;
            int min = Integer.MAX_VALUE;

            for(int i = 0; i < 10; i++){
                String num = st.nextToken();
                int sum = 0;
                for(int j = 0; j < num.length(); j++){
                    sum += Character.getNumericValue(num.charAt(j));

                }
                max = Math.max(max, sum);
                min = Math.min(min, sum);
            }
            sb.append(max + " " + min);
            System.out.println(sb);
        }
    }
}