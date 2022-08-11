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
            int hour = 0;
            int min = 0;
            int radian = Integer.parseInt(br.readLine());
            if(radian >= 30){
                hour = radian / 30;
                min = (radian % 30) * 2;
            }
            else{
                min = radian * 2;
            }
            sb.append(hour + " " + min);
            System.out.println(sb);
        }
    }
}
