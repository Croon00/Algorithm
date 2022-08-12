import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<Integer> card = new ArrayList<>();
        int max = 0;
        for(int i = 0; i < N; i++){
            card.add(sc.nextInt());
        }
        Collections.sort(card);

        for(int i = 0; i < N - 2; i++){
            for(int j = i + 1; j < N - 1; j++){
                for(int k = j + 1; k < N; k++){

                    int triple_card = card.get(i) + card.get(j) + card.get(k);
                    if( triple_card <= M){
                       max = Math.max(max, triple_card);
                    }
                }
            }
        }
        System.out.println(max);

    }
}