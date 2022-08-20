import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;

    static void process(){
        int M = N;
        int count = 0;

        while(true){
            if(M % 5 == 0){
                count += M / 5;
                System.out.println(count);
                break;
            }
            else{
                M -= 3;
                count++;
            }
            if (M < 0){
                System.out.println(-1);
                break;
            }

        }
    }


    static void Input(){
        FastReader sc = new FastReader();
        N = sc.nextInt();

    }

    public static void main(String[] args) {
        Input();
        process();
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