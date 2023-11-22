import java.util.*;
import java.io.*;

public class Main {

    // 구구단

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 9; i++){
            sb.append(N + " * " + i + " = " + N * i).append("\n");
        }

        System.out.println(sb);
    }
}



