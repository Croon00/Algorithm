import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int A = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int bundaegi = Integer.parseInt(br.readLine());
        boolean end = false;
        int cnt = 0;
        int bunCnt = 0;
        int daegiCnt = 0;
        int round = 0;

        while (true){
            for(int i = 0; i < 4; i++){
                if(i % 2 == 0){
                    bunCnt++;
                }
                else{
                    daegiCnt++;
                }

                if(bundaegi == 0 && bunCnt == T){
                    end = true;
                    break;
                }
                else if(bundaegi == 1 && daegiCnt == T){
                    end = true;
                    break;
                }
                cnt++;
                if(cnt == A){
                    cnt = 0;
                }
            }
            if(end){
                break;
            }

            for(int i = 0; i < 4 + (round * 2); i++){
                if( i < (4 + (round * 2)) / 2){
                    bunCnt++;
                }
                else{
                    daegiCnt++;
                }

                if(bundaegi == 0 && bunCnt == T){
                    end = true;
                    break;
                }
                else if(bundaegi == 1 && daegiCnt == T){
                    end = true;
                    break;
                }
                cnt++;
                if(cnt == A){
                    cnt = 0;
                }
            }
            round++;
            if(end){
                break;
            }
        }
        System.out.println(cnt);
    }
}
