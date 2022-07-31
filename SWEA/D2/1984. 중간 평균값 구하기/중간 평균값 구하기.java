import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            double sum = 0.0;
            int max = 0; int min = 10000;

            for (int j = 0; j < 10; j++) {
                int num = sc.nextInt();
                sum += num;
                if (max < num) max = num;
                if (min > num) min = num;
            }
            sum -= max + min;
            System.out.println("#"+tc+" "+Math.round(sum/8));
        }
    }
}
