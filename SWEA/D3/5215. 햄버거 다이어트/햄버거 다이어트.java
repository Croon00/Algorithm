import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, L;
    static int maxHamburger;
    static int[] taste, calorie;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#" + tc + " ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            maxHamburger = 0;
            taste = new int[N];
            calorie = new int[N];
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                taste[i] = Integer.parseInt(st.nextToken());
                calorie[i] = Integer.parseInt(st.nextToken());
            }
            rec(0, 0, 0);
            System.out.println("#" + tc + " " + maxHamburger);
        }
    }

    static void rec(int n, int sum_taste, int sum_calorie ){

        if(sum_calorie > L){
            return;
        }
        if(n == N){
            if(maxHamburger < sum_taste){
                maxHamburger = sum_taste;
            }
            return;
        }

        rec(n + 1,sum_taste + taste[n], sum_calorie + calorie[n]);
        rec(n + 1, sum_taste, sum_calorie);
    }
}