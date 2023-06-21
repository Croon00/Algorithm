import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int spendMoney = Integer.parseInt(br.readLine());
        int resMoney = 1000 - spendMoney;

        int [] Changes = {500, 100, 50, 10, 5, 1};

        int ans = 0;

        while(resMoney > 0){
            if(resMoney >= 500){
                ans += resMoney / 500;
                resMoney %= 500;
            }
            else if(resMoney >= 100){
                ans += resMoney / 100;
                resMoney %= 100;
            }
            else if(resMoney >= 50){
                ans += resMoney / 50;
                resMoney %= 50;
            }
            else if(resMoney >= 10){
                ans += resMoney / 10;
                resMoney %= 10;
            }
            else if(resMoney >= 5){
                ans += resMoney / 5;
                resMoney %= 5;
            }
            else{
                ans += resMoney / 1;
                resMoney %= 1;
            }
        }

        System.out.println(ans);

    }
}
