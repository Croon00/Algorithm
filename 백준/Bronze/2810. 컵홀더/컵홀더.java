import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        String seat = br.readLine();
        // 사람 수
        int human = 0;
        // 컵 홀더 수 좌끝에 1개 후 우 끝에는 어차피 좌석이 더함
        int cupHold = 1;
        // 커플좌석을 세기 위한 cnt
        int Lcnt = 0;

        // 끝에는 이미 있음으로 seat의 -1 한 사이즈 까지
        for(int i = 0; i < seat.length(); i++){
            // S가 들어오면 컵홀더 한개 증가
            if(seat.charAt(i) == 'S'){
                cupHold++;
            }
            // L이 들어오면 Lcnt가 증가
            // Lcnt가 2개면 커플 한 좌석이 끝났음으로 cupHold++하고 Lcnt 초기화
            else if(seat.charAt(i) == 'L'){
                Lcnt++;
                if(Lcnt == 2){
                    cupHold++;
                    Lcnt = 0;
                }
            }
            // 시트 하나당 사람 한 명씩 증가
            human++;
        }

        // 컵홀더가 사람 이상있으면 모든 사람 컵홀더 사용 가능
        if(cupHold >= human){
            sb.append(human);
        }
        // 컵홀더가 사람보다 적으면 사람에서 컵홀더 뺀 값을 사람에서 뺀다.
        else{
            int temp = human - cupHold;
            sb.append(human - temp);
        }
        System.out.println(sb);
    }
}
