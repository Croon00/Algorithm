import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int money = Integer.parseInt(br.readLine());
        int five_won = 5;
        int two_won = 2;
        int coin_amount = 0;

        // 5원 이상이면 계속해서 빼기
        while(money > 0){

            // 5원으로 나누었을 때 0일 때만 5원 빼기
            if( money % five_won == 0){
                money -= five_won;
            }
            // 그 외에는 2원씩 빼기
            else{
                money -= two_won;
            }
            coin_amount++;
        }
        if(money == 0){
            System.out.println(coin_amount);
        }
        else{
            System.out.println(-1);
        }
    }
}
