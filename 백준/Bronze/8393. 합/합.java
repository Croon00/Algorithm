import java.util.*;
import java.io.*;

public class Main {

    // 구구단

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());


        int sum = 0;
        for(int i = 1; i <= N; i++){
            sum += i;
        }
        System.out.println(sum);
    }
}



