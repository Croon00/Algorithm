import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader sc = new FastReader();
    static int N;
    public static void main(String[] args) {
        N = sc.nextInt();
        int count = 1;
        int count2 = (N * 2) - 3;
        for (int i = 1; i < N * 2; i++){

            if(i <= N){
                for (int j = i; j < N; j++){
                    System.out.print(' ');
                }
                for (int k = 1; k <= count; k++){
                    System.out.print('*');
                }
                count = count + 2;
                System.out.println();
            }

            else{
                for (int j = N + 1; j <= i ; j++){
                    System.out.print(' ');
                }
                for (int k = 1; k <= count2; k++){
                    System.out.print('*');
                }
                System.out.println();
                count2= count2 - 2;
            }
        }
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            if(st == null || !st.hasMoreElements()) {
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

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
