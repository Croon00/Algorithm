import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;



public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        String str2 = br.readLine();

        // 하나 더 늘려서 0에서 더하게 하기 위해
        int [][] Dp = new int[str.length() + 1][str2.length() + 1];

        for(int i = 1; i <= str.length(); i++){
            for(int j = 1; j <= str2.length(); j++){
                // 같을 경우
                if(str.charAt(i - 1) == str2.charAt(j - 1)){
                    Dp[i][j] = Dp[i - 1][j - 1] + 1;
                }
                // 같지 않을 경우 위랑 왼쪽에서 큰 거로
                else{
                    Dp[i][j] = Math.max(Dp[i - 1][j], Dp[i][j - 1]);
                }
            }
        }
        System.out.println(Dp[str.length()][str2.length()]);

    }
}