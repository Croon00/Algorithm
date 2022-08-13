import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Integer [] tip = new Integer[N];
        int temp_tip = 0;
        long max_tip = 0;
        for(int i = 0; i < N; i++){
            tip[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(tip,Collections.reverseOrder());
        for(int i = 0; i < N; i++){
            temp_tip = tip[i] - i;
            if(temp_tip < 0){
                continue;
            }
            else{
                max_tip += temp_tip;
            }
        }
        sb.append(max_tip);
        System.out.println(max_tip);
    }
}