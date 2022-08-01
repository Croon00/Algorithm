

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int TC = sc.nextInt();
            int [] score_arr = new int[101];
            int amount = 0;
            int mode = 0;
            for(int i = 1; i < 1001; i++){
                int score = sc.nextInt();
                score_arr[score]++;
            }

            for(int i = 1; i < 101; i++){
                if(amount == score_arr[i]){
                    if(mode < i){
                        mode = i;
                    }
                }
                if(amount < score_arr[i]){
                    amount = score_arr[i];
                    mode = i;
                }
            }
            System.out.println("#" + TC + " " + mode);
        }
    }
}

