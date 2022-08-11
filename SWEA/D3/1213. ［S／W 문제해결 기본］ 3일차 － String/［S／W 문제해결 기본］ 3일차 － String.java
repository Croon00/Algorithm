import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            int T = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append("#" + T + " ");
            String searchString = br.readLine();
            String sentence = br.readLine();
            int count = 0;
            for(int i = 0; i <= sentence.length() - searchString.length(); i++){
                if(sentence.substring(i, i + searchString.length()).equals(searchString)){
                    count++;
                }
            }
            sb.append(count);
            System.out.println(sb);
        }
    }
}