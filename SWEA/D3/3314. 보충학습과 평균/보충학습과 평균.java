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
            st = new StringTokenizer(br.readLine());
            int avg = 0;
            for(int i = 0; i < 5; i++){
              int num =  Integer.parseInt(st.nextToken());
              if(num < 40){
                  num = 40;
              }
              avg += num;
            }
            avg /= 5;

            sb.append(avg);
            System.out.println(sb);
        }
    }
}
