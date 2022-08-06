import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++){
            int ans = 0;
            int N;
            int M;
            N = sc.nextInt();
            M = sc.nextInt();
            int [] Ai = new int[N];
            int [] Bj = new int[M];
            for(int j = 0; j < N; j++){
                Ai[j] = sc.nextInt();
            }
            for(int j = 0; j < M; j++){
                Bj[j] = sc.nextInt();
            }

            if(N > M){
                int cnt = 0;

                for(int j = 0; j <= Ai.length - Bj.length; j++){

                    int sum = 0;
                    for(int k = 0; k < Bj.length; k++){
                        sum = sum + Bj[k] * Ai[cnt + k];
                    }
                    if(ans < sum){
                        ans = sum;
                    }
                    cnt++;
                }
            }

            else if(N < M){
                int cnt = 0;
                for(int j = 0; j <= Bj.length - Ai.length; j++){
                    int sum = 0;

                    for(int k = 0; k < Ai.length; k++){
                        sum = sum + Ai[k] * Bj[cnt + k];
                    }
                    if(ans < sum){
                        ans = sum;
                    }
                    cnt++;
                }
            }
            System.out.println("#" + i +" " + ans);
        }
    }
}