import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int [][] num = new int[N][N];
            int max = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    num[i][j] = sc.nextInt();
                }
            }

            for(int i = 0; i < N-M + 1; i++){
                for(int j = 0; j < N - M + 1; j++){
                    int sum = 0;
                    for(int k = 0; k < M; k++){
                        for(int l = 0; l < M; l++){
                            sum += num[i + k][j + l];
                        }
                    }
                    if(max < sum){
                        max = sum;
                    }
                }
            }
            System.out.println("#" + tc + " " + max);

        }


    }
}