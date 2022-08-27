import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int [] cawNumArr = new int[11];
        int cnt = 0;
        // 소 1이상 10 이하의 번호에 -1로 초기화
        for(int i = 1; i < cawNumArr.length; i++){
            cawNumArr[i] = -1;
        }
        // N번의 횟수를 세는 동안
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            // 소의 번호와 있는 장소 받기
            int cawNum = Integer.parseInt(st.nextToken());
            int place = Integer.parseInt(st.nextToken());
            // 해당 번호를 가진 소가 0일때 1이 들어오면 cnt++
            if(cawNumArr[cawNum] == 0 && place == 1){
                cnt++;
            }
            // 반대로 1일때 0이 들어와도 ++
            else if(cawNumArr[cawNum] == 1 && place == 0){
                cnt++;
            }
            // 그 후 해당 번호의 소는 해당 장소로 간다.
            cawNumArr[cawNum] = place;
        }
        System.out.println(cnt);
    }
}