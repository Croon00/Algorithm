import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String A = "AAAA";
        String B = "BB";

        st = new StringTokenizer(br.readLine());
        String Board = st.nextToken();

        // X 4개를 먼저 A로 바꾸어줌
        Board = Board.replace("XXXX", A);
        // 남은 것 중 X 2개를 B로 바꾸어줌
        Board = Board.replace("XX",B);

        // 바뀐 Board 중에 X가 포함되어있으면 -1 그외에는 sout
        if(Board.contains("X")){
            sb.append(-1);
        }
        else{
            sb.append(Board);
        }
        System.out.println(sb);
    }
}