import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N;
        for(int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            int ascend = 0;
            int descend = 0;
            int[] block_arr = new int[N];
            for(int i = 0; i < N; i++){
                block_arr[i] = sc.nextInt();
            }

            for(int i = 0; i < N - 1 ; i++){
                if(block_arr[i] <= block_arr[i+1]){
                    int asd = block_arr[i+1] - block_arr[i];
                    if(ascend < asd){
                        ascend = asd;
                    }
                }
                else{
                    int dsd = block_arr[i] - block_arr[i+1];
                    if(descend < dsd){
                        descend = dsd;
                    }
                }
            }
            System.out.println("#" + tc + " " + ascend + " " + descend);
        }
    }
}