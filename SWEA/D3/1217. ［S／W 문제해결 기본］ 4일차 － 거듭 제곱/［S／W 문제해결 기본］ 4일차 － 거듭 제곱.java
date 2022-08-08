import java.util.Scanner;

public class Solution {
    static int N, M, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int tc = 1; tc <= 10; tc++) {
            int T = sc.nextInt();
            N = sc.nextInt();
            M = sc.nextInt();
            k = 1;
            System.out.println("#" + T + " " +rec_func(N));
        }
    }

    static int rec_func(int n){
        if(k > M){
            return 1;
        }
        k++;
        return rec_func(n) * n;
    }
}