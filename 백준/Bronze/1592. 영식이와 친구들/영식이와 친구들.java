import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int [] people = new int[N];
        // 몇 번째 사람한테 줄지 Pcnt
        int Pcnt = 0;
        // 처음 0번째 사람 +1개
        people[Pcnt]++;
        // 몇 번 왔다갔다 하나 cnt에 저장
        int cnt = 0;
        // 무한 반복
        while(true){
            // 만약 그 해당 사람이 M번 까지 받았을 경우 break;
            if(people[Pcnt] == M){
                break;
            }
            // 홀수인 경우
            if(people[Pcnt] % 2 != 0){
                // 길이인 N 으로 나누어주어서 N번 을 넘어가는 경우 N으로 나누어서 나타내줌
                Pcnt = (Pcnt + L) % N;
            }
            // 짝수인 경우
            else{
                // 길이가 -L을 했을 경우 음수가 나올 수도 있음으로 N을 더 해준 후 N번을 나누어서 N을 넘지 않게 해줌
                Pcnt = (Pcnt - L + N) % N;
            }
            // 해당 사람이 받았으니 ++
            people[Pcnt]++;
            cnt++;

        }
        sb.append(cnt);
        System.out.println(sb);
    }
}
