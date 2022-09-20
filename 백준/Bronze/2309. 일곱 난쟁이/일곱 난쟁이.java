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
        boolean complete = false;
        for(int i = 0; i < 9; i++){
            tall[i] = Integer.parseInt(br.readLine());
            sum += tall[i];
        }

        for(int i = 0; i < 8; i++){
            for(int j = i + 1; j < 9; j++){
                if(sum - tall[i] - tall[j] == 100){
                    tall[i] = -1;
                    tall[j] = -1;
                    complete = true;
                    break;
                }
            }
            if(complete == true){
                break;
            }
        }
        Arrays.sort(tall);
        for(int i = 2; i < 8; i++){
            sb.append(tall[i]).append("\n");
        }
        sb.append(tall[8]);
        System.out.println(sb);
    }
}