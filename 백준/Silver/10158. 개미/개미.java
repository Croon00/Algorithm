import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        // w h 좌표
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        // x y 좌표
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int hour = Integer.parseInt(br.readLine());
        // w와 h의 2배의 길이만큼 움직이면 제자리로 돌아온다.

        // x랑 y를 일자로 시간 만큼 가게 한 후 2w로 나눈 나머지(2w의 몫은 제자리 이기 때문)는 지금 부터 이동하게 될 거리이다.
        int x_move = (x+hour) % (2 * w);
        int y_move = (y+hour) % (2 * h);

        // 값이 음수인 경우는 한 번 부딫쳤다 돌아오는 값이기 때문에 
        x = w - Math.abs(w-x_move);
        y = h - Math.abs(h-y_move);
        System.out.println(x + " " + y);
    }
}