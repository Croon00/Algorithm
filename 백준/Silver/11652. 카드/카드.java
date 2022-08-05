import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N;
    static long card[];

    static void input(){
        FastReader fr = new FastReader();
        N = fr.nextInt();
        card = new long[N + 1];
        for(int i = 1; i <= N; i++){
            card[i] = fr.nextLong();
        }

    }

    static void sort(){
        Arrays.sort(card, 1, N + 1);

        int current_count = 1, mode_current= 1;
        long mode = card[1];

        for(int i = 2; i <= N; i++){

            if(card[i] == card[i - 1]){
                current_count++;
            }
            else {
                current_count = 1;
            }
            if(mode_current < current_count){
                mode_current = current_count;
                mode = card[i];

            }
        }
        sb.append(mode);

    }


    public static void main(String[] args) {
        input();
        sort();
        System.out.println(sb.toString());

    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));

        }
        String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        long nextLong(){
            return Long.parseLong(next());
        }
    }
}