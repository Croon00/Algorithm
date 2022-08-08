import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();

            if(C < A){
                System.out.println("#"+tc+" " + (A-C));
            }
            else if(C >= A && C <= B){
                System.out.println("#" + tc + " " + 0);
            }
            else{
                System.out.println("#" + tc +" " + -1);
            }
        }
    }
}