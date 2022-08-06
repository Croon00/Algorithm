import java.util.Scanner;


public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();
            int[] price_arr = new int [N];
            long profit = 0;

            for(int i = 0; i < N; i++) {
                long price = sc.nextInt();
                price_arr[i] = (int) price;
            }

            long max_price = price_arr[N-1];

            for(int i = N-1; i >= 0; i--){
                if(max_price >= price_arr[i]){
                    profit += max_price - price_arr[i];
                }
                else{
                    max_price = price_arr[i];
                }
            }
            System.out.println("#" + tc + " " + profit);
        }
    }
}