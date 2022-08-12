import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        boolean [][] area = new boolean[102][102];
        int N = Integer.parseInt(br.readLine());

        boolean check = false;
        int count = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int j = x; j < x + 10; j++){
                for(int k = y; k < y + 10; k++){
                    area[j + 1][k + 1] = true;
                }
            }
        }

        for(int i = 0; i < 102; i++){
            for(int j = 0; j < 102; j++){
                if(check != area[i][j]){
                    check = area[i][j];
                    count++;
                }
            }
        }

        for(int i = 0; i < 102; i++){
            for(int j = 0; j < 102; j++){
                if(check != area[j][i]){
                    check = area[j][i];
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
