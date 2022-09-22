import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, M, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i = 1; i <= 10; i++){
            int T = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            System.out.println("#" + T + " " + rec(N, M));
        }

    }
    static int rec(int n , int m){
        if(m == 1){
            return n;
        }
        if(m % 2 == 0){
            return rec(n, m/2) * rec(n, m/2);
        }
        else{
            return rec(n, m/2) * rec(n, m/2)*n;
        }
    }
}