import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int [] tall = new int[9];
        for(int i = 0; i < 9; i++){
            tall[i] = Integer.parseInt(br.readLine());
            sum += tall[i];
        }
        for(int i = 0; i < 8; i++){
            for(int j = i + 1; j < 9; j++){
                if(sum - tall[i] - tall[j] == 100){
                    tall[i] = 0;
                    tall[j] = 0;
                    Arrays.sort(tall);
                    for(int k = 2; k < 9; k++){
                        System.out.println(tall[k]);
                    }
                    return;
                }

            }
        }
    }
}