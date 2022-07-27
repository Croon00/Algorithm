import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();
            int sec = 0;
            int velocity = 0;
            int distance = 0;
            for(int i = 0; i < N; i++){

                int command = sc.nextInt();
                sec++;
                if(command == 0){
                    distance += velocity;
                }
                else if(command == 1){
                    int ac = sc.nextInt();
                    velocity += ac;
                    distance += velocity;
                }
                else if(command == 2){
                    int dc = sc.nextInt();
                    if(velocity - dc <= 0){
                        velocity = 0;
                    }
                    else{
                        velocity -= dc;
                    }
                    distance += velocity;
                }
            }
            System.out.println("#" + tc + " "+ distance);
        }
    }
}
