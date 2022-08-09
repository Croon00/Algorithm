import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int tc = 1; tc <= 10; tc++){
            StringBuilder sb = new StringBuilder();
            int T = sc.nextInt();
            ArrayList<Integer> num = new ArrayList<>();
            boolean deduction = false;
            for(int i = 0; i < 8; i++){
                num.add(sc.nextInt());
            }
            while(true){
                int minus = 1;
                for(int i = 0; i < 5; i++){
                    if(num.get(0) - minus > 0){
                        int temp = num.get(0) - minus;
                        num.remove(0);
                        num.add(temp);
                        minus++;
                    }
                    else{
                        num.remove(0);
                        num.add(0);
                        deduction = true;
                        break;
                    }
                }
                if(deduction == true){
                    break;
                }
            }
            for(int i = 0; i < num.size(); i++){
                sb.append(num.get(i)).append(" ");
            }
            System.out.println("#" + tc + " " + sb);
        }
    }
}
