import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();
            int [] human = new int[N];
            int sum = 0;
            for(int i = 0; i < N; i++){
                human[i] = sc.nextInt();
                sum += human[i];
            }
            int avg = sum / N;
            int count = 0;
            for(int i = 0; i < N; i++){
                if(human[i] <= avg){
                    count++;
                }
            }
            System.out.println("#" + tc + " " + count);
        }
    }
}