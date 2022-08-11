import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        int [] result = new int[N];
        int count_size = 1000001;
        int min = 0;


        for(int i = 0; i < N; i ++){
            arr[i] = Integer.parseInt(br.readLine());

            if(arr[i] < 0){
                min = Math.min(min, arr[i]);
            }
        }

        int [] count = new int[count_size + Math.abs(min)];

        for(int i = 0; i < N; i++){
            count[arr[i] + Math.abs(min)]++;
        }

        for(int i = 0; i < count.length - 1; i++){
            count[i+1] = count[i] + count[i+1];
        }

        for(int i = N - 1; i >= 0; i--){
            result[--count[arr[i] + Math.abs(min)]] = arr[i];
        }

        for(int i = 0; i < N; i++){
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }
}