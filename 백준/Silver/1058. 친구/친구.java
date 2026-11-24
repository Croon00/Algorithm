import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        String [] friends  = new String[N];

        for (int i = 0; i < N; i++){
            friends[i] = br.readLine();
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            boolean[] check = new boolean[N];

            for (int j = 0; j < N; j++) {
                if (friends[i].charAt(j) == 'Y') {
                    check[j] = true; 

                    for (int k = 0; k < N; k++) {
                        if (friends[j].charAt(k) == 'Y') {
                            check[k] = true; 
                        }
                    }
                }
            }

            check[i] = false;

            int count = 0;
            for (boolean isFriend : check) {
                if (isFriend) count++;
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}