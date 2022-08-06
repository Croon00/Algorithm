
import java.util.Scanner;

public class Solution {
    static int [][]  rotate (int[][] arr){
        int [][] rotated = new int [arr.length][arr.length];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                // 90 도로 돌리기 위해 3번째 줄 ([2]) 값의 첫 번째 값이 맨 위 왼쪽으로. 그 다음 2번째 줄 [1] 값의 첫 번째 값이 맨 위 가운데로
                rotated[i][j] = arr[arr.length - j - 1][i];
            }
        }
        return rotated;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();
            int [][] num = new int[N][N];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    num[i][j] = sc.nextInt();
                }
            }
            int[][] rotated90 = rotate(num);
            int[][] rotated180 = rotate(rotated90);
            int[][] rotated270 = rotate(rotated180);
            System.out.println("#"+tc);
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    System.out.print(rotated90[i][j]);
                }
                System.out.print(" ");
                for(int j = 0; j < N; j++){
                    System.out.print(rotated180[i][j]);
                }
                System.out.print(" ");
                for(int j = 0; j < N; j++){
                    System.out.print(rotated270[i][j]);
                }
                System.out.println();
            }
        }
    }
}
